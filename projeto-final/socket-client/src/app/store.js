import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "../features/counter/counterSlice";
import deviceReducer from "../features/device-update/devicesSlice";

export const store = configureStore({
    reducer: {
        counter: counterReducer,
        device: deviceReducer,
    },
});
