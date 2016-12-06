package ufg.inf.es.saep;

import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;


/* TODO: documentar esta interface, sobre restrições de implementação como o RequestScope e 
 * documentação de cada método.
 * 
 * TODO: Criar própria exceção e dizer quando será lançada
*/
/**
 * Interface da camada de serviço de aplicação da arquitetura do SAEP.
 * A implementação desta interface deve ter o escopo de requisição, isto é,
 * a cada requisição HTTP uma instância da implementação deve ser criada.
 * Para realizar essa configuração através do Spring-boot deve-se utilizar 
 * a anotação @RequestScope na implementação da interface.
 * 
 * Para que a injeção da implementação desta interface seja realizada, é preciso notificar
 * ao Spring-boot através da anotação @Service ou @Component que a classe implementada é um <code>bean</code>
 * a ser gerenciado.
 *
 */
@RequestScope
@Service
public interface ApplicationServiceLayerSaep {
	/**
	 * Retorna em html um parecer docente associado a um id.
	 * @param idDocumento id do parecer requisitado.
	 * @return o parecer em html representado em {@link java.io.InputStream}.
	 */
	public InputStream parecerAsHtml(Long idDocumento);

	/**
	 * Retorna um parecer docente associado a um id.
	 * @param idDocumento id do parecer requisitado.
	 * @return o parecer em pdf representado em {@link java.io.InputStream}.
	 */
	public InputStream parecerAsPdf(Long idDocumento);

	/**
	 * Retorna um Relatório de Atividades Docentes associado a um id
	 * @param idDocumento id do RADOC requisitado
	 * @return o RADOC em html representado em {@link java.io.InputStream}
	 */
	public InputStream radocAsHtml(Long idDocumento);

	/**
	 * Retorna um Relatório de Atividades Docentes associado a um id.
	 * @param idDocumento id do RADOC requisitado.
	 * @return o RADOC em pdf representado em {@link java.io.InputStream}.
	 */
	public InputStream radocAsPdf(Long idDocumento);

	/**
	 * Cria um parecer docente associado a um id com os dados passados.
	 * @param idDocumento id a ser associado com o parecer que será criado.
	 * @param parecer informações em {@link java.io.InputStream} que constituem o parecer docente.
	 * @return <code>true</code> se a criação do parecer ocorreu com sucesso no servidor ou 
	 * <code>false</code> se o parecer com o <code> idDocumento </code> já existe.
	 */
	public boolean criarParecer(Long idDocumento, InputStream parecer);

	public boolean criarRadoc(Long idDocumento, InputStream radoc);
	/**
	 * Retorna o tamanho de um parecer docente associado a um id.
	 * @param idDocumento id to parecer que se pretende obter o tamanho.
	 * @return quantidade de bytes que o parecer associado ao <code> idDocumento </code> possui.
	 */
	public int obterTamanhoParecer(Long idDocumento);
	
	public int obterTamanhoRadoc(Long idDocumento);

    public int obterTamanhoResolucao(Long idDocumento);
    
    /**
     * Exclui um parecer docente associado a um id.
     * @param idDocumento id que representa o parecer a ser removido.
     * @return <code>true</code> se a exclusão do parecer ocorreu com sucesso no servidor ou 
	 * <code>false</code> se não há um parecer associado ao <code> idDocumento </code> fornecido.
     */
    public boolean deletarParecer(Long idDocumento);
    
    public boolean deletarRadoc(Long idDocumento);
    
    public InputStream observacoesAsJson(Long idDocumento);
    
    public int obterTamanhoObservacoes(Long idParecer);
    
    public InputStream resolucaoAsHtml(Long idDocumento);
    
    public boolean criarResolucao(Long idResolucao, InputStream resolucao);
    
    public boolean deletarResolucao(Long idDocumento);

}
