package arvore_avl;

public class ArvoreAVL<T extends Comparable<T>> {
	No<T> raiz;
	
	int altura(No<T> no) {
	    if (no == null) {
	        return 0;
	    }
	    return no.altura;
	}

	public int fatorBalanceamento(No<T> no) {
		if (no == null) {
			return 0;
		}
		return altura(no.left) - altura(no.right);
	}

	private void atualizaAltura(No<T> no) {
		if (no != null) {
			no.altura = 1 + Math.max(altura(no.left), altura(no.right));
		}
	}

	private No<T> rotacaoDireita(No<T> y) {
		No<T> x = y.left;
		No<T> T2 = x.right;

		x.right = y;
		y.left = T2;

		atualizaAltura(y);
		atualizaAltura(x);

		return x;
	}

	private No<T> rotacaoEsquerda(No<T> x) {
		No<T> y = x.right;
		No<T> T2 = y.left;

		y.left = x;
		x.right = T2;

		atualizaAltura(x);
		atualizaAltura(y);

		return y;
	}

	private No<T> inserir(No<T> no, T valor) {
		if (no == null) {
			return new No<>(valor);
		}
				
		
		if (valor.compareTo(no.data) < 0) {
			no.left = inserir(no.left, valor);
		} else if (valor.compareTo(no.data) > 0) {
			no.right = inserir(no.right, valor);
		} else {
			return no;
		}

		atualizaAltura(no);

		int balanceamento = fatorBalanceamento(no);

		if (balanceamento > 1 && valor.compareTo(no.left.data) < 0) {
			return rotacaoDireita(no);
		}

		if (balanceamento < -1 && valor.compareTo(no.right.data) > 0) {
			return rotacaoEsquerda(no);
		}

		if (balanceamento > 1 && valor.compareTo(no.left.data) > 0) {
			no.left = rotacaoEsquerda(no.left);
			return rotacaoDireita(no);
		}

		if (balanceamento < -1 && valor.compareTo(no.right.data) < 0) {
			no.right = rotacaoDireita(no.right);
			return rotacaoEsquerda(no);
		}

		return no;
	}

	private No<T> remover(No<T> no, T valor) {
		if (no == null) {
			return no;
		}

		if (valor.compareTo(no.data) < 0) {
			no.left = remover(no.left, valor);
		} else if (valor.compareTo(no.data) > 0) {
			no.right = remover(no.right, valor);
		} else {
			if (no.left == null) {
				return no.right;
			} else if (no.right == null) {
				return no.left;
			}
			else {
				no.data = encontrarMenorValor(no.right);
				no.right = remover(no.right, no.data);
			} 	
		}


		atualizaAltura(no);

		int balanceamento = fatorBalanceamento(no);

		if (balanceamento > 1 && fatorBalanceamento(no.left) >= 0) {
			return rotacaoDireita(no);
		}

		if (balanceamento > 1 && fatorBalanceamento(no.left) < 0) {
			no.left = rotacaoEsquerda(no.left);
			return rotacaoDireita(no);
		}

		if (balanceamento < -1 && fatorBalanceamento(no.right) <= 0) {
			return rotacaoEsquerda(no);
		}

		if (balanceamento < -1 && fatorBalanceamento(no.right) > 0) {
			no.right = rotacaoDireita(no.right);
			return rotacaoEsquerda(no);
		}

		return no;
	}

	private T encontrarMenorValor(No<T> no) {
		T minValue = no.data;
        while (no.left != null) {
            minValue = no.left.data;
            no = no.left;
        }
        return minValue;
	}

	private void percursoEmOrdem(No<T> no) {
		if (no != null) {
			percursoEmOrdem(no.left);
			System.out.print(no.data + " ");
			percursoEmOrdem(no.right);
		}
	}

	public void inserir(T valor) {
		raiz = inserir(raiz, valor);
	}

	public void percursoEmOrdem() {
		percursoEmOrdem(raiz);
	}

	public void remover(T valor) {
		raiz = remover(raiz, valor);
	}

	public static void main(String[] args) {
		ArvoreAVL<Integer> arvore = new ArvoreAVL<Integer>();

		arvore.inserir(47);
		arvore.inserir(25);
		arvore.inserir(91);
		arvore.inserir(17);
		arvore.inserir(36);
		arvore.inserir(13);
		arvore.inserir(42);
		arvore.inserir(14);
		
		System.out.println("Percurso em Ordem da Arvore AVL:");
		arvore.percursoEmOrdem();
	}
}
