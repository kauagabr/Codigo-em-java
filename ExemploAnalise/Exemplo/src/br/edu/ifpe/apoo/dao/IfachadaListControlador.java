package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;

public interface IfachadaListControlador {

	public void inserirAluno(Aluno aluno);
	
	public void atualizarAluno(Aluno aluno);
	
	public Aluno consultarAluno(long id);
	
	public boolean removerAluno(long id);

}
