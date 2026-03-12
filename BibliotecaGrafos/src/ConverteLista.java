public class ConverteLista {
    public double[][] copiarLista(ListaAdjacencia grafo) {
        double[][] matrizCopia = new double[grafo.quantidadeVertices][grafo.quantidadeVertices];


        for (int i = 0; i < grafo.quantidadeVertices; i++) {
            for (int j = 0; j < grafo.quantidadeVertices; j++) {
                matrizCopia[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        for (int i = 0; i < grafo.quantidadeVertices; i++) {
            matrizCopia[i][i] = 0;
        }

        for (int i = 0; i < grafo.quantidadeVertices; i++) {
            Vertice origem = grafo.vertices[i];

            if (origem != null) {
                Aresta atual = origem.inicio;

                while (atual != null) {
                    int destino = atual.destino;
                    double peso = atual.peso;

                    matrizCopia[i][destino] = peso;

                    atual = atual.proximo;
                }
            }
        }
        return matrizCopia;
    }
}
