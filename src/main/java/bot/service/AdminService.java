package bot.service;

import java.util.List;

import javax.annotation.Nonnull;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import bot.entity.Cocktail;

public interface AdminService {

	@Nonnull SendMessage answerBot(Message message, String text);
	
	@Nonnull List<Cocktail> findByRecipe(String text);
	
	@Nonnull Iterable<Cocktail> findAllForIndexing();
	
	@Nonnull List<Cocktail> findBySearchQuery(@Nonnull String query);
}
