package ufg.inf.es.saep;

import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public abstract class SaepController {

	/**
	 * Interface de serviço declarada como final, para ser atribuida apenas uma vez,
	 *  de modo que representa o bean como sendo livre de estado para o Spring.
	 */
	protected final ApplicationServiceLayerSaep asls;
	
	/**
	 * Injeção de Dependência de asls realizada pelo Spring.
	 *
	 * @param asls Instância de serviço que é gerenciada pelo Spring. esta instância é RequestScoped,
	 * sendo criada sempre que uma nova requisição HTTP for disparada e respondida.
	 */
	public SaepController(ApplicationServiceLayerSaep asls) {
		this.asls = asls;
	}

}
