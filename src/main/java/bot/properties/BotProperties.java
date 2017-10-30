package bot.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.configuration.BotConfig;

public class BotProperties {

	private final static Logger LOGGER = LoggerFactory.getLogger(BotConfig.class);

	public static final String CONFIG_BOT_FILE = "C:/Users/Kristina/workspace/bot/config/bot/bot.properties";

	public static String TOKEN;
	public static String BOT_NAME;
	public static String ID_ADMIN;

	public static void load() {
		loadBotSettings();
	}

	private static void loadBotSettings() {
		Properties botSettings = new Properties();

		try (InputStream is = new FileInputStream(new File(CONFIG_BOT_FILE))) {
			botSettings.load(is);
			is.close();
			LOGGER.info("*** Config bot load successful ***");
		} catch (Exception e) {
			LOGGER.error("*** Config bot not load fail ***");
		}
		
		BOT_NAME = botSettings.getProperty("BotName", "vtb_001_bot");
		TOKEN = botSettings.getProperty("BotToken", "371268009:AAFNiODq9Z9OpieSH2IQkSOj5kEsCG4MpHw");
		ID_ADMIN = botSettings.getProperty("id_admin", "113544988");
	}
}
