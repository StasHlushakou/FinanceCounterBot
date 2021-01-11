package org.example.FinanceCounterBot.bot;

import org.example.FinanceCounterBot.entity.Currency;
import org.example.FinanceCounterBot.entity.Records;
import org.example.FinanceCounterBot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Date;
import java.util.List;

@Component
public class FinanceCounterBot extends TelegramLongPollingBot {

    @Autowired
    RecordService recordService;


    @Value("${telegram.bot.name}")
    private String BOT_NAME;

    @Value("${telegram.bot.token}")
    private String BOT_TOKEN;

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }

    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            String input = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            Long userId = update.getMessage().getChatId();

            if ( input.equals("///")){
                List<Records> recordsList= recordService.getByUserId(userId);

                StringBuilder stringBuilder = new StringBuilder();
                for (Records records : recordsList){
                    stringBuilder.append(records.getDate().toString() + " " + records.getDescription() + "\n");
                }

                message.setText(stringBuilder.toString());


            }else {
                Records records = new Records();
                records.setUserId(userId);
                records.setCurrency(Currency.RUBLE);
                records.setDescription("/// " + update.getMessage().getText()+ " ///" );
                records.setDate(new Date(new Long (update.getMessage().getDate()) * 1000));
                records.setSum(0.0);
                recordService.addRecords(records);
                message.setText("ok");

            }

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
