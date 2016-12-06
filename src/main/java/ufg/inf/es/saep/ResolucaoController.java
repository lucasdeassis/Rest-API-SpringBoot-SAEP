package ufg.inf.es.saep;

import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResolucaoController extends SaepController{
    
    public ResolucaoController(ApplicationServiceLayerSaep asls){
        super(asls);
    }

    
   
    @RequestMapping(value="/saep/resolucao/{id}", method=RequestMethod.GET, produces="text/html")
    public void obterResolucao(@PathVariable Long id, HttpServletResponse response) {
    	InputStream htmlStream = asls.resolucaoAsHtml(id);
    	response.setContentType("text/html");
    	Utils.flushBuffer(htmlStream, response, asls.obterTamanhoResolucao(id));
    }  
    
    //TODO: aceitar o multipart/form-data tbm?
    @RequestMapping(value="/saep/resolucao/{id}", method = RequestMethod.POST,
    		consumes= {"application/x-www-form-urlencoded","multipart/form-data" })
    public void criarResolucao(@PathVariable Long id, InputStream resolucao, HttpServletResponse response){
        boolean statusRadoc = asls.criarResolucao(id, resolucao);
        if(statusRadoc) response.setStatus(201);
        else response.setStatus(409);
    }
    
    @RequestMapping(value="/saep/resolucao/{id}", method=RequestMethod.DELETE)
    public void deletarResolucao(@PathVariable Long id, HttpServletResponse response) {
    	boolean statusDeletado = asls.deletarResolucao(id);
        if(statusDeletado) response.setStatus(200);
        else response.setStatus(404);
    }
    
    @RequestMapping(value="/saep/resolucoes", method=RequestMethod.GET,
			produces="application/json")
	public void obterListaResolucoes(HttpServletResponse response) {
                response.setContentType("application/json");
		Utils.flushBuffer(asls.listaResolucoes(), response, asls.obterTamanhoListaResolucoes());
	}
}