package ufg.inf.es.saep;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParecerController {

    //TODO: xxxxinterface responsavel apenas pelo parecer?
    @Autowired
    private ApplicationServiceLayerSaep asls;
    
    // define a url a ser acessada pelo cliente e o metodo
    @RequestMapping(value="/parecer/saep/{id}", method=RequestMethod.GET, headers="Accept=text/html")
    public void obterParecerAsHtml(@PathVariable Long id, HttpServletResponse response) {
    	
    	InputStream htmlStream = asls.parecerAsHtml(id);
       	response.setContentType("text/html");
    	Utils.flushBuffer(htmlStream, response);

        // TODO: qual seria a resposta após o POST de parecer? como iremos receber o parecer pela requisição ?
        
    }
    
    @RequestMapping(value="/parecer/saep/{id}", method=RequestMethod.GET, headers="Accept=application/pdf")
    public void obterParecerAsPdf(@PathVariable Long id, HttpServletResponse response) {
        	// TODO: espera que o getDocumentoPdf de ApplicationServiceLayerSaep retorne uma stream
        	InputStream pdfStream = asls.parecerAsPdf(id);
           	response.setContentType("application/pdf");
        	response.setHeader("Content-Disposition", "inline; filename=\"parecer"+id+".pdf\"");
           	Utils.flushBuffer(pdfStream, response);
    }
}
      
