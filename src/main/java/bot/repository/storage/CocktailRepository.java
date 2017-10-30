package bot.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bot.entity.Cocktail;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {

}
