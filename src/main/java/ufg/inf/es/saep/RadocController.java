package ufg.inf.es.saep;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RadocController extends SaepController{

    @RequestMapping(value="/saep/radoc/{id}", method=RequestMethod.GET, headers="Accept=text/html")
    public void obterRadocAsHtml(@PathVariable Long id, HttpServletResponse response) {
    	InputStream htmlStream = asls.radocAsHtml(id);
    	response.setContentType("text/html");
    	Utils.flushBuffer(htmlStream, response);
    }
    
    
    @RequestMapping(value="/saep/radoc/{id}", method=RequestMethod.GET, headers="Accept=application/pdf")
    public void obterRadocAsPdf(@PathVariable Long id, HttpServletResponse response) {
    	InputStream pdfStream = asls.radocAsPdf(id);
    	response.setContentType("application/pdf");
    	response.setHeader("Content-Disposition", "inline; filename=\"radoc"+id+".pdf\"");
    	Utils.flushBuffer(pdfStream, response);
    }
    
    //TODO: aceitar o multipart/form-data tbm?
    @RequestMapping(value="/saep/radoc/{id}", method = RequestMethod.POST,
    		consumes= {"application/x-www-form-urlencoded","multipart/form-data" })
    public void criarRadoc(@PathVariable Long id, InputStream radoc, HttpServletResponse response){
        boolean statusRadoc = asls.criarRadoc(id, radoc);
        if(statusRadoc) response.setStatus(201);
        else response.setStatus(409);
    }
}


