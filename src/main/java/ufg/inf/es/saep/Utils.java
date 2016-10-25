package ufg.inf.es.saep;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class Utils {

    public static void flushBuffer(InputStream is, HttpServletResponse response) {
        int numOfBytes;
        try {
            //TODO: implementar" um metodo que ja pega o tamanho na interface
            numOfBytes = is.available();
            response.setContentLength(numOfBytes);
        } catch (IOException ex) {
            response.setStatus(404);
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        try {
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            //TODO: LOG error
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, e);
            //TODO: status é 501?
            response.setStatus(501);
        }
    }

}
