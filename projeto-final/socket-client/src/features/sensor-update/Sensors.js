import React from 'react';
import { useSelector } from 'react-redux';
import {
  selectSensors,
} from './sensorsSlice';
import SensorChart from '../sensor-chart/SensorChart'

const leadingZero = (str) => (str.toString().length === 1 ? `0${str}` : str)

const formattedTime = (dateStr) => {
  let d = dateStr
  if (typeof (dateStr) !== typeof (Date)) {
    d = new Date(dateStr)
  }

  let hours = leadingZero(d.getHours())
  let minutes = leadingZero(d.getMinutes())
  let seconds = leadingZero(d.getSeconds())
  return `${hours}:${minutes}:${seconds}`
}

const formattedDate = (dateStr) => {
  const d = new Date(dateStr)

  let day = leadingZero(d.getDate())
  let month = leadingZero(d.getMonth())
  let year = leadingZero(d.getFullYear())
  let hours = leadingZero(d.getHours())
  let minutes = leadingZero(d.getMinutes())
  let seconds = leadingZero(d.getSeconds())

  return `${day}/${month}/${year} ${hours}:${minutes}:${seconds}`
}

function Message({ sentAt, value, label, idx }) {
  return (
    <div key={idx}>[{formattedDate(sentAt)}] {value} {label}</div>
  )
}

function Sensor({ id, category, label, values }) {
  const name = `Sensor ${id} (${category})`
  const chartData = values.map(({ value, sentAt }) => ({
    name,
    value,
    sentAt: formattedTime(sentAt)
  }))

  const renderValues = () => (
    values.map((value, idx) => <Message {...value} label={label} idx={idx} />)
  )

  return (
    <section className="wh-50" style={{ paddingBottom: 20 }}>
      <SensorChart title={name} data={chartData} />
    </section>
  )
}


export function Sensors() {
  const sensors = useSelector(selectSensors);
  let orderedSensors = [...sensors]

  orderedSensors = orderedSensors.sort((a, b) => a.id - b.id)
  console.log('Ordered Sensors', orderedSensors)

  return (
    <>
      <h1>Sensores - Estante 1</h1>
      <div class="wh-100" >
        {orderedSensors.map((sensor, i) => <Sensor key={i} {...sensor} />)}
      </div>
    </>
  );
}
