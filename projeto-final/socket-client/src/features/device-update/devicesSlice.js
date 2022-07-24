import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    devices: [],
};

const addDeviceIfNew = (state, msg) => {
    const { id } = msg;
    const existsDevice = state.devices.find((device) => device.id === id);
    if (!existsDevice) {
        const newDevice = {
            ...msg,
            values: [],
        };
        state.devices.push(newDevice);
    }
};

const getDevice = (state, id) =>
    state.devices.find((device) => device.id === id);

const addDeviceValue = (state, value, sentAt, id) => {
    const device = getDevice(state, id);
    device.values.push({ sentAt, value });
};

export const deviceSlice = createSlice({
    name: "device",
    initialState,
    reducers: {
        addMessage: (state, { payload: msg }) => {
            const { id, value, sentAt } = msg;
            addDeviceIfNew(state, msg);
            addDeviceValue(state, value, sentAt, id);
        },
    },
});

export const { addMessage } = deviceSlice.actions;

// The function below is called a selector and allows us to select a value from
// the state. Selectors can also be defined inline where they're used instead of
// in the slice file. For example: `useSelector((state: RootState) => state.device.value)`
export const selectDevices = (state) => state.device.devices;

export default deviceSlice.reducer;
