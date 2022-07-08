import { publish } from './core/rabbit.js'
import dotenv from 'dotenv'
import { wait } from './utils/timeUtils.js'

function getRandomArbitrary(min, max) {
  return Math.random() * (max - min) + min;
}

const getDispositivo = () => {
  const {
    CATEGORIA_ID,
    CATEGORIA_NOME,
    CATEGORIA_MEDIDA
  } = process.env


  const categoria = {
    id: CATEGORIA_ID,
    nome: CATEGORIA_NOME,
    medida: CATEGORIA_MEDIDA
  }

  const {
    ESTANTE_ID,
    ESTANTE_DESCRICAO,
    PRATELEIRAS,
    NICHOS_POR_PRATELEIRA
  } = process.env

  const estante = {
    id: ESTANTE_ID,
    descricao: ESTANTE_DESCRICAO,
    prateleiras: PRATELEIRAS,
    nichosPorPrateleira: NICHOS_POR_PRATELEIRA
  }

  const {
    TIPO_DISPOSITIVO_ID,
    TIPO_DISPOSITIVO_NOME
  } = process.env

  const tipo = {
    id: TIPO_DISPOSITIVO_ID,
    nome: TIPO_DISPOSITIVO_NOME
  }

  const {
    POSICAO_VERTICAL,
    POSICAO_HORIZONTAL
  } = process.env

  const nicho = {
    prateleira: {
      estanteId: ESTANTE_ID,
      posicaoVertical: POSICAO_VERTICAL
    },
    posicaoHorizontal: POSICAO_HORIZONTAL
  }

  const {
    DISPOSITIVO_ID
  } = process.env

  const dispositivo = {
    id: DISPOSITIVO_ID,
    categoria,
    estante,
    tipo,
    nicho
  }
  return dispositivo
}

(async () => {
  dotenv.config()
  const sensorQueue = process.env.SENSOR_QUEUE || 'sensor_update_queue'
  const intervalSeconds = process.env.INTERVAL_SECONDS || 60
  const dispositivo = getDispositivo()
  let value = 20.0

  while (true) {
    value += getRandomArbitrary(-0.3, 0.3)

    console.log(`Valor: ${parseFloat(value).toFixed(2)} `)

    const msg = {
      creadoEm: new Date(),
      dispositivo,
      valor: value
    }

    console.log(`Publicando na fila ${sensorQueue}...`)
    await publish(sensorQueue, msg)
    console.log(msg)
    await wait(intervalSeconds)
  }
})()
