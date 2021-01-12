package org.example.FinanceCounterBot.bot.commands.service;

import org.example.FinanceCounterBot.bot.commands.AbstractCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;


@Component
public class Start extends AbstractCommand {


    private static String commandIdentifier = "start";
    private static String description = "Начать работу с ботом";


    public Start() {
        super(Start.commandIdentifier, Start.description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = "";
        if (user.getUserName() != null){
            userName = user.getUserName();
        } else if (user.getFirstName() != null){
            userName = user.getFirstName();
        }


        sendAnswer(absSender, chat.getId(),"Давайте начнём! Если Вам нужна помощь, нажмите /help");
    }





}
