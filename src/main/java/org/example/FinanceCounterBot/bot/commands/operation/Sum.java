package org.example.FinanceCounterBot.bot.commands.operation;

import org.example.FinanceCounterBot.bot.commands.AbstractCommand;
import org.example.FinanceCounterBot.entity.Currency;
import org.example.FinanceCounterBot.entity.Record;
import org.example.FinanceCounterBot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Component
public class Sum extends AbstractCommand {

    @Autowired
    RecordService recordService;

    private static String commandIdentifier = "sum";
    private static String description = "Вывести общую сумму затрат.";


    public Sum() {
        super(Sum.commandIdentifier, Sum.description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {


        List<Record> recordList = recordService.getByUserId(new Long(user.getId()) );

        Double rouble = 0.0;
        Double dollar = 0.0;

        for ( Record record : recordList){
            if (record.getCurrency() == Currency.USD){
                dollar += record.getSum();
            } else {
                rouble += record.getSum();
            }
        }

        String result = "Вы потратили " + dollar + " USD и " + rouble + " BYN.";

        sendAnswer(absSender, chat.getId(),result);
    }
}
