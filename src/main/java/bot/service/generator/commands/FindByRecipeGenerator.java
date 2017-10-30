package bot.service.generator.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.service.answer.FindByRecipeAnswer;
import bot.service.generator.impl.AnswerGeneratorImpl;
import bot.session.Session;

public class FindByRecipeGenerator extends AnswerGeneratorImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(AddGenerator.class);
	
	public FindByRecipeGenerator(Session session) {
		session.setFindByRecipeAnswer(new FindByRecipeAnswer());
		LOGGER.info("FindByRecipeAnswer instance");
	}
}
