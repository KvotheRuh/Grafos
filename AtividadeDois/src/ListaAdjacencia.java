public class ListaAdjacencia {
   public Vertice[] vertices;
   public int quantidadeVertices;

   public ListaAdjacencia(int numeroVertices) {
      this.vertices = new Vertice[numeroVertices];
      this.quantidadeVertices = numeroVertices;
   }

   public void setaInformacao(int vertice, String rotulo){
      if(vertice >= 0 && vertice < quantidadeVertices){
         vertices[vertice] = new Vertice(rotulo, null);
      }
   }

   public void criaAdjacencia(int inicio, int destino, double peso){
      if(inicio >= 0 && inicio < quantidadeVertices && destino >= 0 && destino < quantidadeVertices){
         Vertice origem = vertices[inicio];
         Aresta novaAresta = new Aresta(destino,peso);

         if(origem.inicio == null){
            origem.inicio = novaAresta;
         } else {
            Aresta atual = origem.inicio;
            while (atual.proximo != null){
               atual = atual.proximo;
            }
            atual.proximo = novaAresta;
         }
      }
   }

   public void removeAdjacencia(int inicio,int destino) {
      if (inicio >= 0 && inicio < quantidadeVertices && destino >= 0 && destino < quantidadeVertices) {
         Vertice origem = vertices[inicio];
         Aresta atual = origem.inicio;
         Aresta anterior = null;

         while (atual != null) {
            if (atual.destino == destino) {
               if (anterior == null) {
                  origem.inicio = atual.proximo;
               } else {
                  anterior.proximo = atual.proximo;
               }
               return;
            }
            anterior = atual;
            atual = atual.proximo;
         }
      }
   }

   public void adjacentes (int vertice) {
      Vertice origem =  vertices[vertice];
      int contador = 0;
      Aresta atual = origem.inicio;
      String concatenaAjacentes = "";

      if (vertice < 0 || vertice >= quantidadeVertices){
         System.out.println("Vértice inválido.");
         return;
      }
      if (origem == null){
         System.out.println("O vértice não possui adjacentes.");
         return;
      }

      while (atual != null) {
         Vertice destino = vertices[atual.destino];
         concatenaAjacentes +=  destino.rotulo + "(peso " + atual.peso + ")";
         atual = atual.proximo;
         contador++;

         if (atual != null) {
            concatenaAjacentes +=  ", ";
         }
      }

      System.out.printf("\nAdjacente de %s: %s\n", origem.rotulo, concatenaAjacentes);
      System.out.printf("Quantidade de adjacentes de %s: %d\n", origem.rotulo, contador);
      System.out.println(" ");
   }

   public void imprime() {
      for (int i = 0; i < quantidadeVertices; i++) {
         Vertice origem = vertices[i];
         if (origem != null) {
            System.out.print(origem.rotulo + " -> ");
            Aresta atual = origem.inicio;
            while (atual != null) {
               Vertice destino = vertices[atual.destino];
               System.out.print(destino.rotulo + "(" + atual.peso + ")");
               atual = atual.proximo;

               if (atual != null){
                  System.out.print(" -> ");
               }
            }
            System.out.println();
         }
      }
   }
}
