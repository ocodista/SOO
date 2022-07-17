var express = require("express");
const { Server } = require("ws");

const PORT = process.env.PORT || 8007;
const INDEX = "/index.html";

const server = express()
  .use((req, res) => res.sendFile(INDEX, { root: __dirname }))
  .listen(PORT, () => console.log(`Listening on ${PORT}`));

function noop() { };
function heartbeat() { this.isAlive = true; }

const wss = new Server({ server });

wss.on("connection", (socket) => {
  socket.isAlive = true;
  console.log('New client connected!');
  socket.on('pong', heartbeat);
  socket.on("close", () => console.log("Client disconnected"));

  socket.on("message", async (body) => {
    wss.clients.forEach((client) => client.send(body));
  });

});

setInterval(() => {
  wss.clients.forEach((client) => {
    if (client.isAlive === false) return client.terminate();

    client.isAlive = false;
    client.ping(noop);
  });
}, 30000);
