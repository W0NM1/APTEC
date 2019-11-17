package Clases;

public class Node{

	public int Vertex;		//Almacena en dato del vertex
	public int weight;		//Almacena el weight de la arista

	//Constructor de Node vacio
	public Node(){
		this.Vertex = 0;
		this.weight = 0;
	}//fin del constructor Node


	//Constructor de Node con el dato del vertex destino y el weight de la arista
	public Node(int v, int p){
		this.Vertex = v;
		this.weight = p;
	}

	public String toChain(){
		return "|" + this.Vertex + "|" + this.weight + "|->";
	}//fin metodo toChain

}//fin class Node
