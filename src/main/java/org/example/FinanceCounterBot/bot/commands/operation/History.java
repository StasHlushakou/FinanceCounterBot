package org.example.FinanceCounterBot.bot.commands.operation;

import org.example.FinanceCounterBot.bot.commands.AbstractCommand;
import org.example.FinanceCounterBot.bot.commands.service.Help;
import org.example.FinanceCounterBot.entity.Records;
import org.example.FinanceCounterBot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Component
public class History extends AbstractCommand {

    @Autowired
    RecordService recordService;

    private static String commandIdentifier = "history";
    private static String description = "Вывести историю затрат.";


    public History() {
        super(History.commandIdentifier, History.description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {


        List<Records> recordsList= recordService.getByUserId(new Long(user.getId()) );

        StringBuilder stringBuilder = new StringBuilder("");
        for (Records records : recordsList){
            stringBuilder.append(records.getDate().toString() + " " + records.getDescription() + "\n");
        }

        String result = stringBuilder.toString();
        if (result.length() == 0){
            result = "Записей нет";
        }

        sendAnswer(absSender, chat.getId(),result);
    }
}
