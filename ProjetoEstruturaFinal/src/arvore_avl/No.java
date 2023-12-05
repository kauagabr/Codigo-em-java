package arvore_avl;

public class No<T> {
	T data;
    int altura;
    No<T> left;
    No<T> right;

    public No(T valor) {
        this.data = valor;
        this.altura = 1;
        this.left = null;
        this.right = null;
    }
}
