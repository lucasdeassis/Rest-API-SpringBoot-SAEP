package ufg.inf.es.saep;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class Utils {
	public static void flushBuffer(InputStream is, HttpServletResponse response) {
       	try {
			IOUtils.copy(is, response.getOutputStream());
        	response.flushBuffer();
		} catch (IOException e) {
			//TODO: LOG error
			e.printStackTrace();
        	//TODO: status é 501?
        	response.setStatus(501);
		}
	}
}
