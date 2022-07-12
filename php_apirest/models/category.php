<?php
class Category{

    // Database stuff
    private $connection;
    private $table = 'data';

    // Post Properties
    public $id;
    public $info;
    public $category;

    // Constructor with Database
    public function __construct($database){
        $this->connection = $database;
    }

    // Get Posts
    public function read(){
        // Create query
        $query = 'SELECT id, category FROM ' . $this->table;

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Execute query
        $statement->execute();

        return $statement;
    }

}