import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  sensors: []
};

const addSensorIfNew = (state, msg) => {
  const { id, category, label } = msg
  const existsSensor = state.sensors.find(sensor => sensor.id === id)
  if (!existsSensor) {
    const newSensor = {
      id,
      category,
      label,
      values: []
    }
    state.sensors.push(newSensor)
  }
}

const getSensor = (state, id) => (state.sensors.find(sensor => sensor.id === id))

const addSensorValue = (state, value, sentAt, id) => {
  const sensor = getSensor(state, id)
  sensor.values.push({ sentAt, value })
}

export const sensorSlice = createSlice({
  name: 'sensor',
  initialState,
  reducers: {
    addMessage: (state, { payload: msg }) => {
      const { id, value, sentAt } = msg
      addSensorIfNew(state, msg)
      addSensorValue(state, value, sentAt, id)
    }
  }
});

export const { addMessage } = sensorSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.sensor.value)`
export const selectSensors = (state) => state.sensor.sensors;

export default sensorSlice.reducer;
