import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleQuizz2 {
    private int score;
    private long timeElapsed;
    private boolean done = false;
    Scanner clavier = new Scanner(System.in);
    private CapitalDuMonde capitalDuMonde;

    /**
     * Constructeur de la classe ConsoleQuizz
     *
     */
    public ConsoleQuizz2(CapitalDuMonde capitalDuMonde) {
        this.capitalDuMonde = capitalDuMonde;
    }

    /**
     * Coeur du quizz, pose les questions, vérifie les réponses et compte le score
     */
    public void start() {
        String userAnswer;
        try {
            long startTime = System.currentTimeMillis();
            ArrayList<Question> questions = (ArrayList<Question>) capitalDuMonde.getQuestions();
            ArrayList<QuestionChoixMultiple> questionsChoixMultiple = (ArrayList<QuestionChoixMultiple>) capitalDuMonde.getQuestionsChoixMultiple();
            for (int i = 0; i < questions.size(); i++) {
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
            for (int i = 0; i < questionsChoixMultiple.size(); i++) {
                System.out.println(questionsChoixMultiple.get(i).getPays());
                userAnswer = clavier.nextLine();
                if (userAnswer.equalsIgnoreCase(questionsChoixMultiple.get(i).getVille())) {
                    score++;
                    System.out.println("Bonne Reponse");
                } else {
                    System.out.println("Mauvaise Reponse");
                    System.out.println("la bonne reponse etait: " + questionsChoixMultiple.get(i).getVille());
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
     * Permet de convertir le temps de milliseconde à seconde
     *
     * @param timeInMilliSeconds : temps en milliseconde
     * @return : temps en seconde
     */
    private int getTimeElapsedInSeconds(long timeInMilliSeconds) {
        return (int) (timeInMilliSeconds / 1000);
    }

    public int getScore() {
        return score;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void displayResultats() {
        System.out.println("Votre score est de " + score + "/" + (capitalDuMonde.getQuestions().size() + capitalDuMonde.getQuestionsChoixMultiple().size()));
        System.out.println("Vous avez mis " + getTimeElapsedInSeconds(timeElapsed) + " secondes pour répondre à toutes les questions");
    }
}