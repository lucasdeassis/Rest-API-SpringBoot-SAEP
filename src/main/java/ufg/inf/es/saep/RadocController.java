/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufg.inf.es.saep;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RadocController {

    @Autowired
    private ApplicationServiceLayerSaep asls;

    @RequestMapping(value="/radoc/saep/{id}", method=RequestMethod.GET)
    public String parecer(@PathVariable Long id, @RequestHeader(value="Accept") String accept, HttpServletResponse response) {
        
    	//TODO: como responder caso o header accept nao estiver incluso?
        if (accept.equals("text/html")){
        	response.setContentType("text/html");
        	return asls.getDocumentoHtml(id, "RADOC");
        }
        else if(accept.equals("application/pdf")){
        	// TODO: espera que o getDocumentoPdf de ApplicationServiceLayerSaep retorne uma stream
        	InputStream pdfStream = asls.getDocumentoPdf(id, "RADOC");
        	try {
            	response.setContentType("application/pdf");
				IOUtils.copy(pdfStream, response.getOutputStream());
	        	response.flushBuffer();
	        	return null;
			} catch (IOException e) {
				e.printStackTrace();
            	response.setContentType("text/html");
				return "Erro no Processamento do RADOC";	
			}
        }
        else{
        	response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        	return "Formato Inadequado";
        }

		
    }
}


