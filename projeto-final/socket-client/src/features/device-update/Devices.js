import React from "react";
import { useSelector } from "react-redux";
import { selectDevices } from "./devicesSlice";
import DeviceChart from "../device-chart/DeviceChart";

const leadingZero = (str) => (str.toString().length === 1 ? `0${str}` : str);

const formattedTime = (dateStr) => {
    let d = dateStr;
    if (typeof dateStr !== typeof Date) {
        d = new Date(dateStr);
    }

    let hours = leadingZero(d.getHours());
    let minutes = leadingZero(d.getMinutes());
    let seconds = leadingZero(d.getSeconds());
    return `${hours}:${minutes}:${seconds}`;
};

const formattedDate = (dateStr) => {
    const d = new Date(dateStr);

    let day = leadingZero(d.getDate());
    let month = leadingZero(d.getMonth());
    let year = leadingZero(d.getFullYear());
    let hours = leadingZero(d.getHours());
    let minutes = leadingZero(d.getMinutes());
    let seconds = leadingZero(d.getSeconds());

    return `${day}/${month}/${year} ${hours}:${minutes}:${seconds}`;
};

function Message({ sentAt, value, label, idx }) {
    return (
        <div key={idx}>
            [{formattedDate(sentAt)}] {value} {label}
        </div>
    );
}

function Device({ id, type, category, label, values }) {
    const formattedLabel = label ? `(${label})` : "";
    const name = `${type} ${id} - ${category} ${formattedLabel}`;
    const chartData = values.map(({ value, sentAt }) => ({
        name,
        value,
        sentAt: formattedTime(sentAt),
    }));

    return (
        <section className="wh-50" style={{ paddingBottom: 20 }}>
            <DeviceChart title={name} data={chartData} category={category} />
        </section>
    );
}

export function Devices() {
    const devices = useSelector(selectDevices);
    let orderedDevices = [...devices];

    orderedDevices = orderedDevices.sort((a, b) => a.id - b.id);

    const renderDevices = () => {
        if (!devices.length) return <h2>Nenhum dado foi encontrado...</h2>;
        return orderedDevices.map((device, i) => (
            <Device key={i} {...device} />
        ));
    };

    return (
        <>
            <h1>Dispositivos</h1>
            <div class="wh-100">{renderDevices()}</div>
        </>
    );
}
