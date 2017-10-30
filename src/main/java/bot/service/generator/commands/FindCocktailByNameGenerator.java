package bot.service.generator.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.service.answer.FindCocktailByNameAnswer;
import bot.service.generator.impl.AnswerGeneratorImpl;
import bot.session.Session;

public class FindCocktailByNameGenerator extends AnswerGeneratorImpl {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FindCocktailByNameGenerator.class);

	public FindCocktailByNameGenerator(Session session) {
		session.setFindCocktailByNameAnswer(new FindCocktailByNameAnswer());
		LOGGER.info("FindCocktailByNameAnswer instance");
	}

}
