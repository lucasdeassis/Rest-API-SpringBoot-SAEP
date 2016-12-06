# Rest-API-SpringBoot-SAEP
Implementação da REST API usando SpringBoot. Inclui verificação de segurança usando ZAP.


## Executando

O Maven Wrapper e utilizado para executar. Para iniciar o servidor em `localhost:8080`, rode o comando:

 ```sh 
 	./mvnw spring-boot:run
 ```

 Para criar um jar use: ```sh ./mvnw clean package```. Para dar `clean` no projeto rode ```sh ./mvnw clean```.

## Referência
 
 Os recursos implementados foram: 

* parecer em `saep/parecer/{id}`

* radoc em `saep/radoc/{id}`

* status em `saep/status`

* resoluções em `saep/resolucao/{id}`

* lista de identificadores das resoluções em `saep/resolucoes`

* observações em `saep/observacoes/{id}`


Atuais recursos e os demais serão implementados de acordo com a API do SAEP a ser atualizada [aqui](http://docs.saep.apiary.io/#)
