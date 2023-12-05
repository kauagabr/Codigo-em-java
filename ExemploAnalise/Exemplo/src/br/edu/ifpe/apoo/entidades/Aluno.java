package br.edu.ifpe.apoo.entidades;


public class Aluno{

	private Long id;
	private String nome;
	private String cpf;
	private String email;
	
	private Aluno(long id, String nome, String cpf, String email) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	private Aluno() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Object clone() {
		return new Aluno(id, nome, cpf, email);
	}
	
	
	public static class AlunoBuilder {
		Aluno aluno;
		
		
		public AlunoBuilder() {
            aluno = new Aluno();
        }

		
		public AlunoBuilder id(long i) {
			aluno.id = i;
			return this;
		}
		
		public AlunoBuilder Nome(String nome) {
			aluno.nome = nome;
			return this;
		}
		
		public AlunoBuilder Cpf(String cpf) {
			aluno.cpf = cpf;
			return this;
		}
		
		
		public AlunoBuilder Email(String email) {
			aluno.email = email;
			return this;
		}
		
		public Aluno construir() {
			return aluno;
		}
	}


}
