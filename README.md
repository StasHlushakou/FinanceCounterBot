# FinanceCounterBot

### @finance_counter_bot

Этот проект использует https://github.com/rubenlagus/TelegramBots

Текущая версия поддерживает следующие команды:
* /start - Команда по умолчанию, выводит приветственное сообщение.
* /help - Выводит информацию о формате данных для записи, а также все доступные команды
* /history - Выводит историю расходов.
* /delete - Удаляет историю расходов.
* /sum - Выводит сумму расходов.

### Конфигурация
Конфигурацмя осуществляется через переменные среды:

| Environment variable 	    | Required 	| Default value 	| Description                                                                    	                                                                                                                                                    |
|---------------------------|:--------:	|---------------	|--------------------------------------------------------------------------------	                                                                                                                                                    |
| TELEGRAM_BOT_TOKEN        |    Yes   	|               	| The token from [@BotFather](https://t.me/BotFather)                              	                                                                                                                                                    |
| TELEGRAM_BOT_NAME    	    |    Yes   	|               	| The username from [@BotFather](https://t.me/BotFather)                                                                                                                                                                                |


### Особенности
Проект задеплоен на Heroku. 
Из-за ограничения по времени бесплатной работы на данном хостинге бот может быть не всегда доступен.

### Технологии
Intellij IDEA, Git, Maven, Spring Boot 2.4.1 (Web, Data), PosrgreSQL, Telegrambots 5.0.1, Heroku.
