//Utiliser l'agrégation pour créer une classe CapitalesDuMonde qui contient un ensemble de questions pour le quiz.

import java.util.List;

public class CapitalDuMonde {
    private List<Question> questions;
    private List<QuestionChoixMultiple> questionsChoixMultiple;

    public CapitalDuMonde(List<Question> questions, List<QuestionChoixMultiple> questionsChoixMultiple) {
        this.questions = questions;
        this.questionsChoixMultiple = questionsChoixMultiple;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<QuestionChoixMultiple> getQuestionsChoixMultiple() {
        return questionsChoixMultiple;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setQuestionsChoixMultiple(List<QuestionChoixMultiple> questionsChoixMultiple) {
        this.questionsChoixMultiple = questionsChoixMultiple;
    }
}
