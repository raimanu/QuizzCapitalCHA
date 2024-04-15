import java.util.ArrayList;
import java.util.List;

public class StartGame {
/**
 * La fonction main est le point d'entrée du programme, elle est unique, lancée au début et obligatoire
 * @param args : arguments passés lors de l'appel depuis une invite de commandes
 */
	public static void main(String[] args) {
		Question question1 = new Question("France", "Paris");
		Question question2 = new Question("Allemagne", "Berlin");
		List<Question> questions = new ArrayList<Question>();
		questions.add(question1);
		questions.add(question2);
		QuestionChoixMultiple question3 = new QuestionChoixMultiple("Italie", "Rome", new String[]{"Milan", "Rome", "Naples", "Turin"});
		QuestionChoixMultiple question4 = new QuestionChoixMultiple("Espagne", "Madrid", new String[]{"Barcelone", "Madrid", "Valence", "Séville"});
		QuestionChoixMultiple question5 = new QuestionChoixMultiple("Suisse", "Berne", new String[]{"Zurich", "Berne", "Genève", "Lausanne"});
		List<QuestionChoixMultiple> questionsChoixMultiple = new ArrayList<QuestionChoixMultiple>();
		questionsChoixMultiple.add(question3);
		questionsChoixMultiple.add(question4);
		questionsChoixMultiple.add(question5);
		Quizz quizz = new Quizz(questions, questionsChoixMultiple);
		ConsoleQuizz2 Consolequizz = new ConsoleQuizz2(quizz.getCapitalDuMonde());
		Consolequizz.start();
		Consolequizz.displayResultats();
	}
}
