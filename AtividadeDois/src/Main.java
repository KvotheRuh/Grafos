import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaAdjacencia grafoLista = new ListaAdjacencia(7);
        MatrizAdjacencia grafoMatriz = new MatrizAdjacencia(7);
        int[] adjMatriz = new int[7];
        int[] adj =  new int[7];
        List<Integer> visitadosDistancia = new ArrayList<>();
        List<Integer> visitadosPilha = new ArrayList<>();
        List<Integer> visitadosLargura = new ArrayList<>();
        Fila fila = new Fila();
        AlgoritmoDijkstra algoritmoDijkstra = new AlgoritmoDijkstra();
        String[] rotulos = new String[]{"A","B","C","D","E","F","G"};

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
        grafoLista.criaAdjacenciaNaoDirecionada(4, 5, 6);
        grafoLista.criaAdjacenciaNaoDirecionada(5, 6, 7);
        grafoLista.criaAdjacenciaNaoDirecionada(6,4,20);
        grafoLista.criaAdjacenciaNaoDirecionada(0,6,10);
        grafoLista.criaAdjacenciaNaoDirecionada(1,6,40);
        grafoLista.criaAdjacenciaNaoDirecionada(2,4,10);
        grafoLista.criaAdjacenciaNaoDirecionada(3,5,10);
        grafoLista.criaAdjacenciaNaoDirecionada(6, 4, 7);


        System.out.println("\nLista: ");
        grafoLista.imprime();

        grafoLista.Prim(0,2);


        grafoLista.encontraComponente();

        boolean ehConexo = grafoLista.conexo();

        if (ehConexo){
            System.out.println("O grafo é conexo!!");
        } else {
            System.out.println("O grafo não é conexo!!");
        }

        List<Integer> clique = Arrays.asList(0,1,6);

        boolean cliques = grafoLista.ehClique(clique);

        if (cliques){
            System.out.println("É clique!!");
        } else {
            System.out.println("Não é clique!!");
        }

        boolean ehEuleriano = grafoLista.ehEuleriano();

        if (ehEuleriano){
            System.out.println("O grafo é Euleriano!!");
        } else {
            System.out.println("O grafo não é Euleriano!!");
        }

        grafoLista.encontraCiclo();
        grafoLista.calcularProximidade(grafoLista);


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


//       algoritmoDijkstra.dijkstra(grafoLista, 0,6);
    }
}
