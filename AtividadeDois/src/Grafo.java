import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {
    List<Aresta>[]lista;
    private String[] rotulo;
    private int vertice;

    public Grafo(int vertice) {
        this.vertice = vertice;
        lista = new List[vertice] ;
        rotulo = new String[vertice];

        for (int i = 0; i < vertice; i++){
            lista[i] = new ArrayList<>();
            rotulo[i] = "V" + i;
        }
    }

    public void cria_adjacencia(int i, int j, int P) {
        if (i >= 0 && i < vertice && j >= 0 && j < vertice) {
            lista[i].add(new Aresta(j, P));
        } else {
            System.out.println("Não foi possível criar o vértice!!!");
        }
    }

    public void remove_adjacencia(int i, int j) {
        if (i >= 0 && i < vertice && j >= 0 && j < vertice) {
            Iterator<Aresta> it = lista[i].iterator();
            while (it.hasNext()) {
                Aresta a = it.next();
                if (a.destino == j) {
                    it.remove();
                }
            }
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

    public void adjacentes(int i, int[] adj) {
        int contador = 0;
        if (i >= 0 && i < vertice) {
            for (Aresta aresta : lista[i]) {
                adj[contador++] = aresta.destino;
            }
            System.out.printf("\nQuantidade de adjacentes de %s: %d\n", rotulo[i], contador);
        } else {
            System.out.println("Vértice Inválido!!");
        }
    }


    public void imprime() {
        for (int i = 0; i < vertice; i++) {
            System.out.print(rotulo[i] + " -> ");
            for (Aresta aresta : lista[i]) {
                System.out.print(rotulo[aresta.destino] + "(" + aresta.peso + ") ");
            }
            System.out.println();
        }
    }
}
