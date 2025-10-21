import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaAdjacencia grafoLista = new ListaAdjacencia(4);
        MatrizAdjacencia grafoMatriz = new MatrizAdjacencia(4);
        int[] adjMatriz = new int[4];
        int[] adj =  new int[4];
        List<Integer> visitadosDistancia = new ArrayList<>();
        List<Integer> visitadosPilha = new ArrayList<>();
        List<Integer> visitadosLargura = new ArrayList<>();
        Fila fila = new Fila();
        String[] rotulos = new String[]{"A","B","C","D"};

        for (int i = 0; i < rotulos.length; i++){
            grafoLista.setaInformacao(i, rotulos[i]);
            grafoMatriz.setaInformacao(i, rotulos[i]);
        }


        System.out.println("Lista: ");

//        grafoLista.criaAdjacencia(0, 1, 5);
//        grafoLista.criaAdjacencia(0, 2, 2);
//        grafoLista.criaAdjacencia(1, 3, 7);
//        grafoLista.criaAdjacencia(2, 3, 6);
//        grafoLista.criaAdjacencia(3, 1, 2);
//        grafoLista.criaAdjacencia(1, 2, 7);
//        grafoLista.criaAdjacencia(0,3,20);

        grafoLista.criaAdjacenciaNaoDirecionada(0, 1, 5);
        grafoLista.criaAdjacenciaNaoDirecionada(0, 2, 2);
        grafoLista.criaAdjacenciaNaoDirecionada(1, 3, 7);
        grafoLista.criaAdjacenciaNaoDirecionada(2, 3, 6);
        grafoLista.criaAdjacenciaNaoDirecionada(1, 2, 7);
        grafoLista.criaAdjacenciaNaoDirecionada(0,3,20);

        grafoLista.Prim(0,3);

        System.out.println("\nLista: ");
        grafoLista.imprime();
//        grafoLista.profundidade(0,3,visitadosPilha);
//        grafoLista.largura(fila,0,3,visitadosLargura);
//        grafoLista.distancia(0, 2, visitadosDistancia);
//        grafoLista.saida();
//
//        grafoLista.adjacentes(0, adj);
//        grafoLista.entrada();



//        System.out.println("Matriz: ");

//        grafoMatriz.criaAdjacencia(0, 1, 5);
//        grafoMatriz.criaAdjacencia(0, 2, 2);
//        grafoMatriz.criaAdjacencia(1, 3, 7);
//        grafoMatriz.criaAdjacencia(2, 3, 6);
//        grafoMatriz.criaAdjacencia(3, 1, 2);
//        grafoMatriz.criaAdjacencia(1, 2, 7);
//        grafoMatriz.criaAdjacencia(0,3,20);
//
//        grafoMatriz.imprime();
//
//        grafoMatriz.adjacentes(0, adjMatriz);
//
//        grafoMatriz.removeAdjacencia(0,2);
//
//        grafoMatriz.imprime();
//
//        AlgoritmoWarshall algoritmoWarshall = new AlgoritmoWarshall();
//        boolean[][] fechamento = algoritmoWarshall.fechamento(grafoLista);
//        algoritmoWarshall.imprime(fechamento, grafoLista);


//       AlgoritmoDijkstra algoritmoDijkstra = new AlgoritmoDijkstra();
//       algoritmoDijkstra.dijkstra(grafoLista, 0, 3);


    }
}
