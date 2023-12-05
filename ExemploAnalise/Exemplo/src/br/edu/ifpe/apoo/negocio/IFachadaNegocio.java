package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;

public interface IFachadaNegocio {

	public void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido;
	
	public void atualizarAluno(Aluno aluno) throws ExcecaoCpfInvalido, ExcecaoAlunoInvalido;

	public Aluno consultarAluno(long id);

	public boolean removerAluno(long id);

	

}
