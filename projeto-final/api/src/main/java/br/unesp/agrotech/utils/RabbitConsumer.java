package br.unesp.agrotech;

public class RabbitConsumer {
  private Connection _connection;
  private String _username;
  private String _password;
  private String _host;
  private String _queue;
  
  private void ReadConfig() {
    _host = System.getEnv("RABBIT_HOST");
    _username = System.getEnv("RABBIT_USERNAME");
    _password = System.getEnv("RABBIT_PASSWORD");
    _queue = System.getEnv("RABBIT_QUEUE");
  }

  private Connection GetConnection() {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(_host);
    factory.setUsername(_username);
    factory.setPassword(_password);
    return factory.newConnection();
  }

  public RabbitConsumer() {
    ReadConfig();    

    try {
      _connection = GetConnection();
      Channel channel = connection.createChannel();
      channel.queueDeclare(_queue, false, false, false, null);
      Consumer consumer = new DefaultConsumer(channel) {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
          String mensagem = new String(body, "UTF-8");
          System.out.println("Mensagem recebida: " + mensagem);
        }
      };
      channel.basicConsume(_queue, true, consumer);
    } finally {
      _connection.dispose();
    }
  }

  public String Consume() {
    // connect to queue
    // parse message from string to java object with Json parser
    channel.queueDeclare("nomeDaFila", false, false, false, null);
    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String mensagem = new String(body, "UTF-8");
        System.out.println("Mensagem recebida: " + mensagem);
      }
    };
    channel.basicConsume("nomeDaFila", true, consumer);
  }
}