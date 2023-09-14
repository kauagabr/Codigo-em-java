package atv_Estrutura_de_dados;

public class Fila {
    private int maxSize;
    private int[] filaArray;
    private int frente;
    private int fim;
    private int quantidade;

    public Fila(int tamanho) {
        maxSize = tamanho;
        filaArray = new int[maxSize];
        frente = 0;
        fim = -1;
        quantidade = 0;
    }

    public void enqueue(int valor) { // O método enqueue insere um elemento (valor) no final da fila.
        if (!isFull()) {
            if (fim == maxSize - 1) {
                fim = -1;
            }
            filaArray[++fim] = valor;
            quantidade++;
        } else {
            throw new RuntimeException("A fila está cheia. Não é possível enfileirar " + valor);
        }
    }

    public int dequeue() { // O método dequeue retira e retorna o elemento na frente da fila.
        if (!isFull()) {
            int temp = filaArray[frente++];
            if (frente == maxSize) {
                frente = 0;
            }
            quantidade--;
            return temp;
        } else {
            throw new RuntimeException("A fila está vazia.");
        }
    }

    public int size() { // O método size retorna a quantidade de elementos na fila.
        return quantidade;
    }

    public boolean isEmpty() { // O método isEmpty verifica se a fila está vazia.
        return (quantidade == 0);
    }

    public boolean isFull() { // O método isFull verifica se a fila está cheia.
        return (quantidade == maxSize);
    }

    public int front() { //  O método front retorna o elemento na frente da fila, mas não o remove.
        if (!isEmpty()) {
            return filaArray[frente];
        } else {
            throw new RuntimeException("A fila está vazia.");
        }
    }
    

    public static void main(String[] args) {
        Fila fila = new Fila(5);

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Dequeue: " + fila.dequeue()); 
        System.out.println("Front: " + fila.front()); 
        System.out.println("Size: " + fila.size()); 
    }
}