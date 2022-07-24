import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { addMessage } from "./features/device-update/devicesSlice";
import SockJS from "sockjs-client";
import { over } from "stompjs";
import "./App.css";
import { Devices } from "./features/device-update/Devices";

const SOCKET_URL =
    process.env.REACT_APP_HOST_SOCKET_URL ||
    "http://localhost:8080/agrotech/ws";
let stompClient = undefined;
function App() {
    const dispatch = useDispatch();
    useEffect(() => {
        const onMessageReceived = (payload) => {
            var parsedMessage = JSON.parse(payload.body);
            dispatch(addMessage(parsedMessage));
            return;
        };

        const onConnected = () => {
            stompClient.subscribe("/sensors/update", onMessageReceived);
            console.log("Websocket conectado!");
        };

        if (!stompClient) {
            console.log(`Conectando em ${SOCKET_URL}...`);
            let Sock = new SockJS(SOCKET_URL);
            stompClient = over(Sock);
            stompClient.connect({}, onConnected, (err) => console.error(err));
        }
    }, [dispatch]);

    return (
        <div className="App wh-100">
            <Devices />
        </div>
    );
}

export default App;
