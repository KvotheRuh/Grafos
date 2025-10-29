import java.util.*;

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

   public void criaAdjacenciaNaoDirecionada(int inicio, int destino, double peso){
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

         Vertice  fim = vertices[destino];
         Aresta segundaAresta = new Aresta(inicio, peso);

         if (fim.inicio == null){
            fim.inicio = segundaAresta;
         } else {
            Aresta corrente = fim.inicio;
            while (corrente.proximo != null){
               corrente = corrente.proximo;
            }
            corrente.proximo = segundaAresta;
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

   public void Prim(int inicio, int destino) {
      List<Integer> visitados = new ArrayList<>();
      List<String> arvore = new ArrayList<>();
      Map<Aresta, List<Object>> adjacencias = new HashMap<>();


      visitados.add(inicio);

      while (true) {
         Vertice origem = vertices[inicio];
         Aresta atual = origem.inicio;

         while (atual != null) {
            if (!visitados.contains(atual.destino)) {
               List<Object> arestas = new ArrayList<>();
               arestas.add(origem);
               arestas.add(atual.destino);
               arestas.add(atual.peso);
               adjacencias.put(atual, arestas);
            }
            atual = atual.proximo;
         }

         Map.Entry<Aresta, List<Object>> menor = adjacencias.entrySet()
                 .stream()
                 .min(Comparator.comparingDouble(e -> (double) e.getValue().get(2)))
                 .orElse(null);


         Aresta proximoAresta = menor.getKey();
         Vertice verticeInicio = (Vertice) menor.getValue().get(0);
         int proximoVertice = (int) menor.getValue().get(1);
         double peso = (double) menor.getValue().get(2);

         Vertice verticeDestino = vertices[proximoVertice];

         arvore.add(verticeInicio.rotulo + " -> " + verticeDestino.rotulo + " (" + peso + ")");

         visitados.add(proximoVertice);
         adjacencias.remove(proximoAresta);


         inicio = proximoVertice;

         if (inicio == destino) {
            break;
         }

         if (visitados.size() == vertices.length) {
            break;
         }
      }

      System.out.println("Árvore geradora mínima:");
      for (String aresta : arvore) {
         System.out.println(aresta);
      }
   }

   public void buscaComponente(int inicio, List<Integer> componentes, List<Integer> visitados) {
      visitados.add(inicio);
      componentes.add(inicio);

      Vertice origem = vertices[inicio];
      Aresta atual = origem.inicio;

      while (atual != null) {
         if (!visitados.contains(atual.destino)) {
            buscaComponente(atual.destino, componentes, visitados);
         }

         atual = atual.proximo;
      }
   }

   public int encontraComponente() {
      List<Integer> visitados = new ArrayList<>();
      int contadorComponentes = 0;

      for (int i = 0; i < quantidadeVertices; i++) {
         if (!visitados.contains(i) && vertices[i] != null) {
            List<Integer> componentes = new ArrayList<>();
            buscaComponente(i,  componentes,visitados);

            System.out.print("\nComponente " + contadorComponentes + ": ");
            for (int j = 0; j < componentes.size(); j++) {
               System.out.print(vertices[componentes.get(j)].rotulo);
               if (j < componentes.size() - 1) System.out.print(", ");
            }
            System.out.println();
            contadorComponentes++;
         }
      }
      System.out.println("Total de componentes no Grafo: " +  contadorComponentes);
      System.out.println();
      return contadorComponentes;
   }


   public void conexo (ListaAdjacencia grafo) {
      List<Integer> visitados = new ArrayList<>();
      int contadorComponentes = 0;

      for (int i = 0; i < quantidadeVertices; i++) {
         if (!visitados.contains(i) && vertices[i] != null) {
            List<Integer> componentes = new ArrayList<>();
            buscaComponente(i,  componentes,visitados);

            contadorComponentes++;
         }
      }

      if(contadorComponentes == 1) {
         System.out.println("O grafo é conexo!!!");
      } else {
         System.out.println("O grafo não é conexo!!");
      }
      System.out.println(" ");

   }

   public boolean ehClique(List<Integer> listaVertices) {
      List<Integer> adj = new ArrayList<>();
      for(int i = 0; i < listaVertices.size(); i++){
        int verticeCorrente = listaVertices.get(i);

        Vertice origem = vertices[verticeCorrente];
        Aresta atual = origem.inicio;

        adj.clear();

        for (int j = i + 1; j < listaVertices.size(); j ++){
           int verticeSeguinte = listaVertices.get(j);

           while (atual != null){
              adj.add(atual.destino);
              atual = atual.proximo;
           }

           if (!adj.contains(verticeSeguinte)) {
              return false;
           }
        }
      }
      return true;
   }

   public boolean ehMaximal(List<Integer> listaVertices, ListaAdjacencia grafo){
//    Pegar os vertices do grafo que não pertencem a lista que esta senod verificada e conferir se
//      com esse vertices forma um novo clique. Se formar retorna falso.


      return false;
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