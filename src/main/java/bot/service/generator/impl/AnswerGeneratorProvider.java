package bot.service.generator.impl;

import bot.service.generator.AnswerGenerator;
import bot.service.generator.commands.AddGenerator;
import bot.service.generator.commands.CancelGenerator;
import bot.service.generator.commands.DivideGenerator;
import bot.service.generator.commands.EditGenerator;
import bot.service.generator.commands.FindAllCocktailGenerator;
import bot.service.generator.commands.FindByRecipeGenerator;
import bot.service.generator.commands.FindCocktailByNameGenerator;
import bot.service.generator.commands.FindUserbotByIDGenerator;
import bot.service.generator.commands.HelpGenerator;
import bot.service.generator.commands.SaveCocktailGenerator;
import bot.session.Session;

public class AnswerGeneratorProvider {

	public AnswerGeneratorProvider() {
		super();
	}

	public static AnswerGenerator getAnswerGeneratorFor(Session session, String type) {
		switch (type.toLowerCase()) {
		case "add":
			return new AddGenerator(session);
		case "help":
			return new HelpGenerator(session);
		case "div":
			return new DivideGenerator(session);
		case "finduserbotbyid":
			return new FindUserbotByIDGenerator(session);
		case "savecocktail":
			return new SaveCocktailGenerator(session);
		case "findcocktailbyname":
			return new FindCocktailByNameGenerator(session);
		case "findallcocktail":
			return new FindAllCocktailGenerator(session);
		case "edit":
			return new EditGenerator(session);
		case "cancel":
			return new CancelGenerator(session);
		case "findbyrecipe":
			return new FindByRecipeGenerator(session);
		default:
			return null;
		}

	}

}
