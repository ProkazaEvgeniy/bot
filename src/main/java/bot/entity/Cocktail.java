package bot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;
import org.telegram.telegrambots.api.objects.Message;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bot.properties.BotProperties;
import bot.session.Session;


@Entity
@Table(name = "cocktail")
@Document(indexName = "cocktail")
public class Cocktail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COCKTAIL_ID_GENERATOR", sequenceName="cocktail_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COCKTAIL_ID_GENERATOR")
	private Integer id;

	@Column(name="idt_userbot")
	@JsonIgnore
	private Integer idtUserbot;

	@JsonIgnore
	private String name;

	private String recipe;

	private String description;

	public Cocktail() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdtUserbot() {
		return this.idtUserbot;
	}

	public void setIdtUserbot(Integer idtUserbot) {
		this.idtUserbot = idtUserbot;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecipe() {
		return this.recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "@cocktailbestbot" 
				+ (name != null ? "\n" + "Название:" + "\n" + "\t\t" + name + ", " : "")
				+ (recipe != null ? "\n" + "Рецепт:" + "\n" + "\t\t" + recipe : "")
				+ (description != null ? "\n" + "Описание:" + "\n" + "\t\t" + description + ", " : "");
	}

	public String toStringAdmin(Message message, Session session) {
		if (message.getFrom().getId().equals(Integer.parseInt(BotProperties.ID_ADMIN))) {
			session.getArgumentUser().setId_cocktail(id);
			return String.format("@cocktailbestbot You Administation"
		+"\n" + "Название:" + "\n"+" %s" 
		+"\n" + "Рецепт:" + "\n"+" %s"
		+"\n" + "Описание:" + "\n"+" %s"
		+"\n\n" + "/edit" + "  - изменить %s" 
		+"\n" + "/delete" + "  - удалить %s"
		+"\n" + "/cancel" + "  - отмена", 
		name, recipe, description, name, name);
		} else {
			return "@cocktailbestbot" 
					+ (name != null ? "\n" + "Название:" + "\n" + "\t\t" + name : "")
					+ (recipe != null ? "\n" + "Рецепт:" + "\n" + "\t\t" + recipe : "")
					+ (description != null ? "\n" + "Описание:" + "\n" + "\t\t" + description : "");
		}
	}
}