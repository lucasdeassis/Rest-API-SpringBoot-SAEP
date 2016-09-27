package ufg.inf.es.saep;

import java.io.InputStream;

public interface ApplicationServiceLayerSaep {
	// os metodos da interface sao similares a esses?
	public String getDocumentoHtml(Long idDocumento, String tipoDoDocumento);
	
	// qual o tipo de dado esperado para o retorno de um pdf
	public InputStream getDocumentoPdf(Long idDocumento, String tipoDoDocumento);
	
}
