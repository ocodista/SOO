import { publish } from './core/rabbit.js'

(async () => {
  const sensorQueue = process.env.SENSOR_QUEUE || 'sensor_update_queue'
  const intervalSeconds = process.env.INTERVAL_SECONDS || 10
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

    const valor = 20;
    const msg = {
      creadoEm: new Date(),
      dispositivo,
      valor
    }

    console.log(`Publicando na fila ${sensorQueue}...\n${msg}`)
    await publish(sensorQueue, msg)
    console.log('Mensagem publicada!')
  }
})()
