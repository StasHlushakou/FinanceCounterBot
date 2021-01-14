package org.example.FinanceCounterBot.bot.commands.operation;

import org.example.FinanceCounterBot.bot.commands.AbstractCommand;
import org.example.FinanceCounterBot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class Delete extends AbstractCommand {

    @Autowired
    RecordService recordService;

    private static String commandIdentifier = "delete";
    private static String description = "Удалить все записи.";


    public Delete() {
        super(Delete.commandIdentifier, Delete.description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        recordService.removeAllByUserId(new Long(user.getId()));
        sendAnswer(absSender, chat.getId(), "Все записи удалены");
    }
}

