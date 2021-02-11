<?php

class Commentaire{

    public static $filtre = array(
        'id' => FILTER_VALIDATE_INT,
        'titre' => FILTER_SANITIZE_STRING,
        'contenu' => FILTER_SANITIZE_STRING,
        'auteur' => FILTER_SANITIZE_STRING,
        'date' => FILTER_SANITIZE_STRING,
        'note' => FILTER_VALIDATE_INT
    );

    private $id;
    private $titre;
    private $contenu;
    private $auteur;
    private $date;
    private $note;

    function __construct($tableau){
        $tableau = filter_var_array($tableau, Commentaire::$filtres);
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;

        return $this->id;
    }

    public function getTitre()
    {
        return $this->titre;
    }

    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this->titre;
    }

    public function getContenu()
    {
        return $this->contenu;
    }

    public function setContenu($contenu)
    {
        $this->contenu = $contenu;

        return $this->contenu;
    }

    public function getAuteur()
    {
        return $this->auteur;
    }

    public function setAuteur($auteur)
    {
        $this->auteur = $auteur;

        return $this->auteur;
    }

    public function getDate()
    {
        return $this->date;
    }
 
    public function setDate($date)
    {
        $this->date = $date;

        return $this->date;
    }

    public function getNote()
    {
        return $this->note;
    }

    public function setNote($note)
    {
        $this->note = $note;

        return $this->note;
    }
}

?>