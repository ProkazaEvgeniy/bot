package bot.service.generator.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.service.answer.AddAnswer;
import bot.service.answer.RepeatArgument;
import bot.service.generator.impl.AnswerGeneratorImpl;
import bot.session.Session;

public class AddGenerator extends AnswerGeneratorImpl {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AddGenerator.class);
	
	public AddGenerator(Session session) {
		session.setAddAnswer(new AddAnswer());
		LOGGER.info("AddGenerator instance");
		session.setRepeatArgument(new RepeatArgument());
		LOGGER.info("RepeatArgument instance");
	}
	
}
