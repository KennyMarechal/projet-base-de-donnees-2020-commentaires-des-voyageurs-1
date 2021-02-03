<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);
    $usager = 'postgres';
    $motdepasse = '';
    $hote = 'localhost';
    $base = 'poisson';
    $dsn = "pgsql:host=$hote;dbname=$base";
    $basededonnees = new PDO($dsn, $usager, $motdepasse,
    array(
        PDO::ATTR_ERRMODE => PDO::ERRMODE_WARNING,
        PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8mb4"
      ));
   // $basededonnees->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING );
//$db = new PDO("mysql:host=localhost;dbname=gokuan_chapitres;charset=UTF8", 'root', '');
