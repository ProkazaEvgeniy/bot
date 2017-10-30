package bot.configuration;

import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import bot.main.BotMain;
import bot.properties.BotProperties;

@Configuration
public class BotConfig {

	BotConfig(){
		BotProperties.load();
		ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(new BotMain());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
	
}
