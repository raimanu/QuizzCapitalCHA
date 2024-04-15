import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ConsoleQuizz {
	private int score;
	private long timeElapsed;
	private boolean done = false;
	private int nbreQuestion;
	Scanner clavier = new Scanner(System.in);

	/**
	 * Constructeur de la classe ConsoleQuizz
	 * 
	 * @param nbreQuestion : Le nombre de questions � poser au joueur
	 */
	public ConsoleQuizz(int nbreQuestion) {
		this.nbreQuestion = nbreQuestion;
	}

	/**
	 * Coeur du quizz, pose les questions, v�rifie les r�ponses et compte le score
	 */
	public void start() {
		String userAnswer;
		try {
			long startTime = System.currentTimeMillis();
			ArrayList<Question> questions = generate(nbreQuestion);
			for (int i = 0; i < nbreQuestion; i++) {
				System.out.println(questions.get(i).getPays());
				userAnswer = clavier.nextLine();

				if (userAnswer.equalsIgnoreCase(questions.get(i).getVille())) {
					score++;
					System.out.println("Bonne Reponse");
				} else {
					System.out.println("Mauvaise Reponse");
					System.out.println("la bonne reponse etait: " + questions.get(i).getVille());
				}
			}
			done = true;
			long endTime = System.currentTimeMillis();
			timeElapsed = endTime - startTime;
		} catch (IllegalArgumentException e) {
			done = false;
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Permet de convertir le temps de milliseconde � seconde
	 * 
	 * @param timeInMilliSeconds : temps en milliseconde
	 * @return : temps en seconde
	 */
	private int getTimeElapsedInSeconds(long timeInMilliSeconds) {
		return (int) (timeInMilliSeconds / 1000);
	}

	/**
	 * Affiche le r�sultat au joueur, un message d'erreur sinon
	 */
	public void displayResultats() {
		if (done) {
			displayScore();
			displayTimeElapsed();
		} else {
			System.out.println("Vous n'avez rien r�pondu");
		}
	}

	/**
	 * Affiche le temps utilis� par le joueur pour r�pondre aux questions
	 */
	private void displayTimeElapsed() {
		System.out.printf("Il vous a fallu environ %d secondes pour repondre aux %d questions",
				getTimeElapsedInSeconds(timeElapsed), nbreQuestion);
	}

	/**
	 * Affiche le score final
	 */
	private void displayScore() {
		System.out.printf("votre score final est de: %d/%d\n ", score, nbreQuestion);

	}

	/**
	 * Permet de cr�er un tableau de x questions-r�ponses, x �tant choisit au lancement du jeu
	 * @param nbreQuestions : nombre de question choisit au lancement du jeu
	 * @return : un tableau de questions
	 */
	public ArrayList<Question> generate(int nbreQuestions) {
		String[][] data = getData();
		int index = 0;
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<Integer>();

		if (nbreQuestions > data.length) {
			throw new IllegalArgumentException("On ne peut generer que: " + data.length + " questions maximun");
		}
		indexesAlreadyTaken.clear();

		for (int i = 0; i < nbreQuestions; i++) {
			do {
				Random random = new Random();
				index = random.nextInt(data.length);
			} while (indexesAlreadyTaken.contains(index));
			indexesAlreadyTaken.add(index);
			String pays = data[index][0];
			String capitale = data[index][1];
			String questionText = String.format("Quelle est la capitale de ce pays: %s? ", pays);
			questions.add(new Question(questionText, capitale));
		}
		return questions;
	}

	/**
	 * Base de donn�es non persistantes
	 * 
	 * @return un tableau � deux dimensions contenant les couples pays-capitale au format brut
	 */
	private static String[][] getData() {
		String[][] data = { { "Senegal", "Dakar" }, { "France", "Paris" }, { "Haiti", "Paup" },
				{ "Argemtine", "Brenos.A" }, { "Brasil", "brasilia" }, { "Itali", "Rome" }, { "Perou", "Lima" },
				{ "Allemagne", "Berlin" }, { "Canada", "Otawa" } };
		return data;
	}

}
