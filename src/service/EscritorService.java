package service;

import domain.Curso;
import domain.Historico;
import repository.EscreveHtmlRepository;

public abstract class EscritorService {
	public abstract String escreveHistorico(Historico historico);
	public abstract String escreveCurriculo(Curso curso);
	
	
	//Métodos para salvar histórico e currículo. Deve ser sobreescrito em EscritorTxtService
	public void salvarHistorico(String nomeHtml, String historico) {
		EscreveHtmlRepository.salvarHistoricoHtml(nomeHtml, historico);
	}
	
	public void salvarCurriculo(String nomeHtml, String curriculo) {
		EscreveHtmlRepository.salvarCurriculoHtml(nomeHtml, curriculo);
	}

}
