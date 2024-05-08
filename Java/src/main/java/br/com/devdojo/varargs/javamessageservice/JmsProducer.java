package br.com.devdojo.varargs.javamessageservice;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProducer {
    public static void main(String[] args) {

        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("myQueue");

            MessageProducer producer = session.createProducer(destination);

            TextMessage message = session.createTextMessage("Hello world!");

            producer.send(message);

            System.out.println("Mensagem enviada com sucesso");

            producer.close();
            session.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
