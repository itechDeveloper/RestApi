<?php
// Headers
header('Access-Control-Allow-Origin: *'); // completely public. anyone can reach to this api
header('Content-Type: application/json');

include_once '../../config/Database.php';
include_once '../../models/Post.php';

// Instantiate Database & Connect
$database = new Database();
$db = $database->connect();

// Instantiate Category Object
$category = new Category($db);

// Category query
$result = $category->read();

// Get row count
$count = $result->rowCount();

// Check if any posts
if ($count > 0){
    // Post array
    $category_array = array();
    $category_array['data'] = array();

    while ($row = $result->fetch(PDO::FETCH_ASSOC)){
        extract($row);

        $category_item = array(
            'id' => $id,
            'category' => $category
        );

        // Push to 'data'
        array_push($category_array['data'], $category_item);
    }

    // Turn to JSON & output
    echo json_encode($category_array);
}else{
    // No posts
    echo json_encode(
        array('message' => 'No posts found')
    );
}