package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;

public interface IControladorAluno {

	public void inserir(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido;

	public void atualizar(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido;

	public boolean remover(long id);

	public Aluno consultar(long id);
}
