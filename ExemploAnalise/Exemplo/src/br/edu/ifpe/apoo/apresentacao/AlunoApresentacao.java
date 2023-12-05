package br.edu.ifpe.apoo.apresentacao;

import java.util.Scanner;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;
import br.edu.ifpe.apoo.negocio.FachadaNegocioFactory;
import br.edu.ifpe.apoo.negocio.IFachadaNegocio;



public class AlunoApresentacao {

	Scanner scanner = new Scanner(System.in);
	long cont = 0;
	IFachadaNegocio fachada = FachadaNegocioFactory.getInstancia();

	public void exibirMenu() throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
		while (true) {		
			System.out.println("Digite a opção desejada");
			System.out.println("1 para inserir um aluno;");
			System.out.println("2 para consultar um aluno;");
			System.out.println("3 para remover um aluno;");
			System.out.println("4 para alterar um aluno;");
			System.out.println("0 para encerrar o programa;");

			int opcao = Integer.parseInt(scanner.nextLine());
			if (opcao == 1) {
				cont++;
				this.inserir(cont);
				this.exibirMenu();
			}
			else if (opcao == 2) {
				this.consultar();
				this.exibirMenu();
			}
			else if (opcao == 3) {
				this.remove();
				this.exibirMenu();
			}
			else if (opcao == 4) {
				this.atualizar();
				this.exibirMenu();
			}
			else if (opcao == 0) {
				System.out.println("Programa finalizado com sucesso");
				break;
			}else {
				System.out.println("Opção invalida, digite novamente");	
			}
		}
	}
	private void inserir(long cont) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
		try {
			System.out.println("Digite o nome do aluno:");
			String nome = scanner.nextLine();

			System.out.println("Digite o e-mail do aluno:");
			String email = scanner.nextLine();


			System.out.println("Digite o CPF do aluno:");
			String cpf = scanner.nextLine();


			Aluno aluno = new Aluno.AlunoBuilder()
					.id(cont)
					.Nome(nome)
					.Email(email)
					.Cpf(cpf)
					.construir();


			fachada.inserirAluno(aluno);
			System.out.println("Aluno Inserido com sucesso");
		} catch (ExcecaoAlunoInvalido e) {
			System.out.println("Erro ao inserir aluno: " + e.getMessage());
		}
	}

	private void consultar() {
		System.out.println("Digite o ID do aluno que deseja consultar:");
		long idConsulta = Long.parseLong(scanner.nextLine());

		Aluno alunoConsultado = fachada.consultarAluno(idConsulta);
		
		if (alunoConsultado != null) {
			System.out.println("Aluno encontrado:");
			System.out.println("ID: " + alunoConsultado.getId());
			System.out.println("Nome: " + alunoConsultado.getNome());
			System.out.println("CPF: " + alunoConsultado.getCpf());
			System.out.println("E-mail: " + alunoConsultado.getEmail());
		} else {
			System.out.println("Aluno não encontrado.");
		}
	}

	private void remove() {
		System.out.println("Digite o ID do aluno que deseja remover:");
		long idRemocao = Long.parseLong(scanner.nextLine());

		boolean alunoRemovido = fachada.removerAluno(idRemocao);

		if (alunoRemovido) {
			System.out.println("Aluno removido com sucesso!");
		} else {
			System.out.println("Aluno não encontrado ou não foi possível remover.");
		}
	}

	private void atualizar() throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
		
		System.out.println("Digite o ID do aluno que deseja alterar:");
		long idAlteracao = Long.parseLong(scanner.nextLine());

		Aluno alunoParaAlterar = fachada.consultarAluno(idAlteracao);
		
		
		if (alunoParaAlterar != null) {

			System.out.println("--------------------------------");
			System.out.println("Aluno encontrado. Qual dado deseja alterar:");

			System.out.println("1 - Alterar o nome do aluno");
			System.out.println("2 - Alterar o cpf do aluno");
			System.out.println("3 - Alterar o email do aluno");
			int opcao1 = Integer.parseInt(scanner.nextLine());

			switch (opcao1) {

			case 1:
				System.out.print("Novo nome: ");
				String novoNome = scanner.nextLine();
				alunoParaAlterar.setNome(novoNome);
				break;
			case 2:
				System.out.print("Novo CPF: ");
				String novoCpf = scanner.nextLine();
				alunoParaAlterar.setCpf(novoCpf);
				break;
			case 3:
				System.out.print("Novo e-mail: ");
				String novoEmail = scanner.nextLine();
				alunoParaAlterar.setEmail(novoEmail);
				break;

			default:
				System.out.println("Opção invalida");
			}

		}
		fachada.atualizarAluno(alunoParaAlterar);
		System.out.println("Aluno atualizado com sucesso!");

	}


}
