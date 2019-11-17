package Clases;

import java.util.*;


public class Grahp{
    public LinkedList <NodeVertex> VertexList;  //Lista de Vertex del Grahp


    //Constructor del Grahp
    public Grahp(){
    	this.VertexList = new LinkedList<NodeVertex>();
    }

    //Metodo para add un Vertex al Grahp
    public void addVertex(Task task){
        VertexList.add(new NodeVertex(task));  //Agrega el Vertex al final de la lista de Vertex
    }

    //Metodo para add una Edge al Grahp
    public void addEdge(NodeVertex origin, NodeVertex destiny){
        findVertex(origin.getVertex()).getEdge().add(new NodeEdge(origin, destiny));  //find el Vertex origin y agrega un NodeEdge al final de la lista de edge de ese Vertex
    }

    //Metodo para find un Vertex en la lista de Vertex del Grahp segun el dato indicado
    public NodeVertex findVertex(int v){
        //Recorre la lista de Vertex
        for(int index = 0; index < VertexList.size(); index++){
            if(VertexList.get(index).getVertex() == v){ //Si encuentra el Vertex lo retorna
                return VertexList.get(index);
            }        
        }
        return null;
    }

    //Metod for find one Edge in the edge list
    public NodeEdge findEdge(int origin, int destine){
        NodeVertex temp = findVertex(origin);  //Busca el Vertex de origin
        LinkedList <NodeEdge> tempEdge = new LinkedList<NodeEdge>();
        //Busca en la lista de edge de ese Vertex para identificar si se encuentra la Edge buscada
        for(int i = 0; i < tempEdge.size(); i++){
            if(tempEdge.get(i).getDestiny().getVertex() == destine){
                return tempEdge.get(i);
            }      
        }
        return null;
    }


    //Metodo para find el primer Vertex del Grahp que esta sin visitar
    public NodeVertex findVertexNOvisited(){

	//Recorre la lista de Vertex
	for(int index = 0; index < this.VertexList.size(); index++){
            if(!VertexList.get(index).isVisited()){ //Si encuentra una no visited lo retorna
		return VertexList.get(index);
            }
        }
    return null; //Si alls estan visiteds retorna null
    }

    //Metodo para imprimir el Grahp recorriendo la lista de Vertex y por cada Vertex imprimiendo la lista de edge que tiene
    public void printGrahp(){
	NodeVertex current;
	for(int i = 0; i < VertexList.size(); i++){
            current = VertexList.get(i);
            System.out.println("Vertex : " + current.getVertex());
            for(int j = 0; j < current.getEdge().size(); j++){
		System.out.println("Edge de "+current.getVertex()+ " a " + 
                        current.getEdge().get(j).getDestiny().getVertex()+ 
                        " con weight " + current.getEdge().get(j).getTime());
            }
	}
    }

    //Metod for initialice all the Nodes as not visited
    public void initialiceVisited(){
	for(int i = 0; i < VertexList.size(); i++){
            VertexList.get(i).setVisited(false);
	}
    }

    //Metodo para verificar si alls los Nodes del Grahp estan visiteds
    public boolean allsvisiteds(){
    	for(int i = 0; i < VertexList.size(); i++){
            if(!VertexList.get(i).isVisited()){	//Si encuentra uno sin visitar retorna false
		return false;
            }
        }
        return true;	//Si encuentra uno visited retorna true
    }
    
	//Metodo para delete un Vertex del Grahp
    public void deleteVertex(int v){
	//Elimina todas las edge en las que el Vertex eliminado aparezca como destine
	for(int i = 0; i < VertexList.size(); i++) {
            deleteEdge(VertexList.get(i).getVertex(), v);
	}	
	VertexList.remove(findVertex(v));  //Elimina el Vertex de la lista de Vertex
    }

	//Metodo para delete una Edge de un Vertex origin a un Vertex destine dado
    public void deleteEdge(int origin, int destine){
	//Verifica si el Grahp es no dirigido
	if((findEdge(origin,destine) != null) && (findEdge(destine,origin) != null)){ //Busca si existe Edge de origin a destine y viceversa
            //Verifica si el weight de ambas edge es igual con lo que se asume que es un Grahp no dirigido
            if(findEdge(origin,destine).getTime() == findEdge(destine,origin).getTime()){
		findVertex(destine).getEdge().remove(findEdge(destine, origin));
            }
	}
	//Elimina el Edge de la lista de edge del Vertex origin
	findVertex(origin).getEdge().remove(findEdge(origin, destine));
    }

    //Metodo para realizar el travel en Depth en el Grahp
    public void travelDepth(int initial){
	initialiceVisited();  //initializa alls los Nodes como no visiteds
	System.out.println("travel en Depth");
	DFS(initial); //Hace la llamada al metodo que realiza el algoritmo
	System.out.println();
    }



    private void DFS(int initial){
	NodeVertex current = findVertex(initial); //Busca el Vertex initial para el travel en la lista de Vertex

	while(current != null){  //Ciclo para verificar que alls los Vertex estan visiteds
            //Si el NodeEdge initial no esta visited
            if(!current.isVisited()){
		System.out.print(current.getVertex() + " "); //print el Vertex
		current.setVisited(true);	//Lo currentiza como visited
            }
            //Revisa alls los Nodes adyacentes del NodeEdge recien visited
            for(int j = 0; j < current.getEdge().size(); j++){
		if(! current.getEdge().get(j).getOrigin().isVisited())  //Si el NodeEdge adyacente no esta visited
                    DFS(current.getEdge().get(j).getDestiny().getVertex()); //Hace la llamada recursiva para realizar el travel en el NodeEdge adyacente
		}
		//Verifica si queda algun NodeEdge sin visitar
		current = findVertexNOvisited();
            }
	}
    }

    //Metodo para recorrer el Grahp en Width
    public void travelWidth(int initial){
	NodeVertex current;
	LinkedList <NodeVertex> Tail = new LinkedList<NodeVertex>();	//Estructura auxiliar para hacer el travel
	initialiceVisited(); //initializa alls los Nodes como no visiteds
	System.out.println("travel en Width");
	current = findVertex(initial); //Busca el Vertex para iniciar el travel en la lista de Vertex del Grahp

	//Ciclo para verificar que alls los Nodes estan visiteds
	while(current != null){
            //Si el NodeEdge current no ha sido visited
            if(!current.visited){
		System.out.print(current.Vertex + " "); //print el Vertex
		current.visited = true; //Indica que el Vertex fue visited
		Tail.add(current);  //Agrega el Vertex a la Tail(estructura auxiliar)
            }
            //Busca alls los Vertex adyacentes al Vertex recien visited
            for(int j = 0; j < current.edge.size(); j++){
                if(! findVertex(current.edge.get(j).Vertex).visited){ //Si el Vertex no se ha visited aun
                    System.out.print(current.edge.get(j).Vertex + " ");  //Se print el Vertex
                    Tail.add(findVertex(current.edge.get(j).Vertex));    //Se agrega el Vertex a la Tail
                    findVertex(current.edge.get(j).Vertex).visited = true;  //Se indica que el Vertex ha sido visited
		}
            }

            //Mientras la Tail no esta vacia
            while(Tail.size() > 0){
		NodeVertex temp1;
		for(int x = 0; x < Tail.getFirst().edge.size(); x++){
                    //Obtiene el primer Vertex en la Tail
                    temp1 = findVertex(Tail.getFirst().edge.get(x).Vertex);
                    if(!temp1.visited){  //Verifica si el primero de la Tail no ha sido visited
                        System.out.print(temp1.Vertex + " "); //print el Vertex
                        temp1.visited = true;	//Indica que el Vertex se ha visited
			Tail.add(temp1);	//Agrega el Vertex al final de la Tail
                    }
		}
		//Elimina el primer Vertex de la Tail
		Tail.removeFirst();
            }
            current = findVertexNOvisited();//Verifica si aun quedan Vertex sin visitar
	}
	System.out.println();
    }
}//Fin de la clase
