import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GraphiqueQuizz {
	private int score;
	private long timeElapsed;
	private boolean done = false;
	private int nbreQuestions;
	Scanner clavier = new Scanner(System.in);

	/**
	 * Constructeur de la classe ConsoleQuizz
	 * 
	 * @param nbreQuestion : Le nombre de questions � poser au joueur
	 */
	public GraphiqueQuizz(int nbreQuestion) {
		nbreQuestions = nbreQuestion;
	}

	/**
	 * Coeur du quizz, pose les questions, v�rifie les r�ponses et compte le score
	 */
	public void start() {
		String userAnswer;
		try {
			long startTime = System.currentTimeMillis();
			for (Question question : generate(nbreQuestions)) {
				userAnswer = JOptionPane.showInputDialog(null, question.getPays());

				if (userAnswer.equalsIgnoreCase(question.getVille())) {
					score++;
					JOptionPane.showMessageDialog(null, "Bonne Reponse");
				} else {
					JOptionPane.showMessageDialog(null, "Mauvaise Reponse");
					JOptionPane.showMessageDialog(null, "la bonne reponse etait: " + question.getVille());
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
		}
	}

	/**
	 * Affiche le temps utilis� par le joueur pour r�pondre aux questions
	 */
	private void displayTimeElapsed() {
		JOptionPane.showMessageDialog(null,
				String.format("Il vous a fallu environ %d secondes pour repondre aux questions",
						getTimeElapsedInSeconds(timeElapsed), nbreQuestions));

	}

	/**
	 * Affiche le score final
	 */
	private void displayScore() {
		JOptionPane.showMessageDialog(null, String.format("votre score final est de: %d/%d\n ", score, nbreQuestions));

	}
	/**
	 * Permet de cr�er un tableau de x questions-r�ponses, x �tant choisit au lancement du jeu
	 * @param nbreQuestions : nombre de question choisit au lancement du jeu
	 * @return : un tableau de questions
	 */
	public ArrayList<Question> generate(int nbreQuestions) {
		String[][] data = getData();
		ArrayList<Question> questions = new ArrayList<Question>();
		int index;
		ArrayList<Integer> indexesAlreadyTaken = new ArrayList<Integer>();

		if (nbreQuestions > data.length) {
			throw new IllegalArgumentException("On ne peut generer que: " + data.length + " question maximun");
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
	 * Base de donn�es volatiles
	 * 
	 * @return un tableau � deux dimensions contenant les couples pays-capitale
	 */
	private static String[][] getData() {
		String[][] data = { { "Senegal", "Dakar" }, { "France", "Paris" }, { "Haiti", "Paup" },
				{ "Argemtine", "Brenos.A" }, { "Brasil", "brasilia" }, { "Itali", "Rome" }, { "Perou", "Lima" },
				{ "Almagne", "berlin" }, { "Canada", "Otawa" } };
		return data;
	}
}
