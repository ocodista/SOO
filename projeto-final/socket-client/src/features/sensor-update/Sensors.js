import React from 'react';
import { useSelector } from 'react-redux';
import {
  selectSensors,
} from './sensorsSlice';


function Sensor({ id, category, label, values }) {
  const renderMessage = (value, idx) => (<div key={idx}>{value} {label}</div>)

  return (
    <div>
      <h2>Sensor {id} ({category})</h2>
      {values.map((value, idx) => renderMessage(value, `${id}_${idx}`))}
    </div>
  )
}


export function Sensors() {
  const sensors = useSelector(selectSensors);

  return (
    <div>
      <h1>Sensores</h1>
      {sensors.map((sensor, i) => <Sensor {...sensor} />)}
    </div>
  );
}
