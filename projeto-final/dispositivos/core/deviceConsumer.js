import dotenv from "dotenv";
import { consume } from "./rabbit.js";
import { run } from "./device.js";

const wait = () => {
    setTimeout(wait, 5000);
};

(async () => {
    dotenv.config();
    const queueDispositivo = process.env.DEVICE_QUEUE || "dispositivo";
    await consume(queueDispositivo, async (dispositivo) => {
        console.log(`Novo dispositivo encontrado!\n${dispositivo}`);
        dispositivo.categoria = dispositivo.categoriaDispositivo;
        dispositivo.tipo = dispositivo.tipoDispositivo;
        await run(dispositivo);
        console.log("Novo dispositivo iniciado!");
    });
    console.log("Esperando por novos dispositivos...");
    wait();
})();
