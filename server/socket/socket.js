const express = require('express');
const http = require('http');
const socketIO = require('socket.io');

const app = express();

const server = http.createServer(app);

const io = socketIO(server);

var notify = [];

io.on("connection", (socket) => {
  console.log(`new client ID : ${socket.id}`);

  socket.on("notify", (data) => {
    console.log("notification : " + data);
    notify.push(data);
    io.emit("notify", notify);
  })
  io.emit("notify", notify);
})

function sendTestNotification(productName) {
  io.emit("notify", productName);
}



const port = 9091;
server.listen(port, () => {
  console.log(`Server on ${port}`);
});