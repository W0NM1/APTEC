package Clases;
import java.util.*;

public class NodeVertex {
    private int Vertex;	//Almacena el dato del Vertex
    private Task data;  //Stores the position in the graph
    private boolean visited;			//Indica si el Vertex ha sido visited o no
    private LinkedList <NodeEdge> edge;	//Almacena la lista de edge del Vertex
    
    public NodeVertex(){
    	this.visited = false;
    	this.edge  = new LinkedList<NodeEdge>();
    }//fin del constructor NodeVertex

    public NodeVertex(Task data){
    	this.data = data;
	this.visited = false;
	this.edge  = new LinkedList<NodeEdge>();
    }//fin del constructor NodeVertex
    
    //get vertex position
    public int getVertex() {
        return Vertex;
    }

    //get vertex data
    public Task getData() {
        return data;
    }

    //get visited state
    public boolean isVisited() {
        return visited;
    }

    //get edge list
    public LinkedList<NodeEdge> getEdge() {
        return edge;
    }

    // set vertex data
    public void setVertex(int Vertex) {
        this.Vertex = Vertex;
    }

    //set visited state
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    //set edge
    public void setEdge(NodeEdge edge) {
        this.edge.add(edge);
    }

    //set vertex position
    public void setData(Task data) {
        this.data = data;
    }
    
    //
    public String toChain(){
	return "|" + this.Vertex + "|" + "|->";
    }//fin metodo aCadena

}//fin class NodeVertex
