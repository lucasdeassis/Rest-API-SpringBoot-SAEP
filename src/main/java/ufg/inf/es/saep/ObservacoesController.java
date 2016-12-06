package ufg.inf.es.saep;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObservacoesController extends SaepController{

	public ObservacoesController(ApplicationServiceLayerSaep asls) {
		super(asls);
	}
	
	@RequestMapping(value="/saep/observacoes/{id}", method=RequestMethod.GET,
			produces="application/json")
	public void obterObservacoes(@PathVariable Long id, HttpServletResponse response) {
            response.setContentType("application/json");
            Utils.flushBuffer(asls.observacoesAsJson(id), response, asls.obterTamanhoObservacoes(id));
	}
}
