package bot.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bot.entity.Cocktail;

public class ArgumentUser {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ArgumentUser.class);

	private List<String> arguments = new ArrayList<>();
	private List<Cocktail> cocktails = new ArrayList<>();
	private Integer offset = -1;
	private Integer id_cocktail = null;

	public ArgumentUser() {
		super();
		LOGGER.info("*** ArgumentUser instance in class ArgumentUser ***");
	}

	public List<String> getArguments() {
		return arguments;
	}

	public void setArguments(List<String> numbers) {
		this.arguments = numbers;
	}
	
	public List<Cocktail> getCocktails() {
		return cocktails;
	}

	public void setCocktails(List<Cocktail> cocktails) {
		this.cocktails = cocktails;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	public Integer getOffsetIncrement() {
		return offset++;
	}
	
	public Integer getOffsetDecrement() {
		return offset--;
	}

	public void add(String text) {
		arguments.add(text);
	}

	public Integer getId_cocktail() {
		return id_cocktail;
	}

	public void setId_cocktail(Integer id_cocktail) {
		LOGGER.info("*** setId_cocktail instance in class ArgumentUser *** " + id_cocktail);
		this.id_cocktail = id_cocktail;
	}

	@Override
	public String toString() {
		return String.format("ArgumentUser [arguments=%s, cocktails=%s, offset=%s, id_cocktail=%s]", arguments,
				cocktails, offset, id_cocktail);
	}

	
	
		
}
