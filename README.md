# SpringCloudLab

Um simples aplicativo demonstrando o funcionamento de algumas tecnologias do pacote Spring Cloud.

O aplicativo realiza uma saudação a um determinado nome especificado em no serviço 1. As saudações podem ser em português e inglês.

![alt text](https://github.com/Brunomcarvalho89/SpringCloudLab/blob/main/spring.cloud.lab.png)

Utilizando:

Service registry: spring-cloud-starter-netflix-eureka-server

Circuit Breaker:  spring-cloud-starter-netflix-hystrix - Alterado para spring-cloud-starter-circuitbreaker-resilience4j pois o Hystrix esta em modo de manutenção.

Spring Gateway:  spring-cloud-starter-gateway

ConfigServer: Spring-cloud-config-server

Health-Check: Actuator

### Serviço 1: 
MessageServiceName -> Serviço responsável por fornercer o nome que será dado a saudação.

### Serviço 2: 
MessageServiceHello -> Serviço responsável por realizar a saudação "Ola" em ingles. Este serviço acessa o serviço 1 para recuperar o nome.

### Serviço 3:
MessageServiceOla -> Serviço responsável por realizar a saudação "Ola" em português. Este serviço acessa o serviço 1 para recuperar o nome.

### Serviço 4:
ServiceRegistry -> Serviço de registro Netflix Eureka para as apis criadas.

### Serviço 5:
ConfigServer -> Servidor de configuração(Spring-cloud-config-server).

### Serviço 6:
MessageServiceGateway -> Servidor de gateway utilizando o Spring Cloud Gateway.

### Repositorio de configuracao:
ConfigRepo -> Para teste local deve ser inicializado um repositorio local para o diretorio ConfigRepo. A configuração do servidor de configuracao é baseado no git.(spring.cloud.config.server.git.uri)

** O foco deste lab foi demostrar o uso das tecnologias do SpringCloud, então nao foi escrito nenhuma classe de testes para o projeto.(O projeto WeatherIntegrationAPI está com 100 porcento de cobertura de testes de unidade.)
