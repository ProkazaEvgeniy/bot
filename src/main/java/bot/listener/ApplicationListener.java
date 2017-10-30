package bot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import bot.main.BotMain;

@Component
public class ApplicationListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOGGER.info("***************** Aplication bot telegram stoped *****************");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.info("***************** Aplication bot telegram started *****************");
	}

}
