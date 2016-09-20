# Rest-API-SpringBoot-SAEP
Implementação da REST API usando SpringBoot. Inclui verificação de segurança usando ZAP.


## Executando

O Maven Wrapper e utilizado para executar. Para iniciar o servidor em `localhost:8080`, rode o comando:

 ```sh 
 	./mvnw spring-boot:run
 ```

 Para criar um jar use: ```sh ./mvnw clean package```. Para dar `clean` no projeto rode ```sh ./mvnw clean```.

 O recurso de demonstração é o `parecer` disponível em `/parecer/saep/{id}`.