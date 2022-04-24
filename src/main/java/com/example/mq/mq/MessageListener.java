package com.example.mq.mq;


import com.example.mq.model.Client;
import com.example.mq.model.TransferHistory;
import com.example.mq.repository.ClientRepository;
import com.example.mq.repository.TransferHistoryRepository;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@EnableRabbit
@Component
public class MessageListener {
   @Autowired
ClientRepository clientRepository;
    @Autowired
   TransferHistoryRepository transferHistoryRepository;

   @RabbitListener(queues = MQConfig.QUEUE)
    public String listener(CustomMessage message) {
      System.out.println(message);


     List<Client> clients = clientRepository.findByCardLike(message.getCardOfReceiver());
      //clients=clientRepository.findByCard(message.getCardOfReceiver());
       //List<Client> clients = clientRepository.findByCard(message.getCardOfReceiver());
      List<Client> clientSender = clientRepository.findByCardLike(message.getCardOfHolder());


      if (clientSender.size() > 0 && clients.size() > 0) {

         if (clientSender.get(0).getCash() > message.getCash()) {
            Client client = clients.get(0);
            client.setCash(client.getCash() + message.getCash());
            clientRepository.save(client);

            Client sender = clientSender.get(0);
            sender.setCash(sender.getCash() - message.getCash());
            clientRepository.save(sender);

             TransferHistory transferHistory = new TransferHistory();
             transferHistory.setCardHolderName(message.getCardHolderName());
             transferHistory.setCardOfHolder(message.getCardOfHolder());
             transferHistory.setCardReceiverName(message.getCardReceiverName());
             transferHistory.setCardOfReceiver(message.getCardOfReceiver());
             transferHistory.setBankAccount(message.getCash());
             transferHistory.setDate(new Date());

             transferHistoryRepository.save(transferHistory);
            return "OK";
         } else {
            return "Недостаточно средств на балансе";
         }
      } else {
         return "Одна из карт не найдена";
      }



   }

}
