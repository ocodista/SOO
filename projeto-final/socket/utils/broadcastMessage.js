const WebSocket = require("ws");

const message = {
  id: 1,
  value: 10.5,
  category: 'Temperatura',
  label: 'ºC'
};

const broadcast = () => {
  let socketUrl = "ws://localhost:3155/";
  const ws = new WebSocket(socketUrl);

  ws.on("open", function open() {
    const sendMessage = (obj) => {
      let msg = JSON.stringify(obj)
      ws.send(msg);
      console.log('Sent message!', msg)
    };
    sendMessage(message);
  });

  ws.on("ping", function incoming(data) {
    console.log("Received ping!");
    ws.emit("pong", "");
  });

  ws.on("message", function incoming(data) {
    console.log("Message received!", data);
  });

  console.log('Press any key to exit');

  process.stdin.setRawMode(true);
  process.stdin.resume();
  process.stdin.on('data', process.exit.bind(process, 0));
}

module.exports = broadcast;

broadcast();
