package org.example.FinanceCounterBot.bot.commands.service;

import org.example.FinanceCounterBot.bot.commands.AbstractCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class Help extends AbstractCommand {

    private static String commandIdentifier = "help";
    private static String description = "Помощь";


    public Help() {
        super(Help.commandIdentifier, Help.description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = "";
        if (user.getUserName() != null){
            userName = user.getUserName();
        } else if (user.getFirstName() != null){
            userName = user.getFirstName();
        }


        sendAnswer(absSender, chat.getId(),"Список команд:\n/start\n/help\n/history\n/delete");
    }
}
