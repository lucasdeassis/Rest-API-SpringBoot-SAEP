package ufg.inf.es.saep;


import org.springframework.beans.factory.annotation.Autowired;

public abstract class SaepController {

	/**
	 * Interface de serviço declarada como final, para ser atribuida apenas uma vez,
	 *  de modo que representa o bean como sendo livre de estado para o Spring.
	 */
	protected final ApplicationServiceLayerSaep asls;
	
	/**
	 * Injeção de Dependência de asls realizada pelo Spring.
	 *
	 * @param asls Instância de serviço que é gerenciada pelo Spring. Por padrão esta instancia é
	 * Singleton, isto é, criada apenas uma vez durante o programa e usada por RadocController
	 * e ParecerController.
	 */
	@Autowired
	public SaepController(ApplicationServiceLayerSaep asls) {
		this.asls = asls;
	}

}
