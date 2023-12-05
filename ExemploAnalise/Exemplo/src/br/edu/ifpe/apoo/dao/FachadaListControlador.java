package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;

public class FachadaListControlador implements IfachadaListControlador {
	private AlunoDAO alunoDAO;
	
	public FachadaListControlador() {
		alunoDAO = AlunoDAOAbstractFactory.getDAO();
	}
	
	@Override
	public void inserirAluno(Aluno aluno) {
		alunoDAO.inserir(aluno);
	}

	@Override
	public void atualizarAluno(Aluno aluno) {
		alunoDAO.atualizar(aluno);
		
	}

	@Override
	public Aluno consultarAluno(long id) {
		return alunoDAO.get(id);
		
	}

	@Override
	public boolean removerAluno(long id) {
		return alunoDAO.remover(id);
	}
	
	
}
