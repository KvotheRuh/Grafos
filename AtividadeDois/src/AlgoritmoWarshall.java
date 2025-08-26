public class AlgoritmoWarshall {
    public boolean[][] fechamento(MatrizAdjacencia grafo) {
        int matrizDados = grafo.matriz.length;
        boolean[][] fechamento = new boolean[matrizDados][matrizDados];

        for (int i = 0; i < matrizDados; i++) {
            for (int j = 0; j < matrizDados; j++) {
                fechamento[i][j] = (grafo.matriz[i][j] != 0 && grafo.matriz[i][j] != Double.POSITIVE_INFINITY);
            }
        }

        for (int k = 0; k < matrizDados; k++) {
            for (int i = 0; i < matrizDados; i++) {
                for (int j = 0; j < matrizDados; j++) {
                    fechamento[i][j] = fechamento[i][j] || (fechamento[i][k] && fechamento[k][j]);
                }
            }
        }

        return fechamento;
    }

    public void imprime(boolean[][] fechamento, MatrizAdjacencia grafo) {
        int n = fechamento.length;
        System.out.println("\nMatriz de Alcançabilidade:");

        System.out.print("   ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%6s", grafo.rotulo[j]);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%3s", grafo.rotulo[i]);
            for (int j = 0; j < n; j++) {
                System.out.printf("%6s", fechamento[i][j] ? "1" : "0");
            }
            System.out.println();
        }
    }

}
