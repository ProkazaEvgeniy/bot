package bot.repository.search;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import bot.entity.Cocktail;

public interface CocktailSearchRepository extends ElasticsearchRepository<Cocktail, Integer> {

	List<Cocktail> findByRecipeLikeOrDescriptionLike(String recipe, String description);
	
}
