import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';
import sensorReducer from '../features/sensor-update/sensorsSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
    sensor: sensorReducer
  },
});
