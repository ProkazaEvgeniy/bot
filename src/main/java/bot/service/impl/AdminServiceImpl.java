package bot.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import bot.entity.Cocktail;
import bot.repository.search.CocktailSearchRepository;
import bot.repository.storage.CocktailRepository;
import bot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private final static Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private CocktailSearchRepository cocktailSearchRepository;
	
	@Autowired
	private CocktailRepository cocktailRepository;
	
	public AdminServiceImpl() {
		super();
		LOGGER.info("************ AdminServiceImpl created ************");
	}
	
	@PostConstruct
	private void init() {
		LOGGER.info("------------------------------------------------------------->>>>>>>>>"+cocktailSearchRepository);
	}

	@Override
	public SendMessage answerBot(Message message, String text) {
		LOGGER.info("---> SendMessage answerBot " + text);
		 return new SendMessage().setChatId(message.getChatId()).setText(text);
	}

	@Override
	public List<Cocktail> findByRecipe(String text) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.multiMatchQuery(text)
						.field("recipe")
						.field("description")
						.type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
						.fuzziness(Fuzziness.AUTO)
						.operator(MatchQueryBuilder.Operator.OR))
				.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
				.build();
		return cocktailSearchRepository.search(searchQuery).getContent();
	}
	
	@Override
	@Transactional
	public Iterable<Cocktail> findAllForIndexing() {
		Iterable<Cocktail> all = cocktailRepository.findAll();
		return all;
	}

	@Override
	@Transactional
	public List<Cocktail> findBySearchQuery(String query) {
		List<Cocktail> cocktails = cocktailSearchRepository.findByRecipeLikeOrDescriptionLike(query, query);
		LOGGER.info("cocktails = " + cocktails.toString());
		return cocktails;
	}

	
}
