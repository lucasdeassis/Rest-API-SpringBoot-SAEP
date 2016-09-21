package ufg.inf.es.saep;

import java.io.InputStream;

public interface ApplicationServiceLayerSaep {
	// os metodos da interface sao similares a esses?
	public String getParecerHtml(Long idParecer);
	
	// qual o tipo de dado esperado para o retorno de um pdf
	public InputStream getParecerPdf(Long idParecer);
	
}
