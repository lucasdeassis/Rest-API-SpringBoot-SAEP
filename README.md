# Rest-API-SpringBoot-SAEP
Implementação da REST API usando SpringBoot. Inclui verificação de segurança usando ZAP.


## Executando

Para dar build no projeto, rode o comando:

 ```sh 
 	mvn package
 ```
Para executar: 

```sh 
 	java -jar target/gs-rest-service-0.1.0.jar
 ```

## Referência
 
 Os recursos implementados foram: 

* parecer em `saep/parecer/{id}`

* radoc em `saep/radoc/{id}`

* status em `saep/status`

* resoluções em `saep/resolucao/{id}`

* lista de identificadores das resoluções em `saep/resolucoes`

* observações em `saep/observacoes/{id}`


Atuais recursos e os demais serão implementados de acordo com a API do SAEP a ser atualizada [aqui](http://docs.saep.apiary.io/#)
