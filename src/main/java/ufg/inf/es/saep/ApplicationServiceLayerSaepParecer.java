package ufg.inf.es.saep;

import java.io.InputStream;

public interface ApplicationServiceLayerSaepParecer {
	//TODO: juntar os metodos de hmtl e pdf em um só?
	public InputStream parecerAsHtml(Long idDocumento);
	
	public InputStream parecerAsPdf(Long idDocumento);
	
}
