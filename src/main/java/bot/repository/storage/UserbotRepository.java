package bot.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bot.entity.Userbot;

@Repository
public interface UserbotRepository extends JpaRepository<Userbot, Integer> {

}
