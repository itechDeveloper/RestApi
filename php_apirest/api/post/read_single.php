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

// Get Id
$post->id =isset($_GET['id']) ? $_GET['id'] : die();

// Get Post
$post->read_single();

// Create Array
$post_array = array(
    'id' => $post->id,
    'info' => $post->info
);

// Make JSON
print_r(json_encode($post_array));