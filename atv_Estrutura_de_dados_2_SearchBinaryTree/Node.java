package atv_Estrutura_de_dados_2_SearchBinaryTree;

public class Node<T> {
	
	T data;
	Node<T> left;
	Node<T> right;
	
	public Node(T data) {
		this.data = data;
		left = null;
		right = null;
	}
}

