public class MatrizAdjacencia {
    public double[][] matriz;
    String[] rotulo;
    private int vertice;

    public MatrizAdjacencia(int vertice) {
        this.vertice = vertice;
        this.matriz = new double[vertice][vertice];
        this.rotulo = new String[vertice];

        for (int i = 0; i < vertice; i++) {
            for (int j = 0; j < vertice; j++) {
                this.matriz[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public void criaAdjacencia(int i, int j, double P) {
        if (i >= 0 && i < this.vertice && j >= 0 && j < this.vertice) {
            this.matriz[i][j] = P;
        } else {
            System.out.println("Não foi possível criar o vértice!!!");
        }
    }

    public void removeAdjacencia(int i, int j) {
        if (i >= 0 && i < this.vertice && j >= 0 && j < this.vertice) {
            this.matriz[i][j] = Double.POSITIVE_INFINITY;
        } else {
            System.out.println("Não foi possível remover a adjacencia!!");
        }
    }

    public void setaInformacao(int i, String V) {
        if (i >= 0 && i < this.vertice) {
            this.rotulo[i] = V;
        } else {
            System.out.println("Não foi possível atualizar a informação do vértice!!!");
        }
    }

    public void adjacentes(int i, int[] adj) {
        int contador = 0;
        if (i >= 0 && i < this.vertice) {
            for(int j = 0; j < this.vertice; ++j) {
                if (this.matriz[i][j] != (double)0.0F) {
                    adj[contador++] = j;
                }
            }

            System.out.printf("\nQuantidade de adjacentes de %s: %d\n", this.rotulo[i], contador);
        } else {
            System.out.println("Vértice Inválido!!");
        }

    }

    public void imprime() {
        System.out.print(" ");

        for(int j = 0; j < this.vertice; ++j) {
            System.out.printf("%6s", this.rotulo[j]);
        }

        System.out.println();

        for(int i = 0; i < this.vertice; ++i) {
            String rotulos = this.rotulo[i];
            System.out.print(rotulos + " ");

            for(int j = 0; j < this.vertice; ++j) {
                if (this.matriz[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.printf("%6s", "0.00");
                } else {
                    System.out.printf("%6.2f", this.matriz[i][j]);
                }
            }

            System.out.println();
        }

    }
}
