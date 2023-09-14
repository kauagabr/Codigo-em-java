package atv_Estrutura_de_dados;

public class Pilha {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Pilha(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) { // O método push é usado para inserir um elemento (value) no topo da pilha.
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            throw new RuntimeException("A pilha está cheia. não pode inserir " + value);
        }
    }

    public int pop() { // O método pop remove e retorna o elemento no topo da pilha.
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            throw new RuntimeException("A pilha está vazia.");
        }
    }

    public int peek() { // O método peek retorna o elemento no topo da pilha sem removê-lo. 
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            throw new RuntimeException("A pilha está vazia.");
        }
    }

    public boolean isEmpty() { // O método isEmpty verifica se a pilha está vazia. 
        return (top == -1);
    }

    public boolean isFull() { // O método isFull verifica se a pilha está cheia.
        return (top == maxSize - 1);
    }

    public int size() { // O método size retorna o número de elementos na pilha.
        return top + 1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Pop: " + pilha.pop()); // Output: Pop: 30
        System.out.println("Peek: " + pilha.peek()); // Output: Peek: 20
        System.out.println("Size: " + pilha.size()); // Output: Size: 2
    }
}