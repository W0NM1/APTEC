package Clases;

public class NodeEdge{

    private NodeVertex origin;      //Stores the origin node
    private NodeVertex destiny;     //Stores the destiny node
    private int effort;		//Stores the effort between the tasks
    private int time;           //Stores the time between the tasks

	//Constructor de NodeEdge vacio
    public NodeEdge(){
    	this.origin = null;
        this.destiny = null;
        this.effort = 0;
    }//fin del constructor NodeEdge


    //Constructor de NodeEdge con el dato del vertex destino y el weight de la arista
    public NodeEdge(NodeVertex origin,NodeVertex destiny){
	this.origin = origin;
        this.destiny = destiny;
        Task task = this.origin.getData();
        this.effort = task.getEffort();
        this.time = task.getTime();
    }

    // to get the origin vertex
    public NodeVertex getOrigin() {
        return origin;
    }

    // to get the destiny vertex
    public NodeVertex getDestiny() {
        return destiny;
    }

    //to get the effort
    public int getEffort() {
        return effort;
    }

    //to get the time
    public int getTime() {
        return time;
    }

    //to set the origin vertex
    public void setOrigin(NodeVertex origin) {
        this.origin = origin;
    }

    //to set the destiny vertex
    public void setDestiny(NodeVertex destiny) {
        this.destiny = destiny;
    }

    //to set the effort
    public void setEffort(int effort) {
        this.effort = effort;
    }

    //to set the time
    public void setTime(int time) {
        this.time = time;
    }

    public String toChain(){
	return "|" + this.origin.getVertex() + "|" + this.destiny.getVertex() + "|" + this.weight + "|->";
    }//fin metodo toChain

}//fin class NodeEdge
