import dotenv from "dotenv";
import { getDispositivoFromEnvironmentVariables, run } from "../core/sensor.js";

(async () => {
    dotenv.config();
    const dispositivo = getDispositivoFromEnvironmentVariables();
    await run(dispositivo);
})();
