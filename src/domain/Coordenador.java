package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import enums.Conceito;
import enums.Contrato;
import enums.Nivel;

public class Coordenador extends Professor {

	private Curso curso;
	private List<Aluno> alunos;	//Lista de alunos do curso inscritos na universidade

	public Coordenador(String nome, String matricula, String senha, String rg, String cpf, Contrato contrato,
			Nivel nivel, List<Aluno> alunos, Curso curso) {

		super(nome, matricula, senha, rg, cpf, contrato, nivel);
		
		this.alunos = alunos;
		
		this.curso = curso;
	}
	
	//Verifica se o aluno já existe
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
			
	public Curso getCurso() {
		return curso;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


}