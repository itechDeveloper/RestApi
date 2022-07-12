<?php
// Headers
header('Access-Control-Allow-Origin: *'); // completely public. anyone can reach to this api
header('Content-Type: application/json');

include_once '../../config/Database.php';
include_once '../../models/Post.php';

// Instantiate Database & Connect
$database = new Database();
$db = $database->connect();

// Instantiate Post Object
$post = new Post($db);

// Post query
$result = $post->read();

// Get row count
$count = $result->rowCount();

// Check if any posts
if ($count > 0){
    // Post array
    $post_array = array();
    $posts_array['data'] = array();

    while ($row = $result->fetch(PDO::FETCH_ASSOC)){
        extract($row);

        $post_item = array(
            'id' => $id,
            'info' => $info
        );

        // Push to 'data'
        array_push($posts_array['data'], $post_item);
    }

    // Turn to JSON & output
    echo json_encode($posts_array);
}else{
    // No posts
    echo json_encode(
        array('message' => 'No posts found')
    );
}