package bot.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import bot.entity.Cocktail;

public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {

}
