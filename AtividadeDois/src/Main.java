public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);
        int[] adj = new int[4];

        grafo.seta_informacao(0, "A");
        grafo.seta_informacao(1, "B");
        grafo.seta_informacao(2, "C");
        grafo.seta_informacao(3, "D");

        grafo.cria_adjacencia(0, 1, 5);
        grafo.cria_adjacencia(0, 2, 2);
        grafo.cria_adjacencia(1, 3, 7);

        grafo.imprime();

        grafo.adjacentes(0, adj);

        grafo.remove_adjacencia(0,1);

        grafo.imprime();

    }
}
