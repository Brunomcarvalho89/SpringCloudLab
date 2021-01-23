# SpringCloudLab

Um simples aplicativo demonstrando o funcionamento de algumas tecnologias do pacote Spring Cloud.

O aplicativo realiza saudação a um determinado nome especificado em um dos serviços. As saudações podem ser em portugue e ingles.

Utilizando:

Service registry: spring-cloud-starter-netflix-eureka-server

Circuit Breaker:  spring-cloud-starter-netflix-hystrix


### Serviço 1: 
MessageServiceSubject -> Serviço responsável por fornercer o nome do sujeito que sera dado a saudação.

### Serviço 2: 
MessageServiceHello -> Serviço responsável por realizar a saudação Ola em ingles. Este serviço acessa o serviço 1 para recuperar o sujeito.

### Serviço 3:
MessageServiceOla -> Serviço responsável por realizar a saudação Ola em português. Este serviço acessa o serviço 1 para recuperar o sujeito.

### Serviço 4:
ServiceRegistry -> Serviço de registro Netflix Eureka para as apis criadas.

** O foco deste lab foi demostrar o uso das tecnologias do SpringCloud, então nao foi escrito nenhuma classe de testes para o projeto.(O projeto WeatherIntegrationAPI está com 100 porcento de cobertura de testes de unidade.)
