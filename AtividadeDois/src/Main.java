public class Main {
    public static void main(String[] args) {
        ListaAdjacencia grafoLista = new ListaAdjacencia(4);
        int[] adj = new int[4];

        grafoLista.setaInformacao(0, "A");
        grafoLista.setaInformacao(1, "B");
        grafoLista.setaInformacao(2, "C");
        grafoLista.setaInformacao(3, "D");

        grafoLista.criaAdjacencia(0, 1, 5);
        grafoLista.criaAdjacencia(0, 2, 2);
        grafoLista.criaAdjacencia(1, 3, 7);
        grafoLista.criaAdjacencia(2, 3, 6);
        grafoLista.criaAdjacencia(3, 1, 2);
        grafoLista.criaAdjacencia(1, 2, 7);

        grafoLista.imprime();

        grafoLista.adjacentes(0, adj);

        grafoLista.removeAdjacencia(0,2);

        grafoLista.imprime();



        MatrizAdjacencia grafoMatriz = new MatrizAdjacencia(4);
        int[] adjMatriz = new int[4];

        grafoMatriz.setaInformacao(0, "A");
        grafoMatriz.setaInformacao(1, "B");
        grafoMatriz.setaInformacao(2, "C");
        grafoMatriz.setaInformacao(3, "D");

        grafoMatriz.criaAdjacencia(0, 1, 5);
        grafoMatriz.criaAdjacencia(0, 2, 2);
        grafoMatriz.criaAdjacencia(1, 3, 7);
        grafoMatriz.criaAdjacencia(2, 3, 6);
        grafoMatriz.criaAdjacencia(3, 1, 2);
        grafoMatriz.criaAdjacencia(1, 2, 7);

        grafoMatriz.imprime();

        grafoMatriz.adjacentes(0, adjMatriz);

        grafoMatriz.removeAdjacencia(0,2);

        grafoMatriz.imprime();

        AlgoritmoWarshall algoritmoWarshall = new AlgoritmoWarshall();
        boolean[][] fechamento = algoritmoWarshall.fechamento(grafoMatriz);
        algoritmoWarshall.imprime(fechamento, grafoMatriz);


        AlgoritmoDijkstra.dijkstra(grafoMatriz, 0);
        AlgoritmoDijkstra.imprimeCustoTotal(0, 2);

        AlgoritmoDijkstra.dijkstra(grafoMatriz, 3);
        AlgoritmoDijkstra.imprimeCustoTotal(3, 2);

    }
}
