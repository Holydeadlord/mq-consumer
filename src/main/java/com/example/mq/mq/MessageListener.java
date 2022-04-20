package com.example.mq.mq;


import com.example.mq.model.Client;
import com.example.mq.repository.ClientRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableRabbit
@Component
public class MessageListener {
   @Autowired
ClientRepository clientRepository;

   @RabbitListener(queues = MQConfig.QUEUE)
    public String listener(CustomMessage message) {
      System.out.println(message);

      List<Client> clients = clientRepository.findByCard(message.getCardOfReceiver());
      List<Client> clientSender = clientRepository.findByCard(message.getCardOfHolder());

      if (clientSender.size() > 0 && clients.size() > 0) {

         if (clientSender.get(0).getCash() > message.getCash()) {
            Client client = clients.get(0);
            client.setCash(client.getCash() + message.getCash());
            clientRepository.save(client);

            Client sender = clientSender.get(0);
            sender.setCash(sender.getCash() - message.getCash());
            clientRepository.save(sender);
            return "OK";
         } else {
            return "Недостаточно средств на балансе";
         }
      } else {
         return "Одна из карт не найдена";
      }

   }

}