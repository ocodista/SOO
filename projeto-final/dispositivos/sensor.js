import { publish } from './core/rabbit.js'
import dotenv from 'dotenv'
import { readJsonFile } from './utils/fileUtils.js'

function getRandomArbitrary(min, max) {
  return Math.random() * (max - min) + min;
}

(async () => {
  dotenv.config()
  const sensorQueue = process.env.SENSOR_QUEUE || 'sensor_update_queue'
  const intervalSeconds = process.env.INTERVAL_SECONDS || 10
  let value = 20.0
  while (true) {
    console.log(`Waiting ${intervalSeconds}s...`)
    await new Promise(r => setTimeout(r, intervalSeconds * 1000))

    const categoria = {
      id: 1,
      nome: 'Temperatura',
      medida: 'ºC'
    }

    const estante = {
      id: 1,
      descricao: 'Estante de plantas',
      prateleiras: 3,
      nichosPorPrateleira: 3
    }

    const tipo = {
      id: 1,
      nome: 'Sensor'
    }

    const nicho = {
      prateleira: {
        estanteId: 1,
        posicaoVertical: 1
      },
      posicaoHorizontal: 1
    }

    const dispositivo = {
      id: 1,
      categoria,
      estante,
      tipo,
      nicho
    }

    value += getRandomArbitrary(-0.3, 0.3)
    console.log(`Valor: ${parseFloat(value).toFixed(2)} `)
    const msg = {
      creadoEm: new Date(),
      dispositivo,
      valor: value
    }

    console.log(`Publicando na fila ${sensorQueue}...`)
    await publish(sensorQueue, msg)
    console.log('Mensagem publicada!')
  }
})()
