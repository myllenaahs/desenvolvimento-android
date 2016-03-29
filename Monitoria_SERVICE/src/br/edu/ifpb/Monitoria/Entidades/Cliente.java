package br.edu.ifpb.Monitoria.Entidades;

public class Cliente {

	String login;
	String senha;
	String nome;
	String matricula;
	String horario;
	String disciplina;

	public Cliente(){
		this.login="";
		this.senha="";
		this.nome="";
		this.matricula="";
		this.horario="";
		this.disciplina="";
		}

	public Cliente(String login, String senha,String nome, String matricula, String disciplina, String horario) {
		this.nome=nome;
		this.login = login;
		this.senha = senha;
		this.matricula=matricula;
		this.disciplina=disciplina;
		this.horario=horario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}