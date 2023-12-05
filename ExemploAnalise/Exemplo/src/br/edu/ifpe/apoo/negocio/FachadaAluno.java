package br.edu.ifpe.apoo.negocio;

import br.edu.ifpe.apoo.entidades.Aluno;
import br.edu.ifpe.apoo.excecoes.ExcecaoAlunoInvalido;
import br.edu.ifpe.apoo.excecoes.ExcecaoCpfInvalido;

public class FachadaAluno implements IFachadaNegocio {
	private IControladorAluno controladorAluno;

    public FachadaAluno() {
        controladorAluno = new ControladorAluno();
    }
    
    @Override
    public void inserirAluno(Aluno aluno) throws ExcecaoAlunoInvalido, ExcecaoCpfInvalido {
        controladorAluno.inserir(aluno);
    }

    @Override
    public Aluno consultarAluno(long id) {
        return controladorAluno.consultar(id);
    }

    @Override
    public boolean removerAluno(long id) {
        return controladorAluno.remover(id);
    }

    @Override
    public void atualizarAluno(Aluno aluno) throws ExcecaoCpfInvalido, ExcecaoAlunoInvalido {
        controladorAluno.atualizar(aluno);
    }
}
