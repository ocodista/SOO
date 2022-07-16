package br.unesp.agrotech.utils;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitConsumer {
  private Connection _connection;
  private String _username;
  private String _password;
  private String _host;
  private String _queue;

  private void ReadConfig() {
    System.out.println("Reading rabbit config from environment...");
    _host = System.getenv("RABBIT_HOST");
    _username = System.getenv("RABBIT_USERNAME");
    _password = System.getenv("RABBIT_PASSWORD");
    _queue = System.getenv("RABBIT_QUEUE");
  }

  private Connection GetConnection() throws IOException, TimeoutException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(_host);
    return factory.newConnection();
  }

  public RabbitConsumer() {
    ReadConfig();
  }

  public void Consume() throws IOException, TimeoutException {
      _connection = GetConnection();
      System.out.println("Connected to queue " + _queue + "!");
      Channel channel = _connection.createChannel();
      channel.queueDeclare(_queue, false, false, false, null);
      Consumer consumer = new DefaultConsumer(channel) {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
          String mensagem = new String(body, "UTF-8");
          System.out.println("Mensagem recebida: " + mensagem);
        }
      };
      channel.basicConsume(_queue, true, consumer);
      System.out.println("Consumed queue " + _queue + "!");
      _connection.close();
  }
}
