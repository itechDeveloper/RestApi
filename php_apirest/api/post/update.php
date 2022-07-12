<?php

// Headers
header('Access-Control-Allow-Origin: *'); // completely public. anyone can reach to this api
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: PUT');
header('Access-Control-Allow-Headers: Access-Control-Allow-Headers, Content-Type, Access-Control-Allow-Methods, Authorization, X-Requested-With');

include_once '../../config/Database.php';
include_once '../../models/Post.php';

// Instantiate Database & Connect
$database = new Database();
$db = $database->connect();

// Instantiate Post Object
$post = new Post($db);

// Get Raw Posted Data
$data = json_decode(file_get_contents("php://input"));
$post->id = $data->id;
$post->info = $data->info;

// Create Post
if ($post->update()) {
    echo json_encode(
        array('message' => 'Post Updated')
    );
} else {
    echo json_encode(
        array('message' => 'Post Not Updated')
    );
}