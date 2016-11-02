package ufg.inf.es.saep;


import org.springframework.beans.factory.annotation.Autowired;

public abstract class SaepController {

	protected final ApplicationServiceLayerSaep asls;
	
	/**
	 * Injeção de Dependência realizada pelo Spring.
	 *
	 * @param asls Instância de serviço que é gerenciada pelo Spring. Por padrão esta instãncia é
	 * Singleton, isto é, criada apenas uma vez durante o programa e usada por RadocController
	 * e ParecerController.
	 */
	@Autowired
	public SaepController(ApplicationServiceLayerSaep asls) {
		this.asls = asls;
	}

}
