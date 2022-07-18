import { LineChart, Line, CartesianGrid, XAxis, YAxis } from 'recharts'
import Plot from 'react-plotly.js'

const RechartsChart = (data, title, minValue, maxValue) => {
  const renderLineChart = (
    <LineChart
      margin={{ top: 0, right: 20, bottom: 0, left: 20 }}
      width={600}
      height={300}
      data={data}
    >
      <text
        x={500 / 2}
        y={20}
        fill="black"
        textAnchor="middle"
        dominantBaseline="central"
      >
        <tspan fontSize="24">{title}</tspan>
      </text>
      <Line type="monotone" dataKey="value" stroke="#8884d8" />
      <CartesianGrid stroke="#ccc" />
      <XAxis
        dy={10}
        type="category"
        dataKey="sentAt" />
      <YAxis
        type="number"
        domain={[minValue - 20, maxValue + 20]}
        tickFormatter={(tick) => (`${tick} ºC`)} dataKey="value" />
    </LineChart>
  );
  return renderLineChart


}

const PlotLyChart = (sentAt, values, title) => {
  return (
    <Plot
      data={[{
        x: sentAt,
        y: values,
        type: 'line',
        marker: { color: 'blue' }
      }
      ]}
      layout={{
        width: 600,
        height: 300,
        title
      }}
    />
  )
}

const SensorChart = ({ data, title }) => {
  const sentAt = data.map((item) => item.sentAt)
  const values = data.map((item) => item.value)

  const minValue = values.sort((a, b) => a < b)[0]
  const maxValue = values.sort((a, b) => a > b)
  // RechartsChart(data, title, minValue, maxValue)
  return PlotLyChart(sentAt, values, title)

}

export default SensorChart;