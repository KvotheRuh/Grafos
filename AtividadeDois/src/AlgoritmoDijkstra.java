public class AlgoritmoDijkstra {
    boolean pertence = true;
    boolean naoPertence = false;
    int valorInfinito = 999999999;

    public double dijkstra(ListaAdjacencia grafo, int origem, int destino){
        int numeroVertice = grafo.quantidadeVertices;
        double[] distancia = new double[numeroVertice];
        boolean[] distanciaPermanente = new boolean[numeroVertice];
        int[] caminho = new int[numeroVertice];
        int verticeCorrente;
        int proximoVertice = origem;
        double distanciMinima;
        double menorDistancia;
        double novaDistancia;

        for (int i = 0; i < numeroVertice; i++){
            distanciaPermanente[i] = naoPertence;
            distancia[i] = valorInfinito;
            caminho[i] = -1;
        }

        distanciaPermanente[origem] = pertence;
        distancia[origem] = 0;
        verticeCorrente = origem;

        while (verticeCorrente != destino){
            menorDistancia = valorInfinito;
            distanciMinima = distancia[verticeCorrente];

            Aresta aresta = grafo.vertices[verticeCorrente].inicio;
            while(aresta != null){
                int verticeAjacente = aresta.destino;
                if(!distanciaPermanente[verticeAjacente]){
                    novaDistancia = distanciMinima + aresta.peso;
                    if (novaDistancia < distancia[verticeAjacente]){
                        distancia[verticeAjacente] = novaDistancia;
                        caminho[verticeAjacente] = verticeCorrente;
                    }
                    if (distancia[verticeAjacente] < menorDistancia){
                        menorDistancia = distancia[verticeAjacente];
                        proximoVertice = verticeAjacente;
                    }
                }
                aresta = aresta.proximo;
            }
            verticeCorrente = proximoVertice;
            distanciaPermanente[verticeCorrente] = pertence;
        }

        System.out.println("Caminho:  ");
        imprimirCaminho(grafo,caminho,destino);

        System.out.println("\nCusto total: " + distancia[destino]);
        return distancia[destino];
    }

    private void imprimirCaminho(ListaAdjacencia grafo, int[] caminho, int vertice) {
        if (caminho[vertice] != -1) {
            imprimirCaminho(grafo, caminho, caminho[vertice]);
            System.out.print(" -> ");
        }
        System.out.print(grafo.vertices[vertice].rotulo);
    }
}
