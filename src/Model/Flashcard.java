package Model;
// Generated May 25, 2016 7:51:48 AM by Hibernate Tools 4.3.1

import Controller.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class Flashcard  implements java.io.Serializable {


     private Integer id;
     private Deck deck;
     private String answer;
     private String question;

    
    @Override
    public String toString()
    {
        return "{\"id\":\""+this.id+"\",\"id_deck\":\""+this.deck.getId()+"\",\"answer\":\""+this.answer+"\",\"question\":\""+this.question+"\"}";
    }
    
    public Flashcard()
    {
        
    }

    public Flashcard(Deck deck, String answer, String question) {
       this.deck = deck;
       this.answer = answer;
       this.question = question;
    }
    
    public List<Flashcard> cards() {
        String query = "from Flashcard";
        List<Flashcard> list = executeHQLQuery(query);
        return list;
    }
    
    private List executeHQLQuery(String hql) 
    {
        try 
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } 
        catch (HibernateException he) 
        {
            he.printStackTrace();
        }
        return null;
    }
    
    public Flashcard getCard(Integer id)
    {
        String query = "from Flashcard where id="+id;
        List<Flashcard> list = executeHQLQuery(query);
        return list.get(0);
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


