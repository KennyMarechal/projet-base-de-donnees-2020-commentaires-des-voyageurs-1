<?php

class Commentaire{
	
	public $titre;
	public $auteur;
	public $contenu;
	public $date;
	public $note;
	
	/*function __construct($id, $titre, $auteur, $contenu, $date){
		$this->id = $id;
		$this->titre = $titre;
		$this->auteur = $auteur;
		$this->contenu = $contenu;
		$this->date = $date;
	}*/
	
	public function getTitre(){
		return $this->titre;
	}
	
	public function setTitre($titre){
		$this->titre = $titre;
	}
	
	public function getAuteur(){
		return $this->auteur;
	}
	
	public function setAuteur($auteur){
		$this->auteur = $auteur;
	}
	
	public function getContenu(){
		return $this->contenu;
	}
	
	public function setContenu($contenu){
		$this->contenu = $contenu;
	}
	
	public function getDate(){
		return $this->date;
	}
	
	public function setDate($date){
		$this->date = $date;
	}

	public function getNote(){
		return $this->note;
	}
	
	public function setNote($note){
		$this->note = $note;
	}
}
?>