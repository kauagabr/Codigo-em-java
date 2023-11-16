package arvore_avl;

public class ArvoreAVL {
	No raiz;

	// Calcula a altura de um nó
	int altura(No no) {
		if (no == null) {
			return 0;
		}
		return no.altura;
	}

	// Calcula o fator de balanceamento de um nó
	int fatorBalanceamento(No no) {
		if (no == null) {
			return 0;
		}
		return altura(no.esquerda) - altura(no.direita);
	}

	// Atualiza a altura de um nó
	void atualizaAltura(No no) {
		if (no != null) {
			no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
		}
	}

	// Realiza uma rotação à direita em torno do nó y
	No rotacaoDireita(No y) {
		No x = y.esquerda;
		No T2 = x.direita;

		// Realiza a rotação
		x.direita = y;
		y.esquerda = T2;

		// Atualiza alturas
		atualizaAltura(y);
		atualizaAltura(x);

		// Retorna a nova raiz
		return x;
	}

	// Realiza uma rotação à esquerda em torno do nó x
	No rotacaoEsquerda(No x) {
		No y = x.direita;
		No T2 = y.esquerda;

		// Realiza a rotação
		y.esquerda = x;
		x.direita = T2;

		// Atualiza alturas
		atualizaAltura(x);
		atualizaAltura(y);

		// Retorna a nova raiz
		return y;
	}

	// Insere um valor na árvore AVL
	No inserir(No no, int valor) {
		// Passo 1: Inserção normal de uma árvore binária de pesquisa
		if (no == null) {
			return new No(valor);
		}

		if (valor < no.valor) {
			no.esquerda = inserir(no.esquerda, valor);
		} else if (valor > no.valor) {
			no.direita = inserir(no.direita, valor);
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
		if (balanceamento > 1 && valor < no.esquerda.valor) {
			return rotacaoDireita(no);
		}

		// Caso Direita-Direita
		if (balanceamento < -1 && valor > no.direita.valor) {
			return rotacaoEsquerda(no);
		}

		// Caso Esquerda-Direita
		if (balanceamento > 1 && valor > no.esquerda.valor) {
			no.esquerda = rotacaoEsquerda(no.esquerda);
			return rotacaoDireita(no);
		}

		// Caso Direita-Esquerda
		if (balanceamento < -1 && valor < no.direita.valor) {
			no.direita = rotacaoDireita(no.direita);
			return rotacaoEsquerda(no);
		}

		// Se o nó não estiver desequilibrado, apenas retorna o nó (sem alterações)
		return no;
	}

	// Método auxiliar para inserir um valor na árvore
	void inserir(int valor) {
		raiz = inserir(raiz, valor);
	}

	// Realiza um percurso em ordem na árvore AVL
	void percursoEmOrdem(No no) {
		if (no != null) {
			percursoEmOrdem(no.esquerda);
			System.out.print(no.valor + " ");
			percursoEmOrdem(no.direita);
		}
	}

	// Método auxiliar para realizar um percurso em ordem
	void percursoEmOrdem() {
		percursoEmOrdem(raiz);
	}

}
