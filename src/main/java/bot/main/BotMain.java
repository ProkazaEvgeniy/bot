package bot.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import bot.properties.BotProperties;
import bot.service.generator.AnswerGenerator;
import bot.service.generator.impl.AnswerGeneratorProvider;
import bot.session.Session;

@Component
public class BotMain extends TelegramLongPollingBot implements ApplicationContextAware{

	private final static Logger LOGGER = LoggerFactory.getLogger(BotMain.class);

	private String botUsername;

	private String botToken;

	private String idAdmin;
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public String getBotUsername() {
		return botUsername;
	}

	@Override
	public String getBotToken() {
		return botToken;
	}

	private LoadingCache<String, Session> sessions;
	
	static {
		BotProperties.load();
		ApiContextInitializer.init();
	}

	public BotMain() {
		botUsername = BotProperties.BOT_NAME;
		botToken = BotProperties.TOKEN;
		idAdmin = BotProperties.ID_ADMIN;
		this.sessions = CacheBuilder.newBuilder().expireAfterAccess(10L, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Session>() {
					@Override
					public Session load(String s) throws Exception {
						return applicationContext.getBean(Session.class);
					}
				});
		LOGGER.info("************ BotMain created ************");

	}

	private Session getSession(Message message) {
		try {
			return sessions.get(String.format("%d:%d", message.getChatId(), message.getFrom().getId()));
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText())
			handleTextMessage(update.getMessage());
	}

	/*
	 * performance main command
	 */
	private void handleTextMessage(Message message) {
		String text = message.getText();
		LOGGER.info("Пользователь = " + message.getFrom().getFirstName() + " написал = " + text);
		Session session = getSession(message);
		/*
		 * 
		 * */
		if (session.hasAnswerGenerator()) {
			String answerText = null;

			/*
			 * command /findbyrecipe
			 * */
			if(session.hasFindByRecipeAnswer()){
				answerText = session.findBySearchQuery(text);
				answerResult(session, message, answerText);
			}
		}
		/*
		 * 
		 * */
		else if (text.startsWith("/")) {
			answerGenerator(session, message, text);
		}
		/*
		 * 
		 * */
		else {
			answerHelp(session, message);
		}

	}

	/*
	 * answerGenerator
	 */
	private void answerGenerator(Session session, Message message, String text) {
		AnswerGenerator answerGenerator = AnswerGeneratorProvider.getAnswerGeneratorFor(session, text.substring(1));
		if (answerGenerator != null) {
			session.setAnswerGenerator(answerGenerator);
			/*
			 * if is present Repeat argument
			 * */
			if (session.hasRepeatArgument()) {
				
			} else {
				answerOK(session, message);
			} // end Repeat argument
			
		} else {
			answerHelp(session, message);
		}
	}

	/*
	 * additional command
	 */
	private void answerHelp(Session session, Message message) {
		try {
			execute(session.answer(message, "Укажите, что нужно сделать, пользуясь командами:" 
					+ "\n" + " /add - сумма"
					+ "\n" + " /div - разделить" 
					+ "\n" + " /help - помощь" 
					+ "\n" + " /finduserbotbyid - найти пользователя по ID" 
					+ "\n" + " /savecocktail - сохранить коктейль"
					+ "\n" + " /findcocktailbyname - найти коктейль по названию" 
					+ "\n" + " /findallcocktail - найти все коктейли"
					+ "\n" + " /findbyrecipe - найти коктейль по рецепту"));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	private void answerResult(Session session, Message message, String answerText) {
		try {
			execute(session.answer(message, answerText));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	private void answerOK(Session session, Message message) {
		try {
			execute(session.answer(message, "OK, write text (ОК, пишите текст)"));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
