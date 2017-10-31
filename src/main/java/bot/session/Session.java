package bot.session;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;

import bot.entity.Cocktail;
import bot.model.ArgumentUser;
import bot.service.AdminService;
import bot.service.answer.AddAnswer;
import bot.service.answer.CancelAnswer;
import bot.service.answer.DivideAnswer;
import bot.service.answer.EditAnswer;
import bot.service.answer.FindAllCocktailAnswer;
import bot.service.answer.FindByRecipeAnswer;
import bot.service.answer.FindCocktailByNameAnswer;
import bot.service.answer.FindUserbotByIDAnswer;
import bot.service.answer.HelpAnswer;
import bot.service.answer.RepeatArgument;
import bot.service.answer.RepeatArgumentStop;
import bot.service.answer.SaveCocktailAnswer;
import bot.service.generator.AnswerGenerator;

@Component
@Scope("prototype")
public class Session {

	private final static Logger LOGGER = LoggerFactory.getLogger(Session.class);

	@Autowired
	private AdminService adminService;

	private AnswerGenerator answerGenerator;
	private AddAnswer addAnswer;
	private DivideAnswer divideAnswer;
	private HelpAnswer helpAnswer;
	private RepeatArgument repeatArgument;
	private RepeatArgumentStop repeatArgumentStop;
	private FindUserbotByIDAnswer findUserbotByIDAnswer;
	private FindCocktailByNameAnswer findCocktailByNameAnswer;
	private FindAllCocktailAnswer findAllCocktailAnswer;
	private FindByRecipeAnswer findByRecipeAnswer;
	private SaveCocktailAnswer saveCocktailAnswer;
	private EditAnswer editAnswer;
	private CancelAnswer cancelAnswer;

	private ArgumentUser argumentUser;

	public Session() {
		super();
		LOGGER.info("************ Session created ************");
	}

	// service
	
	public SendMessage answer(Message message, String text) {
		return adminService.answerBot(message, text);
	}
	
	public String findByRecipe(String text){
		List<Cocktail> cocktails = adminService.findByRecipe(text);
		String answerText = cocktails.get(0).toString();
		return answerText;
	}
	
	public String findBySearchQuery(String text){
		List<Cocktail> cocktails = adminService.findBySearchQuery(text);
		String answerText = cocktails.get(0).toString();
		return answerText;
	}
	
	// end service

	// set Null
	
	public void setFindByRecipeAnswerNull(){
		findByRecipeAnswer = null;
		LOGGER.info("findByRecipeAnswer = null");
	}

	public void setRepeatArgumentNull() {
		repeatArgument = null;
		LOGGER.info("repeatArgument = null");
	}

	public void setRepeatArgumentStopNull() {
		repeatArgumentStop = null;
		LOGGER.info("repeatArgumentStop = null");
	}

	public void setRepeatArgumentAndAddAnswerNull() {
		addAnswer = null;
		LOGGER.info("addAnswer = null");
		repeatArgument = null;
		LOGGER.info("repeatArgument = null");
	}

	public void setRepeatArgumentAndSaveCocktailAnswerNull() {
		saveCocktailAnswer = null;
		LOGGER.info("saveCocktailAnswer = null");
		repeatArgument = null;
		LOGGER.info("repeatArgument = null");
	}

	public void setFindUserbotByIDAnswerAndAnswerGeneratorNull() {
		answerGenerator = null;
		LOGGER.info("answerGenerator = null");
		findUserbotByIDAnswer = null;
		LOGGER.info("findUserbotByIDAnswer = null");
	}

	public void setFindCocktailByNameAnswerAndAnswerGeneratorNull() {
		answerGenerator = null;
		LOGGER.info("answerGenerator = null");
		findCocktailByNameAnswer = null;
		LOGGER.info("findCocktailByNameAnswer = null");
	}

	public void setFindAllCocktailAnswerAndAnswerGeneratorNull() {
		answerGenerator = null;
		LOGGER.info("answerGenerator = null");
		findAllCocktailAnswer = null;
		LOGGER.info("findAllCocktailAnswer = null");
		argumentUser.setCocktails(new ArrayList<>());
		LOGGER.info("argumentUser setCocktails new ArrayList<>() instance");
	}

	public void setCocktailsListNewArrayListAndOffsetDefault() {
		argumentUser.setCocktails(new ArrayList<>());
		LOGGER.info("argumentUser setCocktails new ArrayList<>() instance");
		argumentUser.setOffset(-1);
	}

	public void setSaveCocktailAnswerAndAnswerGeneratorNull() {
		answerGenerator = null;
		LOGGER.info("answerGenerator = null");
		saveCocktailAnswer = null;
		LOGGER.info("saveCocktailAnswer = null");
	}

	public void setEditAnswerNull() {
		editAnswer = null;
		LOGGER.info("editAnswer = null");
	}

	public void setCancelAnswerNull() {
		cancelAnswer = null;
		LOGGER.info("cancelAnswer = null");
	}

	public void setAnswerGeneratorNull() {
		answerGenerator = null;
		LOGGER.info("answerGenerator = null");
	}

	//end set Null
	
	// has

	public boolean hasFindByRecipeAnswer(){
		return findByRecipeAnswer != null;
	}
	
	public boolean hasAnswerGenerator() {
		return answerGenerator != null;
	}

	public boolean hasAddAnswer() {
		return addAnswer != null;
	}

	public boolean hasHelpAnswer() {
		return helpAnswer != null;
	}

	public boolean hasDivideAnswer() {
		return divideAnswer != null;
	}

	public boolean hasRepeatArgument() {
		return repeatArgument != null;
	}

	public boolean hasRepeatArgumentStop() {
		return repeatArgumentStop != null;
	}

	public boolean hasFindUserbotByIDAnswer() {
		return findUserbotByIDAnswer != null;
	}

	public boolean hasFindCocktailByNameAnswer() {
		return findCocktailByNameAnswer != null;
	}

	public boolean hasFindAllCocktailAnswer() {
		return findAllCocktailAnswer != null;
	}

	public boolean hasSaveCocktailAnswer() {
		return saveCocktailAnswer != null;
	}

	public boolean hasEditAnswer() {
		return editAnswer != null;
	}

	public boolean hasCancelAnswer() {
		return cancelAnswer != null;
	}
	
	// end has

	// set generator

	public void setFindByRecipeAnswer(FindByRecipeAnswer findByRecipeAnswer){
		this.findByRecipeAnswer = findByRecipeAnswer;
		LOGGER.info("setFindByRecipeAnswer");
	}
	
	public void setAnswerGenerator(AnswerGenerator answerGenerator) {
		this.answerGenerator = answerGenerator;
		LOGGER.info("setAnswerGenerator");
	}

	public void setAddAnswer(AddAnswer addAnswer) {
		this.addAnswer = addAnswer;
		LOGGER.info("setAddAnswer");
	}

	public void setHelpAnswer(HelpAnswer helpAnswer) {
		this.helpAnswer = helpAnswer;
		LOGGER.info("setHelpAnswer");
	}

	public void setDivideAnswer(DivideAnswer divideAnswer) {
		this.divideAnswer = divideAnswer;
		LOGGER.info("setDivideAnswer");
	}

	public void setFindUserbotByIDAnswer(FindUserbotByIDAnswer findUserbotByIDAnswer) {
		this.findUserbotByIDAnswer = findUserbotByIDAnswer;
		LOGGER.info("setFindUserbotByIDAnswer");
	}

	public void setFindCocktailByNameAnswer(FindCocktailByNameAnswer findCocktailByNameAnswer) {
		this.findCocktailByNameAnswer = findCocktailByNameAnswer;
		LOGGER.info("setFindCocktailByNameAnswer");
	}

	public void setFindAllCocktailAnswer(FindAllCocktailAnswer findAllCocktailAnswer) {
		this.findAllCocktailAnswer = findAllCocktailAnswer;
		LOGGER.info("setFindAllCocktailAnswer");
	}

	public void setRepeatArgument(RepeatArgument repeatArgument) {
		this.repeatArgument = repeatArgument;
		LOGGER.info("setRepeatArgument");
	}

	public void setRepeatArgumentStop(RepeatArgumentStop repeatArgumentStop) {
		this.repeatArgumentStop = repeatArgumentStop;
		LOGGER.info("setRepeatArgumentStop");
	}

	public ArgumentUser getArgumentUser() {
		return argumentUser;
	}

	public void setArgumentUser(ArgumentUser argumentUser) {
		this.argumentUser = argumentUser;
	}

	public void setSaveCocktailAnswer(SaveCocktailAnswer saveCocktailAnswer) {
		this.saveCocktailAnswer = saveCocktailAnswer;
		LOGGER.info("setSaveCocktailAnswer");
	}

	public void setEditAnswer(EditAnswer editAnswer) {
		this.editAnswer = editAnswer;
		LOGGER.info("setEditAnswer");
	}

	public void setCancelAnswer(CancelAnswer cancelAnswer) {
		this.cancelAnswer = cancelAnswer;
		LOGGER.info("setCancelAnswer");
	}
	// end set generator
}
