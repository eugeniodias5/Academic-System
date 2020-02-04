package service;

import java.util.ArrayList;

import java.util.List;

import domain.Aluno;
import domain.Coordenador;
import domain.Curso;
import domain.Disciplina;
import domain.Universidade;
import enums.Contrato;
import enums.Nivel;
import repository.LeitorTxtRepository;

public class UniversidadeService {
	// Pegar uma disciplina pelo código
	public static Disciplina getDisciplina(Universidade universidade, String codigoDisciplina) {
		
		List<Disciplina> disciplinas = universidade.getDisciplinas();
		for (int index = 0; index < universidade.getCursos().size(); index++) {
			if (disciplinas.get(index).equals(codigoDisciplina))
				return disciplinas.get(index);
		}
		return null;
	}

	// Pegar um curso pelo código
	public static Curso getCurso(Universidade universidade, String codigoCurso) {

		List<Curso> cursos = universidade.getCursos();		
		for (int index = 0; index < cursos.size(); index++) {
			if (cursos.get(index).equals(codigoCurso))
				return cursos.get(index);
		}
		return null;
	}
	
	//Retorna um coordenador pela matrícula
	public static Coordenador getCoordenador(Universidade universidade, String matricula) {
		Coordenador coordenador = null;
		for (int index = 0; index < universidade.getCoordenadores().size(); index++) {
			coordenador = universidade.getCoordenadores().get(index);
			if(coordenador.getMatricula().equals(matricula))
				return coordenador;
		}
		
		return null;
	}
	
	//Retorna um coordenador pelo curso
		public static Coordenador getCoordenador(Universidade universidade, Curso curso) {
			Coordenador coordenador = null;
			for (int index = 0; index < universidade.getCoordenadores().size(); index++) {
				coordenador = universidade.getCoordenadores().get(index);
				if(coordenador.getCurso().equals(curso))
					return coordenador;
			}
			
			return null;
		}
	
	//Método que retorna alunos de um curso inscritos na universidade.
	//Utilizado para adicionar coordenadores
	public static List<Aluno> getAlunosCurso(Universidade universidade, Curso curso){
		List<Aluno> alunosCurso = new ArrayList<Aluno>();
		
		List<Aluno> alunosUniversidade = universidade.getAlunos();
		
		for (int index = 0; index < alunosUniversidade.size(); index++) {
			Aluno aux = alunosUniversidade.get(index);
			
			if (aux.getCurso().equals(curso)) {
				Aluno aluno = new Aluno(aux.getNome(), aux.getMatricula(), aux.getSenha(), 
						aux.getRg(), aux.getCpf(), curso);
				alunosCurso.add(aluno);
			}
		}
		return alunosCurso;
	}

//Inicializa a universidade no Main
public static void inicializaUniversidade(Universidade universidade) {
	// Lendo txt da universidade
	LeitorTxtRepository.leitor(universidade);
	
}

}
