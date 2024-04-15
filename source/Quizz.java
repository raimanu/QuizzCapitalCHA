import java.util.List;

//Utiliser la composition pour créer une classe Quiz qui contient une liste de questions
public class Quizz {
    private CapitalDuMonde capitalDuMonde;

    public Quizz(List<Question> questions, List<QuestionChoixMultiple> questionsChoixMultiple) {
        this.capitalDuMonde = new CapitalDuMonde(questions, questionsChoixMultiple);
    }

    public void setCapitalDuMonde(CapitalDuMonde capitalDuMonde) {
        this.capitalDuMonde = capitalDuMonde;
    }

    public CapitalDuMonde getCapitalDuMonde() {
        return capitalDuMonde;
    }
}
