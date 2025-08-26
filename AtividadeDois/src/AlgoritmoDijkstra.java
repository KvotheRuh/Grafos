public class AlgoritmoDijkstra {
    private static int[] caminho;
    private static double[] distancia;  //
    private static MatrizAdjacencia grafo;

    public static void dijkstra(MatrizAdjacencia matrizGrafo, int origem) {
        grafo = matrizGrafo;
        int matrizDados = matrizGrafo.matriz.length;
        distancia = new double[matrizDados];   // agora global
        boolean[] visitado = new boolean[matrizDados];
        caminho = new int[matrizDados];

        for(int i = 0; i < matrizDados; i++){
            distancia[i] = Double.POSITIVE_INFINITY;
            visitado[i] = false;
            caminho[i] = -1;
        }
        distancia[origem] = 0;

        for(int contador = 0; contador < matrizDados; contador++){
            int menorDist = menorDistancia(distancia, visitado);
            if(menorDist == -1) break;
            visitado[menorDist] = true;

            for(int verticeInfo = 0; verticeInfo < matrizDados; verticeInfo++){
                double peso = matrizGrafo.matriz[menorDist][verticeInfo];
                if (!visitado[verticeInfo] && peso != Double.POSITIVE_INFINITY
                        && distancia[menorDist] + peso < distancia[verticeInfo]) {
                    distancia[verticeInfo] = distancia[menorDist] + peso;
                    caminho[verticeInfo] = menorDist;
                }
            }
        }
    }

    private static int menorDistancia(double[] distancia, boolean[] visitado){
        double menor = Double.POSITIVE_INFINITY;
        int indice = -1;
        for(int i = 0; i < distancia.length; i++){
            if(!visitado[i] && distancia[i] < menor){
                menor = distancia[i];
                indice = i;
            }
        }
        return indice;
    }

    public static void imprimeCaminho(int origem, int destino) {
        if (destino == origem) {
            System.out.print(grafo.rotulo[origem]);
        } else if (caminho[destino] == -1) {
            System.out.print("Não há caminho!");
        } else {
            imprimeCaminho(origem, caminho[destino]);
            System.out.print(" -> " + grafo.rotulo[destino]);
        }
    }

    public static void imprimeCustoTotal(int origem, int destino) {
        imprimeCaminho(origem, destino);
        if (distancia[destino] != Double.POSITIVE_INFINITY) {
            System.out.println(" ");
            System.out.print("Custo total = " + distancia[destino]);
        }
        System.out.println();
    }
}
