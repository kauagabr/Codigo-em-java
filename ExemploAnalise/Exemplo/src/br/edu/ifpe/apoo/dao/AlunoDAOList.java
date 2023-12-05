package br.edu.ifpe.apoo.dao;

import br.edu.ifpe.apoo.entidades.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOList implements AlunoDAO {
	private List<Aluno> alunos;
    private static AlunoDAOList instancia;

    private AlunoDAOList() {
        alunos = new ArrayList<>();
    }

    public static AlunoDAOList getInstancia() {
        if (instancia == null) {
            instancia = new AlunoDAOList();
        }
        return instancia;
    }

    @Override
    public void inserir(Aluno aluno) {
            alunos.add(aluno);
    }

    @Override
    public void atualizar(Aluno aluno) {
      
            int index = obterIndice(aluno.getId());
            if (index != -1) {
                alunos.set(index, aluno);
            } else {
                throw new IllegalArgumentException("Aluno não encontrado.");
            }
        } 
    

    @Override
    public boolean remover(long id) {
  
            int index = obterIndice(id);
            if (index != -1) {
                alunos.remove(index);
                return true;
            } else {
                throw new IllegalArgumentException("Aluno não encontrado.");
            }
    }

    @Override
    public Aluno get(long id) {
    
            int index = obterIndice(id);
            if (index != -1) {
            	Aluno prototipo = alunos.get(index);
            	
            	Aluno alunoclone = (Aluno) prototipo.clone();
            	
                return alunoclone;
                
            } else {
                throw new IllegalArgumentException("Aluno não encontrado.");
            }
    }


    private int obterIndice(long id) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}