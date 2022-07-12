<?php
class Post{

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
        $query = 'SELECT * FROM ' . $this->table;

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Execute query
        $statement->execute();

        return $statement;
    }

    // Get Single Post
    public function read_single(){
        $query = 'SELECT * FROM ' . $this->table . ' WHERE id=?';

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Bind id
        $statement->bindParam(1, $this->id);

        // Execute query
        $statement->execute();
        $row = $statement->fetch(PDO::FETCH_ASSOC);

        // Set properties
        $this->id = $row['id'];
        $this->info = $row['info'];
        $this->category = $row['category'];
    }

    // Create Post
    public function create(){

        // Create query
        $query = 'INSERT INTO ' . $this->table . ' SET id = :id, info = :info, category = :category';

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Clean data
        $this->id = htmlspecialchars(strip_tags($this->id));
        $this->info = htmlspecialchars(strip_tags($this->info));
        $this->category = htmlspecialchars(strip_tags($this->category));

        // Bind data
        $statement->bindParam(':id', $this->id);
        $statement->bindParam(':info', $this->info);
        $statement->bindParam(':category', $this->category);

        // Execute query
        if ($statement->execute()){
            return true;
        }

        // Print error if something goes wrong
        printf("Error: %s. \n", $statement->error);

        return false;
    }

    // Update Post
    public function update(){

        // Create query
        $query = 'UPDATE ' . $this->table . ' SET info = :info WHERE id = :id';

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Clean data
        $this->id = htmlspecialchars(strip_tags($this->id));
        $this->info = htmlspecialchars(strip_tags($this->info));

        // Bind data
        $statement->bindParam(':id', $this->id);
        $statement->bindParam(':info', $this->info);

        // Execute query
        if ($statement->execute()){
            return true;
        }

        // Print error if something goes wrong
        printf("Error: %s. \n", $statement->error);

        return false;
    }

    // Delete Post
    public function delete(){

        // Create query
        $query = 'DELETE FROM ' .$this->table. ' WHERE id = :id';

        // Prepare statement
        $statement = $this->connection->prepare($query);

        // Clean data
        $this->id = htmlspecialchars(strip_tags($this->id));

        // Bind data
        $statement->bindParam(':id', $this->id);

        // Execute query
        if ($statement->execute()){
            return true;
        }

        // Print error if something goes wrong
        printf("Error: %s. \n", $statement->error);

        return false;
    }
}