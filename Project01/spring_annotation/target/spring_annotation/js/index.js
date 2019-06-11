var socket;

if(window.WebSocket){

    socket = new WebSocket("ws://localhost:8899/ws");

    socket.onmessage = function (event) {

        var ta = document.getElementById("responseText");

        ta.value = ta.value +'\n' + event.data ;
    }

    socket.onopen = function (ev) {

        var ta = document.getElementById("responseText");

        ta.value = "连接开启";
    }
    socket.onclose = function (ev) {

        var ta = document.getElementById("responseText");

        ta.value =ta.value +"\n"+"连接断开";
    }
}else {
    alert('浏览器不支持WebSocket');
}

function send(message) {

    if(!window.socket){
        return ;
    }

    /*   发送消息    */
    if(socket.readyState == WebSocket.OPEN){

        socket.send(message);
    }else{
        alert("连接尚未开启! ");
    }
}