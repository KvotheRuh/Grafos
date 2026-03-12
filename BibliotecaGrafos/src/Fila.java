public class Fila {
    class  No{
        int dado;
        No proximo;

        No( int elemento){
            this.dado = elemento;
            this.proximo = null;
        }
    }

    No inicio = null;
    No fim = null;

    public boolean filaVazia(){
        return inicio == null;
    }


    public void insereElemento(int elemento){
        No novoNo = new No(elemento);

        if (inicio == null){
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public boolean encontraElemento(int elemento) {
        No atual = inicio;

        while (atual != null) {
            if (atual.dado == elemento) {
                return true;
            }
            atual = atual.proximo;

        }
        return false;
    }


    public int removeElemento() {
        if (filaVazia()){
            System.out.println("A fila está vazia!!!");
            return -1;
        }

        int elemento = inicio.dado;
        inicio = inicio.proximo;

        if(inicio == null){
            fim = null;
        }

        return elemento;
    }


    public void imprimirFila() {
        if (filaVazia()) {
            return;
        }
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}