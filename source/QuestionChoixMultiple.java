public class QuestionChoixMultiple extends Question {
    private String[] propositions;
    private String bonneReponse;

    /**
     * Constructeur de la classe QuestionChoixMultiple
     *
     * @param pays : Le pays de la question
     * @param ville : La capitale du pays de la question
     * @param propositions : Les propositions de r�ponses
     */
    public QuestionChoixMultiple(String pays, String ville, String[] propositions) {
        super(pays, ville);
        this.propositions = propositions;
        this.bonneReponse = ville;
    }

    /**
     * Permet de retourner les propositions de r�ponses
     *
     * @return : les propositions de r�ponses
     */
    @Override
    public String getPays() {
        System.out.println(super.getPays() + " : ");
        String propo = "";
        for (int i = 0; i < propositions.length; i++) {
            propo += propositions[i] + " ";
        }
        return propo;
    }

    /**
     * Permet de retourner l'index de la bonne r�ponse
     *
     * @return : l'index de la bonne r�ponse
     */
    @Override
    public String getVille() {
        return bonneReponse;
    }


}
