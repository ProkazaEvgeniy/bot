package bot.service.generator.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.service.answer.FindAllCocktailAnswer;
import bot.service.answer.RepeatArgument;
import bot.service.generator.impl.AnswerGeneratorImpl;
import bot.session.Session;

public class FindAllCocktailGenerator extends AnswerGeneratorImpl {

	private final static Logger LOGGER = LoggerFactory.getLogger(FindAllCocktailGenerator.class);
	
	public FindAllCocktailGenerator(Session session) {
		session.setFindAllCocktailAnswer(new FindAllCocktailAnswer());
		LOGGER.info("FindAllCocktailAnswer instance");
		session.setRepeatArgument(new RepeatArgument());
		LOGGER.info("RepeatArgument instance");
		//session.getArgumentUser().setCocktails(session.generateAnswerFindAllCocktailTextList());
		//LOGGER.info("set All Cocktails instance");
	}

}
