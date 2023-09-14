package atv_Estrutura_de_dados;

class Node { // A classe Node é usada para criar os nós individuais da lista encadeada circular.
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Lista_encadeada {
    private Node head;
    private int size;

    public Lista_encadeada() {
        head = null;
        size = 0;
    }

    public int get(int index) { // O método get retorna o elemento da lista com o índice especificado (index).
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int set(int index, int value) { // O método set substitui o valor do elemento da lista com o índice especificado (index) pelo novo valor (value). 
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        int oldValue = current.data;
        current.data = value;
        return oldValue;
    }

    public void add(int index, int value) { // O método add insere um novo elemento com o valor especificado
    	//  (value) na lista, de modo que ele tenha o índice especificado (index).
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            newNode.next = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public int remove(int index) { // O método remove remove o elemento da lista com o índice especificado (index).
        if (isEmpty() || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int removedValue;
        if (index == 0) {
            removedValue = head.data;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedValue = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedValue;
    }

    public boolean isEmpty() { // O método isEmpty verifica se a lista está vazia.
        return size == 0;
    }

    public int size() { // O método size retorna o número de elementos na lista.
        return size;
    }

    public static void main(String[] args) {
        Lista_encadeada list = new Lista_encadeada();

        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);

        System.out.println("Elemento no índice 1: " + list.get(1)); 
        System.out.println("Size: " + list.size()); 

        list.set(1, 25);
        System.out.println("Elemento no índice 1 após definido: " + list.get(1)); 

        list.remove(1);
        System.out.println("Tamanho após remover: " + list.size()); 
    }
}