import amqplib from 'amqplib'

const connectionString = process.env.RABBITMQ_CONNECTION_STRING || 'amqp://fila-soo:Grupo05-SOO@localhost:5672'

const getChannel = async (queue) => {
    console.log(`Connecting to ${connectionString} queue ${queue}`)
    const connection = await amqplib.connect(connectionString, "heartbeat=60")
    const channel = await connection.createChannel()
    await connection.createChannel()
    await channel.assertQueue(queue, { durable: false })
    return { connection, channel }
}

const consume = async (queue, action) => {
    const { connection, channel } = await getChannel(queue)
    await channel.consume(queue, async (msg) => {
        console.log(`Message received: ${msg.content}`)
        channel.ack(msg)
        await action(msg)
    })
    setTimeout(() => {
        channel.close()
        connection.close()
    }, 500)
}

const publish = async (queue, object) => {
    const { connection, channel } = await getChannel(queue)
    channel.publish('', queue, Buffer.from(JSON.stringify(object)), {
        priority: 0,
        contentType: 'application/json',
        contentEncoding: 'UTF-8',
        deliveryMode: 2,
        headers: {
            '__TypeId__': 'br.unesp.agrotech.models.SensorMessage'
        }
    })
    console.log(`[INFO] - ${(new Date()).toLocaleDateString()} ${new Date().toLocaleTimeString()} Message published to queue ${queue}!\n\n`)
    setTimeout(() => {
        channel.close()
        connection.close()
    }, 500)
}

export {
    consume,
    publish
}
