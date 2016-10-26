package ufg.inf.es.saep;

import java.io.InputStream;
import org.springframework.stereotype.Component;

public interface ApplicationServiceLayerSaep {
	public InputStream parecerAsHtml(Long idDocumento);

	public InputStream parecerAsPdf(Long idDocumento);

	public InputStream radocAsHtml(Long idDocumento);

	public InputStream radocAsPdf(Long idDocumento);

	// futuro criarPontuaçao
	public boolean criarParecer(Long idDocumento, InputStream parecer);

	public boolean criarRadoc(Long idDocumento, InputStream radoc);
}
