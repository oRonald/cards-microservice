# Cards Microservice

<p>Diferentemente do Credit Assessor, que valida os dados do cliente e realiza a solicitação de um novo cartão,
o microserviço de Cartões será o responsável por "escutar" a mensagem com a solicitação e realizará a criação e junção
de um cliente com um cartão de crédito com um limite já estabelecido.</p>

<h3>Queue do RabbitMQ</h3>
<img width="227" height="71" alt="image" src="https://github.com/user-attachments/assets/853960f7-519c-4d74-bff2-ea091ef1b2fc" />

<h3>Trasnformação dos dados como RequestCardData e realizando o registro no banco de dados</h3>
<img width="678" height="551" alt="image" src="https://github.com/user-attachments/assets/c588016e-e23a-4c8c-8b62-51bf9825b9c1" />

## Tecnologias
- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Web
- H2 Database
- Eureka Discovery Client
- Spring Boot AMQP
- Spring Boot Actuator
- Springdoc Openapi (Swagger)
- Lombok
