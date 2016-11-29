package ufg.inf.es.saep;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class Utils {

    public static void flushBuffer(InputStream is, HttpServletResponse response, int numOfBytes) {
        if(numOfBytes > 0)
            response.setContentLength(numOfBytes);
        else{ // Documento não encontrado e portanto o tamanho é nulo.
            response.setStatus(404);
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, "input stream vazio");
        }
        

        try {
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
            response.setStatus(501);
        }
    }
    
    /**
     * método para simular um delay na resposta para o cliente e ver o ciclo de vida de asls
     * @param asls Implementação da camada de serviço de aplicação
     * @param tempo tempo de espera em segundos
     */
    public static void delayRequestReturn(ApplicationServiceLayerSaep asls, int tempo) {
    	Logger.getLogger(asls.getClass().getName()).log(Level.INFO,"ApplicationServiceLayerSaep instance " +asls.toString());
		try {
			Thread.sleep(tempo*1000);
		} catch (InterruptedException e) {
	    	Logger.getLogger(e.getClass().getName()).log(Level.SEVERE,e.getMessage());
		}
    }

}
