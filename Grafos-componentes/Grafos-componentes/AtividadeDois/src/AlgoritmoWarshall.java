public class AlgoritmoWarshall {
    ConverteLista matrizCopia = new ConverteLista();
    public boolean[][] fechamento(ListaAdjacencia grafo){
        int numeroVertices = grafo.quantidadeVertices;
        double[][] matrizDados = matrizCopia.copiarLista(grafo);
        boolean[][] matrizFechamento = new boolean[numeroVertices][numeroVertices];

        for(int i = 0; i < numeroVertices; i++){
            for (int j = 0; j < numeroVertices; j++){
                if (i == j){
                    matrizFechamento[i][j] = true;
                } else {
                    matrizFechamento[i][j] =(matrizDados[i][j] != Double.POSITIVE_INFINITY);
                }
            }
        }

        for (int k = 0; k < numeroVertices; k++){
            for (int i = 0; i < numeroVertices; i++){
                for (int j = 0; j < numeroVertices; j++){
                    matrizFechamento[i][j] = matrizFechamento[i][j] || (matrizFechamento[i][k] && matrizFechamento[k][j]);
                }
            }
        }
        return matrizFechamento;
    }

    public void imprime(boolean[][] matrizFechamento, ListaAdjacencia grafo) {
        System.out.println("\nMatriz de Alcançabilidade:");

        System.out.printf("%1s", "");
        for (int j = 0; j < grafo.quantidadeVertices; j++) {
            System.out.printf("%6s", grafo.vertices[j].rotulo);
        }
        System.out.println();

        for (int i = 0; i < grafo.quantidadeVertices; i++) {
            System.out.printf("%s", grafo.vertices[i].rotulo);

            for (int j = 0; j < grafo.quantidadeVertices; j++) {
                if (matrizFechamento[i][j]) {
                    System.out.printf("%6s", "1");
                } else {
                    System.out.printf("%6s", "0");
                }
            }
            System.out.println();
        }
    }

}

