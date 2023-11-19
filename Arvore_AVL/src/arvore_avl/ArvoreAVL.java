package arvore_avl;

public class ArvoreAVL<T extends Comparable<T>> {
	No<T> raiz;

	// Calcula a altura de um nó
	private int altura(No<T> no) {
		if (no == null) {
			return 0;
		}
		return no.altura;
	}

	// Calcula o fator de balanceamento de um nó
	private int fatorBalanceamento(No<T> no) {
		if (no == null) {
			return 0;
		}
		return altura(no.left) - altura(no.right);
	}

	// Atualiza a altura de um nó
	private void atualizaAltura(No<T> no) {
		if (no != null) {
			no.altura = 1 + Math.max(altura(no.left), altura(no.right));
		}
	}

	// Realiza uma rotação à direita em torno do nó y
	private No<T> rotacaoDireita(No<T> y) {
		No<T> x = y.left;
		No<T> T2 = x.right;

		// Realiza a rotação
		x.right = y;
		y.left = T2;

		// Atualiza alturas
		atualizaAltura(y);
		atualizaAltura(x);

		// Retorna a nova raiz
		return x;
	}

	// Realiza uma rotação à esquerda em torno do nó x
	private No<T> rotacaoEsquerda(No<T> x) {
		No<T> y = x.right;
		No<T> T2 = y.left;

		// Realiza a rotação
		y.left = x;
		x.right = T2;

		// Atualiza alturas
		atualizaAltura(x);
		atualizaAltura(y);

		// Retorna a nova raiz
		return y;
	}

	// Insere um valor na árvore AVL
	private No<T> inserir(No<T> no, T valor) {
		// Passo 1: Inserção normal de uma árvore binária de pesquisa
		if (no == null) {
			return new No<>(valor);
		}

		if (valor.compareTo(no.data) < 0) {
            no.left = inserir(no.left, valor);
        } else if (valor.compareTo(no.data) > 0) {
            no.right = inserir(no.right, valor);
        } else {
            // Duplicatas não são permitidas
            return no;
        }

		// Passo 2: Atualiza a altura do nó atual
		atualizaAltura(no);

		// Passo 3: Obtemos o fator de balanceamento deste nó para verificar se ele se tornou desequilibrado
		int balanceamento = fatorBalanceamento(no);

		// Passo 4: Verifica os casos de desequilíbrio e realiza as rotações necessárias

		// Caso Esquerda-Esquerda
        if (balanceamento > 1 && valor.compareTo(no.left.data) < 0) {
            return rotacaoDireita(no);
        }

        // Caso Direita-Direita
        if (balanceamento < -1 && valor.compareTo(no.right.data) > 0) {
            return rotacaoEsquerda(no);
        }

        // Caso Esquerda-Direita
        if (balanceamento > 1 && valor.compareTo(no.left.data) > 0) {
            no.left = rotacaoEsquerda(no.left);
            return rotacaoDireita(no);
        }

        // Caso Direita-Esquerda
        if (balanceamento < -1 && valor.compareTo(no.right.data) < 0) {
            no.right = rotacaoDireita(no.right);
            return rotacaoEsquerda(no);
        }

		// Se o nó não estiver desequilibrado, apenas retorna o nó (sem alterações)
		return no;
	}
	
	// Realiza um percurso em ordem na árvore AVL
		private void percursoEmOrdem(No<T> no) {
			if (no != null) {
				percursoEmOrdem(no.left);
				System.out.print(no.data + " ");
				percursoEmOrdem(no.right);
			}
		}

	// Método auxiliar para inserir um valor na árvore
	public void inserir(T valor) {
		raiz = inserir(raiz, valor);
	}

	// Método auxiliar para realizar um percurso em ordem
	public void percursoEmOrdem() {
		percursoEmOrdem(raiz);
	}
	
	public static void main(String[] args) {
        ArvoreAVL<Integer> arvore = new ArvoreAVL<Integer>();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(50);
        arvore.inserir(25);

        System.out.println("Percurso em Ordem da Árvore AVL:");
        arvore.percursoEmOrdem();
    }
}
