import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   public int[] adjacentes (int vertice, int[] adj) {
      Vertice origem =  vertices[vertice];
      int contador = 0;
      Aresta atual = origem.inicio;

      if (vertice < 0 || vertice >= quantidadeVertices){
         System.out.println("Vértice inválido.");
         return null;
      }

      if (origem == null){
         System.out.println("O vértice não possui adjacentes.");
         return null;
      }

      while (atual != null) {
         adj[contador] = atual.destino;
         contador++;
         atual = atual.proximo;

      }

      System.out.print("\nAdjacente de " + origem.rotulo + ": ");
      if (contador != 0){
         for (int i = 0; i < contador; i++) {
            System.out.print(vertices[adj[i]].rotulo);
            if (i < contador - 1){
               System.out.print(", ");
            }
         }
      } else {
         System.out.println("O vértice não possui adjacentes!!!");
      }

      System.out.printf("\nQuantidade de adjacentes de %s: %d\n", origem.rotulo, contador);
      System.out.println(" ");

      return adj;
   }


   public void saida () {
      Map<String, Integer> contadorSaida = new HashMap<>();

      for (int i = 0; i < quantidadeVertices; i++) {
         Vertice origem = vertices[i];
         int contador = 0;

         if (origem != null) {
            Aresta atual = origem.inicio;

            if (atual == null) {
               contadorSaida.put(origem.rotulo,contador);
               continue;
            }

            while (atual != null) {
               contador++;
               contadorSaida.put(origem.rotulo, contador);
               atual = atual.proximo;

            }
         }
      }
      System.out.println("\nOs 20 vértices com maior grau de saída: ");
      contadorSaida.entrySet().stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .limit(20)
              .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
   }


   public void entrada() {
      Map<String, Integer> contadorEntrada = new HashMap<>();

      for (int i = 0; i < quantidadeVertices; i++){
         Vertice origem = vertices[i];

         if(origem != null){
            contadorEntrada.put(origem.rotulo, 0);
         }
      }

      for (int i = 0; i < quantidadeVertices; i++) {
         Vertice origem = vertices[i];
         int contador = 0;

         if (origem != null) {
            Aresta atual = origem.inicio;

            if (atual == null) {
               continue;
            }

            while (atual != null && atual.destino != -1) {
               Vertice destino = vertices[atual.destino];

               if (contadorEntrada.get(destino.rotulo) != null) {
                  contador = contadorEntrada.get(destino.rotulo);
               }

               contador++;
               contadorEntrada.put(destino.rotulo, contador);

               atual = atual.proximo;
            }
         }
      }

      System.out.println("\nOs 20 vértices com maior grau de entrada: ");
      contadorEntrada.entrySet().stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .limit(20)
              .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
   }

   public List<Integer> distancia(int inicio, int numArestas, List<Integer> visitados) {

      visitados.add(inicio);
      List<Integer> resultado = new ArrayList<>();

      System.out.println("Pilha distância: " + visitados);
      System.out.println("--------------------------");

      if (numArestas == 0) {
         resultado.add(inicio);
         visitados.remove(visitados.size() - 1);
         return resultado;
      }

      Vertice origem = vertices[inicio];
      Aresta atual = origem.inicio;

      while (atual != null) {
         if (!visitados.contains(atual.destino)) {
            List<Integer> caminho = distancia(atual.destino, numArestas - 1, visitados);
            if (caminho != null) {
               for (int valor : caminho){
                  if (resultado.contains(valor)){
                     resultado.add(valor);
                  }
               }
            }
         }

         atual = atual.proximo;

      }

      visitados.remove(visitados.size() - 1);

      if (visitados.isEmpty()) {
         System.out.print("\nOs indivíduos que estão a distância de " + numArestas +  " arestas de " + origem.rotulo + " são: ");
         for (int i = 0; i < resultado.size(); i++) {
            System.out.print(vertices[resultado.get(i)].rotulo);
            if (i < resultado.size() - 1) {
               System.out.print(", ");
            }
         }

         System.out.println("\n");
      }

      return resultado;
   }


   public List<Integer> profundidade(int inicio, int destino, List<Integer> visitados) {

      visitados.add(inicio);

      System.out.println("Pilha: " + visitados);
      System.out.println("--------------------------");

      if (inicio == destino) {
         System.out.print("\nBusca por profundidade caminho: ");
         for (int i = 0; i < visitados.size(); i++) {
            System.out.print(vertices[visitados.get(i)].rotulo);
            if (i < visitados.size() - 1) {
               System.out.print(", ");
            }
         }

         System.out.println("\n");

         return visitados;

      } else {
         Vertice origem = vertices[inicio];
         Aresta atual = origem.inicio;

         while (atual != null) {
            if (!visitados.contains(atual.destino)) {
               List<Integer> caminho = profundidade(atual.destino, destino, visitados);
               if (caminho != null) {
                  return caminho;
               }
            }

            atual = atual.proximo;
         }

         visitados.remove(visitados.size() - 1);

         if (visitados.isEmpty()) {
            System.out.printf("Nenhum caminho encontrado entre %s e %s \n", vertices[inicio].rotulo, vertices[destino].rotulo);
         }

         return null;
      }
   }


   public List<Integer> largura(Fila fila, int inicio, int destino, List<Integer> visitados){

      fila.insereElemento(inicio);

      while (!fila.filaVazia()){
         int indiceAtual = fila.removeElemento();

         if (!visitados.contains(indiceAtual)) {
            visitados.add(indiceAtual);
         }

         if (indiceAtual == destino) {
            System.out.print("\nBusca por largura caminho: ");
            for (int i = 0; i < visitados.size(); i++) {
               System.out.print(vertices[visitados.get(i)].rotulo);
               if (i < visitados.size() - 1) {
                  System.out.print(", ");
               }
            }

            System.out.println("\n");

            return visitados;
         }

         Vertice origem = vertices[indiceAtual];
         Aresta atual = origem.inicio;

         System.out.print("Fila: ");fila.imprimirFila();

         while(atual != null){
            if (!visitados.contains(atual.destino) && !fila.encontraElemento(atual.destino)){
               fila.insereElemento(atual.destino);

            }

            atual = atual.proximo;
         }

         System.out.println("Visitando -> " + indiceAtual);
         System.out.print("Fila: ");
         fila.imprimirFila();
         System.out.println("Visitados: " + visitados);
         System.out.println("--------------------------");
      }

      System.out.println("Destino não encontrado!");

      return null;
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
