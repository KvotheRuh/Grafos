public class AlgoritmoDijkstra {
    boolean pertence = true;
    int valorInfinito = 999999999;

    public double dijkstra(ListaAdjacencia grafo, int origem, int destino){
        int qtdVertices = grafo.quantidadeVertices;
        double[] distancia = new double[qtdVertices];
        boolean[] distanciaPermanente = new boolean[qtdVertices];
        int[] caminho = new int[qtdVertices];
        int verticeCorrente;
        int proximoVertice = origem;
        double distanciMinima;
        double menorDistancia;
        double novaDistancia;

        for (int i = 0; i < qtdVertices; i++){
            distanciaPermanente[i] = false;
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
                int adjacente = aresta.destino;

                if(!distanciaPermanente[adjacente]){
                    novaDistancia = distanciMinima + aresta.peso;

                    if (novaDistancia < distancia[adjacente]){
                        distancia[adjacente] = novaDistancia;
                        caminho[adjacente] = verticeCorrente;
                    }

                    if (distancia[adjacente] < menorDistancia){
                        menorDistancia = distancia[adjacente];
                        proximoVertice = adjacente;
                    }
                }

                aresta = aresta.proximo;

            }

            for(int i = 0; i < qtdVertices ; i++){
                if (!distanciaPermanente[i] && distancia[i] < menorDistancia){
                    menorDistancia = distancia[i];
                    proximoVertice = i;
                }
            }


            if (menorDistancia == valorInfinito) {
                System.out.println("Destino não alcançável a partir de " + grafo.vertices[origem].rotulo);
                return valorInfinito;
            }

            verticeCorrente = proximoVertice;
            distanciaPermanente[verticeCorrente] = pertence;
        }

//        System.out.println("Caminho:  ");
//        imprimirCaminho(grafo,caminho,destino);
//
//        System.out.println("\nCusto total: " + distancia[destino]);

        return distancia[destino];
    }

    private void imprimirCaminho(ListaAdjacencia grafo, int[] caminho, int vertice) {
        if (caminho[vertice] != -1) {
            imprimirCaminho(grafo, caminho, caminho[vertice]);
            System.out.print(" -> ");
        }
        System.out.print(grafo.vertices[vertice].rotulo);
    }

    public int[] dijkstraCentralidade (ListaAdjacencia grafo, int origem) {
        int qtdVertices = grafo.quantidadeVertices;
        double[] distancia = new double[qtdVertices];
        boolean[] distanciaPermanente = new boolean[qtdVertices];
        int[] caminho = new int[qtdVertices];
        int verticeCorrente;
        double menorDistancia;
        double novaDistancia;

        for (int i = 0; i < qtdVertices; i++){
            distanciaPermanente[i] = false;
            distancia[i] = valorInfinito;
            caminho[i] = -1;
        }

        distancia[origem] = 0;

        for(int i = 0; i < qtdVertices - 1; i++){

            menorDistancia = valorInfinito;
            verticeCorrente = -1;

            for (int j = 0; j < qtdVertices; j++){
                if (!distanciaPermanente[j] && distancia[j] < menorDistancia){
                    menorDistancia = distancia[j];
                    verticeCorrente = j;
                }
            }

            if (verticeCorrente == -1){
                break;
            }

            distanciaPermanente[verticeCorrente] = pertence;

            Aresta atual = grafo.vertices[verticeCorrente].inicio;

            while (atual != null) {
                int adjacente = atual.destino;

                if (!distanciaPermanente[adjacente]) {
                    novaDistancia = distancia[verticeCorrente] + atual.peso;

                    if (novaDistancia < distancia[adjacente]) {
                        distancia[adjacente] = novaDistancia;
                        caminho[adjacente] = verticeCorrente;
                    }
                }

                atual = atual.proximo;
            }
        }

        return caminho;
    }
}
