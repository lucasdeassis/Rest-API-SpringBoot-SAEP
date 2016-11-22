package ufg.inf.es.saep;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Para cada requisição HTTP, uma nova thread será lançada para respondê-la.
 * 
 * @RestController adiciona classe como @Controller e como @ResponseBody,
 * indicando que será um bean e o retorno de seus métodos será anexado ao ResponseBody
 * da resposta http.
 */
@RestController
public class ParecerController extends SaepController {

    public ParecerController(ApplicationServiceLayerSaep asls) {
		super(asls);
	}

	// define a url a ser acessada pelo cliente e o metodo
    @RequestMapping(value = "/saep/parecer/{id}", method = RequestMethod.GET, produces = "text/html")
    public void obterParecerAsHtml(@PathVariable Long id, HttpServletResponse response) {
    	InputStream htmlStream = asls.parecerAsHtml(id);       
        response.setContentType("text/html");
        Utils.flushBuffer(htmlStream, response, asls.obterTamanhoParecer(id));

    }

    @RequestMapping(value = "/saep/parecer/{id}", method = RequestMethod.GET, produces = "application/pdf")
    public void obterParecerAsPdf(@PathVariable Long id, HttpServletResponse response) {
        InputStream pdfStream = asls.parecerAsPdf(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=\"parecer" + id + ".pdf\"");
        Utils.flushBuffer(pdfStream, response, asls.obterTamanhoParecer(id));
    }
    
    //TODO: aceitar o multipart/form-data tbm?
    @RequestMapping(value="/saep/parecer/{id}", method = RequestMethod.POST,
    		consumes= {"application/x-www-form-urlencoded","multipart/form-data" })
    public void criarParecer(@PathVariable Long id, InputStream parecer, HttpServletResponse response){
        boolean statusParecer = asls.criarParecer(id, parecer);
        if(statusParecer) response.setStatus(201);
        else response.setStatus(409);
    }
    
    @RequestMapping(value="/saep/parecer/{id}", method=RequestMethod.DELETE)
    public void deletarParecer(@PathVariable Long id, HttpServletResponse response) {
    	boolean statusDeletado = asls.deletarRadoc(id);
        if(statusDeletado) response.setStatus(200);
        else response.setStatus(404);
    }
}
