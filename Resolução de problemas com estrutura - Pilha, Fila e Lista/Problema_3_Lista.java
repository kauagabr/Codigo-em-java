package atv_Estrutura_de_dados_2;
import java.util.LinkedList;
import java.util.ListIterator;

// Problema: Sistema de Histórico de Navegação em um Navegador Web
// Explicação: Este problema envolve a implementação de um sistema de 
//		       histórico de navegação em um navegador web, permitindo voltar e avançar entre as páginas visitadas.

public class Problema_3_Lista {
	private LinkedList<String> history;
	private ListIterator<String> iterator;

	public Problema_3_Lista() {
		history = new LinkedList<>();
		iterator = history.listIterator();
	}

	public void visitPage(String url) {
		iterator.add(url);
	}

	public String goBack() {
		if (iterator.hasPrevious()) {
			return iterator.previous();
		}
		return null;
	}

	public String goForward() {
		if (iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}

	public static void main(String[] args) {
		Problema_3_Lista browserHistory = new Problema_3_Lista();

		browserHistory.visitPage("www.google.com");
		browserHistory.visitPage("www.openai.com");

		System.out.println("Current page: " + browserHistory.goForward()); 
		System.out.println("Current page: " + browserHistory.goBack()); 
		
	}
}
