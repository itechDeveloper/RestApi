<?php
class Database{

    // Params
    private $host = 'localhost';
    private $database_name = 'mydatabase';
    private $username = 'root';
    private $password = '';
    private $connection;

    // Database connection
    public function connect(){
        $this->connection = null;

        try {
            $this->connection = new PDO('mysql:host=' . $this->host . ';dbname=' . $this->database_name, $this->username, $this->password);
            $this->connection -> setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        }catch (PDOException $exception){
            echo 'Connection Error: ' .$exception -> getMessage();
        }

        return $this->connection;
    }
}