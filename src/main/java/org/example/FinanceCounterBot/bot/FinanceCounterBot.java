package org.example.FinanceCounterBot.bot;

import org.example.FinanceCounterBot.bot.commands.operation.Delete;
import org.example.FinanceCounterBot.bot.commands.operation.History;
import org.example.FinanceCounterBot.bot.commands.operation.Sum;
import org.example.FinanceCounterBot.bot.commands.service.Help;
import org.example.FinanceCounterBot.bot.commands.service.Start;
import org.example.FinanceCounterBot.entity.Currency;
import org.example.FinanceCounterBot.entity.Record;
import org.example.FinanceCounterBot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Date;


@Component
public class FinanceCounterBot extends TelegramLongPollingCommandBot {

    @Autowired
    RecordService recordService;

    @Autowired
    Start start;
    @Autowired
    Help help;
    @Autowired
    History history;
    @Autowired
    Delete delete;
    @Autowired
    Sum sum;

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


    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String inputText = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            Long userId = update.getMessage().getChatId();

            inputText.trim();
            if (inputText.matches("\\d+[.]{0,1}\\d*\\s+[рд$]\\s+.*") ||
                    inputText.matches("\\d+[.]{0,1}\\d*\\s+[рд$]")){
                Record record = new Record();
                record.setUserId(userId);

                String[] words = inputText.split("\\s+");

                record.setSum(new Double(words[0]));

                if (words[1].equals("р")){
                    record.setCurrency(Currency.BYN);
                } else {
                    record.setCurrency(Currency.USD);
                }

                StringBuilder stringBuilder = new StringBuilder("");
                for(int i = 2; i < words.length; i++){
                    stringBuilder.append(words[i]).append(" ");
                }
                record.setDescription(stringBuilder.toString());

                record.setDate(new Date(new Long (update.getMessage().getDate()) * 1000));

                recordService.addRecord(record);
                message.setText("ок");
            } else{
                message.setText("Неверный формат строки.\n" +
                        "Правильный формат : [сумма] [уазатель валюты(р/д/$)] [описание(опционально)]\n" +
                        "Все значения должны быть разделены пробелами");
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRegister() {
        register(start);
        register(help);
        register(history);
        register(delete);
        register(sum);

    }

}
