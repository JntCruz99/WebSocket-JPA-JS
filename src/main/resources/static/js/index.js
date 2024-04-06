
const socket = new WebSocket('ws://localhost:8080/conect');
const Client = Stomp.over(socket);


function openPopup() {
    const popup = document.getElementById("popup");
    popup.classList.remove("hidden");
}

function openChat() {
    const popup = document.getElementById("popup");
    const chatContainer = document.getElementById("chatContainer");
    const usernameInput = document.getElementById("usernameInput").value;

    if (usernameInput !== "") {
        popup.style.display = "none";
        chatContainer.classList.remove("hidden");
        Client.send("/app/chatMessage");
        sessionStorage.setItem("user", usernameInput);
    } else {
        alert("Digite um nome válido!");
    }
}


function sendMessage(e) {
    e.preventDefault();
    const messageInput = document.getElementById("messageInput").value;

    const message = {
        username: sessionStorage.getItem("user"),
        msg: messageInput
    };

    axios.post('http://localhost:8080/message', message)
    .then(function (response) {
        console.log('Resposta do servidor:', response.data);
        Client.send("/app/chatMessage");
    })
    .catch(function (error) {
        console.error('Ocorreu um erro:', error);
    });


    document.getElementById("messageInput").value = "";
}

function displayMessage(message, name) {
    const chatMessages = document.getElementById("chatMessages");
    const messageElement = document.createElement("div");

    messageElement.textContent = name + ": " + message;
    chatMessages.appendChild(messageElement);
}

function connect(){
    Client.connect({}, function (frame) {
        
        Client.subscribe('/canal', function (message) {
            const chatMessages = JSON.parse(message.body);
            const chat = document.getElementById("chatMessages");
            chat.innerHTML = '';
            chatMessages.forEach(chatMessage => {
                displayMessage(chatMessage.msg, chatMessage.username);
            });
            
        });
        
    });
}


connect();
openPopup();