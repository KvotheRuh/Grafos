public class Grafo {
    public int [][] matriz;
    private String[] rotulo;
    private int vertice;

    public Grafo(int vertice) {
        this.vertice = vertice;
        matriz = new int[vertice][vertice];
        rotulo = new String[vertice];

        for (int i = 0; i < vertice; i++){
            rotulo[i] = "V" + i;
        }

    }

    public void cria_adjacencia( int i, int j, int P) {
        if (i >= 0 && i < vertice && j >= 0 && j < vertice){
            matriz[i][j] = P;
        } else {
            System.out.println("Não foi possível criar o vértice!!!");
        }
    }

    public void remove_adjacencia(int i, int j){
        if (i >= 0 && i < vertice && j >= 0 && j < vertice){
            matriz[i][j] = 0;
        } else{
            System.out.println("Não foi possível remover a adjacencia!!");
        }
    }

    public void seta_informacao( int i, String V){
        if (i >= 0 && i < vertice){
            rotulo[i] = V;
        } else {
            System.out.println("Não foi possível atualizar a informação do vértice!!!");
        }
    }

    public int adjacentes(int i, int[] adj) {
        int contador = 0;
        if (i >= 0 && i < vertice) {
            for (int j = 0; j < vertice; j++) {
                if (matriz[i][j] != 0) {
                    adj[contador++] = j;
                }
            }
            System.out.printf("\nQuantidade de adjacentes de %s: %d\n" , rotulo[i], contador);
        } else {
            System.out.println("Vértice Inválido!!");
        }
        return contador;
    }


    public void imprime(){
        System.out.print(" ");
        for (int j = 0; j < vertice; j++) {
            System.out.printf("%2s", rotulo[j]);
        }
        System.out.println();
        for (int i = 0; i < vertice; i++){
            System.out.print(rotulo[i] + " ");
            for (int j = 0; j < vertice; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
