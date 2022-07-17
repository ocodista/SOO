import React from 'react';
import { useSelector } from 'react-redux';
import {
  selectSensors,
} from './sensorsSlice';

const leadingZero = (str) => (str.toString().length === 1 ? `0${str}` : str)

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


  const renderValues = () => (
    values.map((value, idx) => <Message {...value} label={label} idx={idx} />)
  )

  return (
    <section>
      <h2>Sensor {id} ({category})</h2>
      {renderValues()}
    </section>
  )
}


export function Sensors() {
  const sensors = useSelector(selectSensors);

  return (
    <div>
      <h1>Sensores</h1>
      {sensors.map((sensor, i) => <Sensor key={i} {...sensor} />)}
    </div>
  );
}
