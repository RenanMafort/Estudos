package br.com.devdojo.varargs.javamessageservice;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsConsumer {
    public static void main(String[] args) {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Crie uma conexão JMS
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Crie uma sessão JMS
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Crie uma fila de destino
            Destination destination = session.createQueue("myQueue");

            // Crie um consumidor JMS
            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Mensagem recebida: " + textMessage.getText());
            }
            consumer.close();
            session.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
