package Clases;
import java.util.*;

public class NodeVertex{
 	public int Vertex;					//Almacena el dato del Vertex
 	public boolean visited;			//Indica si el Vertex ha sido visited o no
 	public LinkedList <Node> edge;	//Almacena la lista de edge del Vertex

 	public NodeVertex(){
		this.Vertex = 0;
		this.visited = false;
		this.edge  = new LinkedList<Node>();
	}//fin del constructor Node

	public NodeVertex(int v){
			this.Vertex = v;
			this.visited = false;
			this.edge  = new LinkedList<Node>();
	}//fin del constructor Node

	public String toChain(){
		return "|" + this.Vertex + "|" + "|->";
	}//fin metodo aCadena

}//fin class NodeVertex
