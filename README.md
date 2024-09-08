# Hexagonal Architecture - Todo Application

Este projeto é um exemplo de aplicação utilizando a **Arquitetura Hexagonal**, também conhecida como **Ports and Adapters**, em uma aplicação de gerenciamento de tarefas (Todo). O objetivo desta arquitetura é desacoplar o núcleo de negócios (domínio) da infraestrutura, tornando a aplicação mais flexível, testável e fácil de manter.

## Estrutura do Projeto

A estrutura do projeto segue a divisão entre os diferentes componentes que compõem a arquitetura hexagonal:

src/main/java/br/com/bruno/hexagonalarchitecture
```
├── adapter
│   ├── entity
│   │   └── TodoEntity.java
│   ├── infra
│   │   ├── ModelMapperConfig.java
│   │   └── TodoServicePortConfig.java
│   └── repository
│       ├── TodoRepository.java
│       └── TodoRepositoryImp.java
├── domain
│   ├── dto
│   │   └── TodoDTO.java
│   ├── port
│   │   ├── TodoRepositoryPort.java
│   │   └── TodoServicePort.java
│   ├── service
│   │   └── TodoService.java
│   └── Todo.java
└── HexagonalStructApplication.java
```


### Componentes

#### 1. **Domain** (`src/main/java/br/com/bruno/hexagonalarchitecture/domain`)

O **Domínio** é o coração da aplicação. Ele contém as regras de negócio e as entidades que representam os conceitos fundamentais. Nesta camada, não há dependência direta de frameworks ou infraestrutura.

- **Todo.java**: A entidade do domínio que representa a tarefa (Todo).
- **TodoDTO.java**: Um objeto de transferência de dados (DTO) usado para comunicação entre diferentes camadas.
- **TodoService.java**: Contém a lógica de negócio relacionada à manipulação de tarefas (Todo).
- **Port Interfaces** (`port`): Interfaces que definem contratos para comunicação entre o domínio e o mundo externo:
    - **TodoRepositoryPort.java**: Interface que define os métodos para persistência das tarefas.
    - **TodoServicePort.java**: Interface que define os métodos expostos pelo serviço de tarefas.

#### 2. **Adapter** (`src/main/java/br/com/bruno/hexagonalarchitecture/adapter`)

Os **Adapters** (adaptadores) são responsáveis por conectar o domínio com as implementações concretas. Eles fazem parte da camada de infraestrutura e possuem a responsabilidade de conectar o domínio a frameworks, bancos de dados, APIs externas, etc.

- **entity**: Contém a representação da entidade `TodoEntity`, que é usada para a persistência no banco de dados.
    - **TodoEntity.java**: Entidade de banco de dados que representa a tarefa.
- **infra**: Configurações de infraestrutura e instância de serviços.
    - **ModelMapperConfig.java**: Configuração para o mapeamento de objetos entre diferentes camadas (como `DTO` e `Entity`).
    - **TodoServicePortConfig.java**: Configuração para injeção de dependências da porta do serviço.
- **repository**: Implementação da persistência de dados.
    - **TodoRepository.java**: Interface que define as operações de persistência da entidade `TodoEntity`.
    - **TodoRepositoryImp.java**: Implementação concreta do repositório, usando a interface `TodoRepositoryPort` para conectar o domínio com o banco de dados.

#### 3. **Application** (`src/main/java/br/com/bruno/hexagonalarchitecture/HexagonalStructApplication.java`)

Esta é a classe principal da aplicação, onde o Spring Boot inicializa o projeto. Ela serve como ponto de entrada para o framework.

### Arquitetura Hexagonal

A **Arquitetura Hexagonal** (Ports and Adapters) tem como principal objetivo isolar o núcleo da aplicação (Domínio) das dependências externas (como banco de dados, interfaces de usuário e serviços externos). A ideia central é que o domínio interage com o mundo exterior por meio de **portas** (interfaces), que são implementadas pelos **adaptadores**.

- **Ports**: São as interfaces que definem contratos para que o domínio se comunique com o mundo exterior. Elas permitem que o domínio seja completamente independente de detalhes técnicos da infraestrutura.
- **Adapters**: São as implementações concretas das portas, onde interagimos com tecnologias específicas (como banco de dados, APIs externas, etc.).

### Benefícios

1. **Desacoplamento**: O núcleo da aplicação não depende de detalhes de implementação externa.
2. **Facilidade de Testes**: Como o domínio é isolado, podemos facilmente criar mocks e testes unitários sem necessidade de inicializar toda a infraestrutura.
3. **Flexibilidade**: Mudanças nas camadas externas (como a troca de banco de dados) podem ser feitas sem afetar o domínio.
4. **Manutenção Simplificada**: A estrutura modular facilita a manutenção e evolução da aplicação.

### Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **ModelMapper**: Para mapear objetos entre diferentes camadas.
- **H2 Database**: Banco de dados em memória para testes.

### Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   
   cd hexagonal-architecture

   ./mvnw spring-boot:run
   ```
   
### Endpoints

- **GET /todos**: Retorna a lista de todas as tarefas.
- **GET /todos/{id}**: Retorna uma tarefa específica com base no ID.
- **POST /todos**: Cria uma nova tarefa com base nos dados fornecidos.
- **PUT /todos/{id}**: Atualiza uma tarefa existente com base no ID.
- **DELETE /todos/{id}**: Exclui uma tarefa com base no ID.
- **PUT /todos/{id}/done**: Marca uma tarefa como concluída com base no ID.
- **PUT /todos/{id}/undone**: Marca uma tarefa como não concluída com base no ID.

Exemplos de requisições no arquivo: `files/request.http`

### Autor
[Bruno Lessa](https://www.linkedin.com/in/bruno-lessa-ferraz/)
   

