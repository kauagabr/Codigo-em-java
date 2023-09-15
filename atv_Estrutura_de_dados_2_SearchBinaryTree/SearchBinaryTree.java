package atv_Estrutura_de_dados_2_SearchBinaryTree;

public class SearchBinaryTree <T extends Comparable<T>>{
	
	private Node<T> root;
	
	public SearchBinaryTree() {
		root = null;
	}
	
	// Inserção do elemento na árvore.
	public void insert(T data) throws InvalidInsertionException {
		root = insertRec(root, data);
	}
	
	private Node<T> insertRec(Node<T> root, T data) throws InvalidInsertionException {
		if (root == null) {
			root = new Node<T>(data);
			return root;
		}
		if (data.compareTo(root.data) < 0) {
			root.left = insertRec(root.left, data);
		} else if (data.compareTo(root.data) > 0) {
			root.right = insertRec(root.right, data);
		} else {
			throw new InvalidInsertionException("Inserção inválida: Elemento duplicado. ");
		}
		return root;
	}
	
	
	// Impressão da árvore ordenada (in-ordem).
	public void inOrder() {
		inOrderRec(root);
	}
	private void inOrderRec(Node<T> root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.print(root.data + " ");
			inOrderRec(root.right);
		}
	}
	
	
	// Impressão da árvore ordenada (pré-ordem).
	public void preOrder() {
		preOrderRec(root);
	}
	private void preOrderRec(Node<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			inOrderRec(root.left);
			inOrderRec(root.right);
		}
	}
	
	
	// Impressão da árvore ordenada (pós-ordem).
	public void posOrder() {
		posOrderRec(root);
	}
	
	private void posOrderRec(Node<T> root) {
		if (root != null) {
			inOrderRec(root.left);
			inOrderRec(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	
	public static void main(String[] args) {
		SearchBinaryTree<Integer> tree = new SearchBinaryTree<>();
		try {
			tree.insert(5);
			tree.insert(3);
			tree.insert(7);
			tree.insert(1);
			tree.insert(4);
			tree.insert(6);
			tree.insert(8);
			tree.insert(10);
			
			
			System.out.println("Arvore in-Ordem:");
			tree.inOrder();
			
			System.out.println("\n\nArvore pre-Ordem:");
			tree.preOrder();
			
			System.out.println("\n\nArvore pos-Ordem:");
			tree.posOrder();
			
		} catch (InvalidInsertionException e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}


