package ufg.inf.es.saep;

import java.io.InputStream;

public interface ApplicationServiceLayerSaepRadoc {
	//TODO: juntar os metodos de hmtl e pdf em um só?
	public InputStream radocAsHtml(Long idDocumento);
	
	public InputStream radocAsPdf(Long idDocumento);
	


}
