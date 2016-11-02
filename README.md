# Rest-API-SpringBoot-SAEP
Implementação da REST API usando SpringBoot. Inclui verificação de segurança usando ZAP.


## Executando

O Maven Wrapper e utilizado para executar. Para iniciar o servidor em `localhost:8080`, rode o comando:

 ```sh 
 	./mvnw spring-boot:run
 ```

 Para criar um jar use: ```sh ./mvnw clean package```. Para dar `clean` no projeto rode ```sh ./mvnw clean```.

## Referência

 O recurso de `parecer` está disponível em `saep/parecer/{id}`. 
 
 Outros recursos implementados foram: 

*  radoc em `saep/radoc/{id}`

* status em `saep/status`
 	
Atuais recursos e os demais serão implementados de acordo com a API do SAEP a ser atualizada [aqui](http://docs.saep.apiary.io/#)
