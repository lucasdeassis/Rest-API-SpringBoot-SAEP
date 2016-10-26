package ufg.inf.es.saep;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParecerController extends SaepController {

    // define a url a ser acessada pelo cliente e o metodo
    @RequestMapping(value = "/saep/parecer/{id}", method = RequestMethod.GET, headers = "Accept=text/html")
    public void obterParecerAsHtml(@PathVariable Long id, HttpServletResponse response) {
    	InputStream htmlStream = asls.parecerAsHtml(id);       
        response.setContentType("text/html");
        Utils.flushBuffer(htmlStream, response);

    }

    @RequestMapping(value = "/saep/parecer/{id}", method = RequestMethod.GET, headers = "Accept=application/pdf")
    public void obterParecerAsPdf(@PathVariable Long id, HttpServletResponse response) {
        InputStream pdfStream = asls.parecerAsPdf(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=\"parecer" + id + ".pdf\"");
        Utils.flushBuffer(pdfStream, response);
    }
    
    //TODO: aceitar o multipart/form-data tbm?
    @RequestMapping(value="/saep/parecer/{id}", method = RequestMethod.POST,
    		consumes= {"application/x-www-form-urlencoded","multipart/form-data" })
    public void criarParecer(@PathVariable Long id, InputStream parecer, HttpServletResponse response){
        boolean statusParecer = asls.criarParecer(id, parecer);
        if(statusParecer) response.setStatus(201);
        else response.setStatus(409);
    }
}
