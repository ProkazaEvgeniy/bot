package bot.service.generator.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.service.answer.DivideAnswer;
import bot.service.generator.impl.AnswerGeneratorImpl;
import bot.session.Session;

public class DivideGenerator extends AnswerGeneratorImpl {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(DivideGenerator.class);

	public DivideGenerator(Session session) {
		session.setDivideAnswer(new DivideAnswer());
		LOGGER.info("DivideGenerator instance");
	}

}
