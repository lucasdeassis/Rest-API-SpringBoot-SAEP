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
public class ParecerController {
	//private static final long STATUS_OK = 200;
    //private static final String template = "Parecer %s!";
    
    //interface responsavel apenas pelo parecer?
    @Autowired
    private ApplicationServiceLayerSaep asls;

    // obter pelo header (header eh o accept - application/pdf e text/html) o formato do parecer (pdf ou html)


    // define a url a ser acessada pelo cliente e o metodo
    @RequestMapping(value="/parecer/saep/{id}", method=RequestMethod.GET)
    public String parecer(@PathVariable Long id, @RequestHeader(value="Accept") String accept, HttpServletResponse response) {
        
    	//TODO: como responder caso o header accept nao estiver incluso?
        if (accept.equals("text/html")){
        	response.setContentType("text/html");
        	return asls.getDocumentoHtml(id, "parecer");
        }
        else if(accept.equals("application/pdf")){
        	// espera que o getParecerPdf de ApplicationServiceLayerSaep retorne uma stream
        	InputStream pdfStream = asls.getDocumentoPdf(id, "parecer");
        	try {
            	response.setContentType("application/pdf");
				IOUtils.copy(pdfStream, response.getOutputStream());
	        	response.flushBuffer();
	        	return null;
			} catch (IOException e) {
				e.printStackTrace();
            	response.setContentType("text/html");
				return "Erro no Processamento do Parecer";	
			}
        }
        else{
        	response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        	return "Formato Inadequado";
        }
        /*

		Primeiro detectar precisamente a requisição.
		Falta aqui saber qual o formato requisitado pelo cliente: PDF (postman para testar) ou HTML. 

		Depois, após a injeção de dependência de serviço qe de fato impelemnta
		a funcionalidade, voce faz a requisicao correspondente. 

		procurar por spring boot inject dependencies ou spring boot dependency injection
		ApplicationServiceLayerSaep (interface) asls;

        aqui obtemos do servidor o recurso de parecer pelo id passado e repassamos a resposta em JSON via HTTP
        return new Parecer(STATUS_OK,
                            String.format(template, id));
    	*/

		
    }
}