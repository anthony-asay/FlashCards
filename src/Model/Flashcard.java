package Model;
// Generated May 25, 2016 7:51:48 AM by Hibernate Tools 4.3.1

public class Flashcard  implements java.io.Serializable {


     private Integer id;
     private Deck deck;
     private String answer;
     private String question;

    public Flashcard() {
    }

    public Flashcard(Deck deck, String answer, String question) {
       this.deck = deck;
       this.answer = answer;
       this.question = question;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Deck getDeck() {
        return this.deck;
    }
    
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }




}


