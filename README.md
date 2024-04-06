# Documentação do Backend WebSocket

Esta documentação apresenta uma visão geral do backend do aplicativo WebSocket. O backend é responsável por lidar com mensagens WebSocket e persistir mensagens de chat em um banco de dados.

## Estrutura do Projeto

O projeto é estruturado da seguinte forma:

- `com.websocket.websocket.config`: Pacote contendo classes de configuração.
- `com.websocket.websocket.controller`: Pacote contendo classes de controlador REST.
- `com.websocket.websocket`: Pacote principal contendo a classe de inicialização do aplicativo.
- `com.websocket.websocket.repository`: Pacote contendo a interface de repositório para operações de banco de dados.

## Classes e Funcionalidades

### ObjMsg

- **Descrição**: Representa uma mensagem de chat.
- **Atributos**:
  - `id`: Identificador único da mensagem.
  - `username`: Nome do usuário que enviou a mensagem.
  - `msg`: Conteúdo da mensagem de chat.

### WebSocket

- **Descrição**: Classe de configuração WebSocket.
- **Funcionalidades**:
  - Configura os endpoints do WebSocket.
  - Habilita o uso do protocolo STOMP (Simple Text Oriented Messaging Protocol).
  - Define os prefixos de destino para mensagens e notificações.

### MsgController

- **Descrição**: Controlador REST para operações relacionadas a mensagens.
- **Funcionalidades**:
  - `GET /message`: Retorna todas as mensagens de chat.
  - `GET /message/{id}`: Retorna uma mensagem específica pelo ID.
  - `POST /message`: Cria uma nova mensagem de chat.
  - `PUT /message/{id}`: Atualiza uma mensagem de chat existente.
  - `DELETE /message/{id}`: Exclui uma mensagem de chat.

### App

- **Descrição**: Controlador principal do aplicativo WebSocket.
- **Funcionalidades**:
  - Mapeia o endpoint `/chatMessage` para receber mensagens de chat e enviar atualizações para os clientes conectados.

### WebsocketApplication

- **Descrição**: Classe de inicialização do aplicativo.
- **Funcionalidades**:
  - Inicializa o aplicativo Spring Boot.

## Documentação do Frontend WebSocket

Esta documentação descreve a estrutura e funcionalidades do frontend do aplicativo WebSocket.

## Estrutura do Projeto

O projeto frontend consiste em um arquivo HTML e scripts JavaScript para lidar com a interação do usuário e a comunicação WebSocket.

- `index.html`: Arquivo HTML principal que contém a estrutura da página.
- `css/index.css`: Arquivo CSS para estilização da página.
- `js/sockjs.min.js` e `js/stomp.min.js`: Bibliotecas JavaScript para comunicação WebSocket.
- `js/index.js`: Arquivo JavaScript para manipulação do DOM e interações do usuário.

## Arquivo HTML (index.html)

O arquivo HTML contém a estrutura básica da página, incluindo a interface do chat e um formulário para inserir mensagens.

## Arquivo CSS (index.css)

O arquivo CSS é responsável pela estilização da página HTML, definindo a aparência e o layout do chat.

## Arquivo JavaScript (index.js)

O arquivo JavaScript é responsável por lidar com a lógica do aplicativo, incluindo a comunicação WebSocket e as interações do usuário.

### Funções JavaScript Principais

- `openPopup()`: Exibe um popup para o usuário inserir seu nome antes de entrar no chat.
- `openChat()`: Abre o chat após o usuário inserir seu nome e clicar no botão de entrada.
- `sendMessage(e)`: Envia uma mensagem para o servidor WebSocket após o usuário enviar uma mensagem no chat.
- `displayMessage(message, name)`: Exibe uma mensagem recebida no chat.
- `connect()`: Estabelece a conexão com o servidor WebSocket e subscreve ao canal de mensagens.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Websocket
- Spring Data JPA
- Lombok
- HTML
- CSS
- JavaScript
- WebSocket (SockJS e STOMP)
- Axios (para requisições HTTP)

## Executando o Aplicativo

Para executar o aplicativo WebSocket, basta iniciar a classe `WebsocketApplication`.
Para executar o aplicativo frontend, basta abrir no link [http://localhost:8080](http://localhost:8080/) em um navegador da web compatível.
