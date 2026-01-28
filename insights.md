# Spring insights


## Spring operational flow 

* Spring routes HTTP requests to controllers via DispatcherServlet. Components annotated with @Controller, @Service, or @Repository are managed beans and Spring uses dependency injection (constructor injection or @Autowired) to wire them together so controllers call services, services call repositories, the persistence layer (Spring Data/JPA + transactions) does the DB work, and the response flows back to the client.

* A dependência é sempre unidirecional: Controller -> Service -> Repository -> Model
 
1. **Model:** representa a estrutura de dados da aplicação e seu mapeamento para o banco de dados, utilizando anotações JPA para definir entidades, atributos e relacionamentos, servindo como a base da camada de domínio;

2. **Service:** é responsável por implementar as regras de negócio e toda a lógica específica do domínio, coordenando operações entre repositories e garantindo que as transformações e validações necessárias sejam aplicadas de acordo com os requisitos funcionais;

3. **Controller:** atua como ponto de entrada para requisições HTTP, mapeando endpoints, recebendo parâmetros, delegando processamento à camada de Service e devolvendo respostas adequadamente formatadas com os status HTTP correspondentes.

4. **Repository:** serve para abstrair a complexidade do banco de dados. Ele transforma comandos Java em comandos que o PostgreSQL entende (ex.: Operações CRUD).
 

5. **BONUS - Dto (data transfer object):** serve para transportar os dados do mundo real para dentro da aplicação. Permite que você escolha quais campos (ex.: brandCar...) podem ser enviados pelo usuário.

* @Valid funciona como validação das anotações (@NotBlank, @Size...) como no ParkingSpotDto, por exemplo.

