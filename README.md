<<<<<<< HEAD
# Grafos
Atividades de Grafos
=======
# Biblioteca de Grafos

### Desenvolvido por: Carlos Eduardo Nogueira Morciani

---

Este projeto é uma implementação de uma biblioteca para a manipulação e análise de grafos,
desenvolvida com o objetivo de aplicar conceitos da Teoria dos Grafos.

A biblioteca permite criar grafos rotulados utilizando lista ou matriz de adjacência, adicionar ou remover adjacências,
efetuar busca e aplicar métricas de análise estrutural do grafo.

OBS: Algumas funcionalidades estão disponíveis apenas para a estrutura de lista de adjacência.

O projeto também conta com a implementação de uma classe Fila, utilizada para realizar a busca por largura.

Por fim, recomendo que em caso de rodar um grafo grande remova os prints dos métodos de busca e centralidade.

---

## Funcionalidades
### Manipulação do Grafo

- Criar grafo
  - Lista de adjacência
  - Matriz de adjacência
- Adicionar vértices
  - Adicionar rótulos
- Criar adjacência
- Criar adjacência não direcionada
- Remover adjacência

### Operações de Estrutura (Lista de adjacência)
- Buscas adjacentes
- Contar quantidade de adjacentes
- Buscar os vértices com maior grau de saída
- Buscar os vértices com maior grau de entrada
- Buscar os vértices que estão a uma distância de X arestas de um vértice
- Encontrar componentes do grafo
- Verificar se o grafo é conexo
- Verificar se o grafo é um clique
- Verificar se o grafo é Maximal
- Verificar se o grafo é Euleriano
- Verificar a existência de ciclos

### Algoritmos de busca (Lista de adjacência)
- Busca em Profundidade
- Busca em Largura

### Árvore Geradora Mínima (Lista de adjacência)
- Algoritmo de Prim

### Análise Estrutural de Grafos (Lista de adjacência)
- Centralidade de proximidade
- Centralidade de intermediação

### Algoritmos de Caminho Mínimo (Lista de adjacência)
- Algoritmo de Dijkstra

### Algoritmos de Conectividade (Matriz de adjacência)
- Algoritmo de Warshall

## Estrutura do Projeto
```text
    BibliotecaGrafos
        │
        ├── AlgoritmoDijkstra.java
        ├── AlgoritmoWarshall.java
        ├── Aresta.java
        ├── ConverteLista.java
        ├── Fila.java
        ├── ListaAdjacencia.java
        ├── Main.java
        ├── MatrizAdjacencia.java
        └── Vertice.java
```

## Como executar
```text
    - git clone https://github.com/KvotheRuh/Grafos.git
    - Abrir a IDE da sua escolha
    - Executar o arquivo Main
```

## Exemplo
```java
// Criar o grafo
ListaAdjacencia grafoLista = new ListaAdjacencia(7);
MatrizAdjacencia grafoMatriz = new MatrizAdjacencia(7);


// Adicionar rótulos
String[] rotulos = {"A","B","C","D","E","F","G"};

// Criar adjacência
grafoLista.criaAdjacencia(0, 1, 5);
grafoLista.criaAdjacenciaNaoDirecionada(0, 1, 5);
```

## Tecnologias
- Java

>>>>>>> master
