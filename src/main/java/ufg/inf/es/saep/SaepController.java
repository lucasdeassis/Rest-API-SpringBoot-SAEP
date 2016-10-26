package ufg.inf.es.saep;


import org.springframework.beans.factory.annotation.Autowired;

public abstract class SaepController {

    //qual ciclo de vida, qundo sao criados e destruidos?
    //THREADSAFE
    //QUANTAS threads DO PARECERCONTROLLER
	@Autowired
	protected ApplicationServiceLayerSaep asls;

}
