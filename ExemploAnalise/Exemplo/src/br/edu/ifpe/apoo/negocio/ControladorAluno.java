package br.edu.ifpe.apoo.negocio;


import br.edu.ifpe.apoo.dao.FachadaNegocioFactory;
import br.edu.ifpe.apoo.dao.IfachadaListControlador;
import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;
import util.CPFValidatorAdapter;

public class ControladorAluno implements IControladorAluno {
	private final IfachadaListControlador Ifachada = FachadaNegocioFactory.getInstancia();
	private final CPFValidatorAdapter validator;
	
	public ControladorAluno() {
		
		this.validator = new CPFValidatorAdapter();
		
	}
	
	@Override
	public void inserir(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
		if (!this.isValidoNome(aluno)) {
			throw new ExcecaoAlunoInvalido("O nome do Aluno inválido");
		}
		
		if (!this.isValidoCpf(aluno)) {
			throw new ExcecaoAlunoInvalido("O CPF do Aluno inválido");
		}
		
		Ifachada.inserirAluno(aluno);
	}
	
	@Override
	public void atualizar(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
		if (!isValidoNome(aluno)) {
			throw new ExcecaoAlunoInvalido("O nome do Aluno inválido");
		}
		
		if (!this.isValidoCpf(aluno)) {
			throw new ExcecaoAlunoInvalido("O CPF do Aluno inválido");
		}
		
		 
		Ifachada.atualizarAluno(aluno);
	}
	
	@Override
	public boolean remover(long id) {
		return Ifachada.removerAluno(id);
	}
	
	@Override
	public Aluno consultar(long id) {
		return Ifachada.consultarAluno(id);
	}
	int tamanhomin_nome = 5;
	int tamanhomax_nome = 100;
	private boolean isValidoNome(Aluno aluno) {
		if (aluno.getNome() == null || aluno.getNome().length() < tamanhomin_nome || aluno.getNome().length() > tamanhomax_nome) {
			return false;
		}
		return true;
	}
	
	private boolean isValidoCpf(Aluno aluno) throws ExcecaoCpfInvalido {
		try {
			return validator.validarCPF(aluno.getCpf());
		} catch (ExcecaoCpfInvalido e) {
            throw new ExcecaoCpfInvalido("Erro na validacao do CPF: " + e.getMessage());
		}
	}
}
