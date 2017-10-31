package bot.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import bot.main.BotMain;
import bot.properties.BotProperties;

@Configuration
public class BotConfig {
	
	@Autowired
	private BotMain botMain;

	@PostConstruct
	private void init(){
		//BotProperties.load();
		//ApiContextInitializer.init();
		try {
			new TelegramBotsApi().registerBot(botMain);
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
	
}
