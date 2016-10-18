package ufg.inf.es.saep;

import java.io.InputStream;

public interface ApplicationServiceLayerSaep {
	public InputStream parecerAsHtml(Long idDocumento);
	
	public InputStream parecerAsPdf(Long idDocumento);
	
	public InputStream radocAsHtml(Long idDocumento);
	
	public InputStream radocAsPdf(Long idDocumento);
}
