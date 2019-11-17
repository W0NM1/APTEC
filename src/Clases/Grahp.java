package Clases;

import java.util.*;


public class Grahp{
	public LinkedList <NodeVertex> Vertex;  //Lista de Vertex del Grahp


	//Constructor del Grahp
	public Grahp(){
		this.Vertex = new LinkedList<NodeVertex>();
	}

	//Metodo para add un Vertex al Grahp
	public void addVertex(int v){
		Vertex.add(new NodeVertex(v));  //Agrega el Vertex al final de la lista de Vertex
	}

	//Metodo para add una Edge al Grahp
	public void addEdge(int origin, int destine, int weight){
		findVertex(origin).edge.add(new Node(destine, weight));  //find el Vertex origin y agrega un Node al final de la lista de edge de ese Vertex
       }

	//Metodo para find un Vertex en la lista de Vertex del Grahp segun el dato indicado
	public NodeVertex findVertex(int v){
		//Recorre la lista de Vertex
		for(int index = 0; index < this.Vertex.size(); index++){
			if(this.Vertex.get(index).Vertex == v)  //Si encuentra el Vertex lo retorna
				return this.Vertex.get(index);
		}
		return null;
	}

	//Metodo para find una Edge en la lista de edge
	public Node findEdge(int origin, int destine){
		NodeVertex temp = findVertex(origin);  //Busca el Vertex de origin
		//Busca en la lista de edge de ese Vertex para identificar si se encuentra la Edge buscada
		for(int i = 0; i < temp.edge.size(); i++){
                   if(temp.edge.get(i).Vertex == destine){
                       return temp.edge.get(i);
                   }
                               
		}
		return null;
	}


	//Metodo para find el primer Vertex del Grahp que esta sin visitar
	public NodeVertex findVertexNOvisited(){

		//Recorre la lista de Vertex
		for(int index = 0; index < this.Vertex.size(); index++){
			if(!this.Vertex.get(index).visited ){ //Si encuentra una no visited lo retorna
				return this.Vertex.get(index);
			}
		}
		return null; //Si alls estan visiteds retorna null
	}

	//Metodo para imprimir el Grahp recorriendo la lista de Vertex y por cada Vertex imprimiendo la lista de edge que tiene
	public void printGrahp(){
		NodeVertex current;
		for(int i = 0; i < this.Vertex.size(); i++){
			current = Vertex.get(i);
			System.out.println("Vertex : " + current.Vertex);
			for(int j = 0; j < current.edge.size(); j++){
				System.out.println("Edge de "+current.Vertex+ " a " + current.edge.get(j).Vertex + " con weight " + current.edge.get(j).weight);
			}
		}
	}

	//Metodo para initialice alls los Nodes como no visiteds
	public void initialicevisiteds(){
		for(int i = 0; i < this.Vertex.size(); i++)
			this.Vertex.get(i).visited = false;
	}

	//Metodo para verificar si alls los Nodes del Grahp estan visiteds
	public boolean allsvisiteds(){
		for(int i = 0; i < this.Vertex.size(); i++){
			if(!this.Vertex.get(i).visited)	//Si encuentra uno sin visitar retorna false
				return false;
		}
		return true;	//Si encuentra uno visited retorna true
	}

	//Metodo para delete un Vertex del Grahp
	public void deleteVertex(int v){
		//Elimina todas las edge en las que el Vertex eliminado aparezca como destine
		for(int i = 0; i < Vertex.size(); i++) {
			deleteEdge(Vertex.get(i).Vertex, v);
		}	
		this.Vertex.remove(findVertex(v));  //Elimina el Vertex de la lista de Vertex
	}

	//Metodo para delete una Edge de un Vertex origin a un Vertex destine dado
	public void deleteEdge(int origin, int destine){
		//Verifica si el Grahp es no dirigido
		if((findEdge(origin,destine) != null) && (findEdge(destine,origin) != null)){ //Busca si existe Edge de origin a destine y viceversa
			//Verifica si el weight de ambas edge es igual con lo que se asume que es un Grahp no dirigido
			if(findEdge(origin,destine).weight == findEdge(destine,origin).weight){
				findVertex(destine).edge.remove(findEdge(destine, origin));
			}
		}
		//Elimina el Edge de la lista de edge del Vertex origin
		findVertex(origin).edge.remove(findEdge(origin, destine));

	}

	//Metodo para realizar el travel en Depth en el Grahp
	public void travelDepth(int initial){
		initialicevisiteds();  //initializa alls los Nodes como no visiteds
		System.out.println("travel en Depth");
		DFS(initial); //Hace la llamada al metodo que realiza el algoritmo
		System.out.println();
	}



	private void DFS(int initial){

		NodeVertex current = findVertex(initial); //Busca el Vertex initial para el travel en la lista de Vertex

		while(current != null)  //Ciclo para verificar que alls los Vertex estan visiteds
		{
			//Si el Node initial no esta visited
			if(!current.visited){
				System.out.print(current.Vertex + " "); //print el Vertex
				current.visited = true;	//Lo currentiza como visited
			}

			//Revisa alls los Nodes adyacentes del Node recien visited
			for(int j = 0; j < current.edge.size(); j++){
				if(! findVertex(current.edge.get(j).Vertex).visited)  //Si el Node adyacente no esta visited
					DFS(current.edge.get(j).Vertex); //Hace la llamada recursiva para realizar el travel en el Node adyacente
			}
			//Verifica si queda algun Node sin visitar
			current = findVertexNOvisited();
		}
	}

	//Metodo para recorrer el Grahp en Width
	public void travelWidth(int initial){

		NodeVertex current;
		LinkedList <NodeVertex> Tail = new LinkedList<NodeVertex>();	//Estructura auxiliar para hacer el travel

		initialicevisiteds(); //initializa alls los Nodes como no visiteds

		System.out.println("travel en Width");
		current = findVertex(initial); //Busca el Vertex para iniciar el travel en la lista de Vertex del Grahp

		//Ciclo para verificar que alls los Nodes estan visiteds
		while(current != null)
		{
			//Si el Node current no ha sido visited
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
			while(Tail.size() > 0)
			{
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
