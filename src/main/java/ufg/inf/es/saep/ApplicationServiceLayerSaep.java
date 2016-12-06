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
 * Interface da camada de serviço de aplicação da arquitetura do SAEP. A
 * implementação desta interface deve ter o escopo de requisição, isto é, a cada
 * requisição HTTP uma instância da implementação deve ser criada. Para realizar
 * essa configuração através do Spring-boot deve-se utilizar a anotação
 *
 * @RequestScope na implementação da interface.
 *
 * Para que a injeção da implementação desta interface seja realizada, é preciso
 * notificar ao Spring-boot através da anotação @Service ou @Component que a
 * classe implementada é um <code>bean</code> a ser gerenciado.
 *
 */
@RequestScope
@Service
public interface ApplicationServiceLayerSaep {

    /**
     * Retorna em html um parecer docente associado a um identificador.
     *
     * @param idDocumento id do parecer requisitado.
     * @return o parecer em html representado em {@link java.io.InputStream}.
     */
    public InputStream parecerAsHtml(Long idDocumento);

    /**
     * Retorna um parecer docente associado a um identificador.
     *
     * @param idDocumento id do parecer requisitado.
     * @return o parecer em pdf representado em {@link java.io.InputStream}.
     */
    public InputStream parecerAsPdf(Long idDocumento);

    /**
     * Retorna um Relatório de Atividades Docentes associado a um id
     *
     * @param idDocumento id do RADOC requisitado
     * @return o RADOC em html representado em {@link java.io.InputStream}
     */
    public InputStream radocAsHtml(Long idDocumento);

    /**
     * Retorna um Relatório de Atividades Docentes associado a um identificador.
     *
     * @param idDocumento id do RADOC requisitado.
     * @return o RADOC em pdf representado em {@link java.io.InputStream}.
     */
    public InputStream radocAsPdf(Long idDocumento);

    /**
     * Retorna a resolução com o identificador fornecido.
     *
     * @param idDocumento id da resolução requisitada.
     * @return a resolução em html representado em {@link java.io.InputStream}.
     */
    public InputStream resolucaoAsHtml(Long idDocumento);

    /**
     * Retorna as Observações de um parecer associado a um identificador.
     *
     * @param idDocumento id do parecer requisitado.
     * @return as observações do parecer em Json representado em
     * {@link java.io.InputStream}.
     */
    public InputStream observacoesAsJson(Long idDocumento);

    /**
     * Cria um parecer docente associado a um id com os dados passados.
     *
     * @param idDocumento id a ser associado com o parecer que será criado.
     * @param parecer informações em {@link java.io.InputStream} que constituem
     * o parecer docente.
     * @return <code>true</code> se a criação do parecer ocorreu com sucesso no
     * servidor ou <code>false</code> se o parecer com o <code> idDocumento
     * </code> já existe.
     */
    public boolean criarParecer(Long idDocumento, InputStream parecer);

    /**
     * Cria um radoc docente associado a um id com os dados passados.
     *
     * @param idDocumento id a ser associado com o parecer que será criado.
     * @param radoc informações em {@link java.io.InputStream} que constituem o
     * radoc.
     * @return <code>true</code> se a criação do radoc ocorreu com sucesso no
     * servidor ou <code>false</code> se o radoc com o <code> idDocumento
     * </code> já existe.
     */
    public boolean criarRadoc(Long idDocumento, InputStream radoc);

    /**
     * Cria uma resolução associada a um id com os dados passados.
     *
     * @param idResolucao id a ser associado com a resolução que será criada.
     * @param resolucao informações em {@link java.io.InputStream} que
     * constituem a resolução.
     * @return <code>true</code> se a criação da resolução ocorreu com sucesso
     * no servidor ou <code>false</code> se a resolução com o <code> idDocumento
     * </code> já existe.
     */
    public boolean criarResolucao(Long idResolucao, InputStream resolucao);

    /**
     * Retorna o tamanho de um parecer docente associado a um identificador.
     *
     * @param idDocumento id do parecer que se pretende obter o tamanho.
     * @return quantidade de bytes que o parecer associado ao <code> idDocumento
     * </code> possui.
     */
    public int obterTamanhoParecer(Long idDocumento);

    /**
     * Retorna o tamanho de um radoc associado a um identificador.
     *
     * @param idDocumento id do radoc que se pretende obter o tamanho.
     * @return quantidade de bytes que o parecer associado ao <code> idDocumento
     * </code> possui.
     */
    public int obterTamanhoRadoc(Long idDocumento);

    /**
     * Retorna o tamanho de uma resolução associada a um identificador.
     *
     * @param idDocumento id da resolução que se pretende obter o tamanho.
     * @return quantidade de bytes que a resolução associada ao <code> idDocumento
     * </code> possui.
     */
    public int obterTamanhoResolucao(Long idDocumento);

    /**
     * Retorna o tamanho das observações associada a um parecer.
     *
     * @param idParecer id do parecer que se pretende obter o tamanho das
     * observações.
     * @return quantidade de bytes das observações associadas ao <code> idParecer
     * </code> possui.
     */
    public int obterTamanhoObservacoes(Long idParecer);
    
    /**
     * Retorna o tamanho da lista de identificadores de resoluções gerenciadas pelo SAEP.
     *
     * @return quantidade de bytes da lista de identificadores de resoluções.
     */
    public int obterTamanhoListaResolucoes();

    /**
     * Exclui o parecer docente associado ao identificador fornecido.
     *
     * @param idDocumento id que representa o parecer a ser removido.
     * @return <code>true</code> se a exclusão do parecer ocorreu com sucesso no
     * servidor ou <code>false</code> se não há um parecer associado ao <code> idDocumento
     * </code> fornecido.
     */
    public boolean deletarParecer(Long idDocumento);
    
    /**
     * Exclui o radoc associado ao identificador fornecido.
     *
     * @param idDocumento id que representa o radoc a ser removido.
     * @return <code>true</code> se a exclusão do radoc ocorreu com sucesso no
     * servidor ou <code>false</code> se não há um radoc associado ao <code> idDocumento
     * </code> fornecido.
     */
    public boolean deletarRadoc(Long idDocumento);

    /**
     * Exclui a resolução associada ao identificador fornecido.
     *
     * @param idDocumento id que representa a resolução a ser removida.
     * @return <code>true</code> se a exclusão da resolução ocorreu com sucesso
     * no servidor ou <code>false</code> se não há uma resolução associada ao <code> idDocumento
     * </code> fornecido.
     */
    public boolean deletarResolucao(Long idDocumento);

    /**
     * Recupera lista de identificadores das resoluções disponíveis gerenciadas pela SAEP.
     * 
     * @return {@link java.io.InputStream} contendo um Json com a lista de idenficadores das resoluções.
     */
    public InputStream listaResolucoes();
    
    
}
