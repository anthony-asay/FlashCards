/*
 * To change this license header, choose License Headers in Project Properties.
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.HibernateUtil;
import Model.Deck;
import Model.Flashcard;
import java.math.BigDecimal;
import Controller.JSONclass;
import java.io.IOException;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Flashcard_controller {
   private static SessionFactory factory;
   private static JSONclass json = new JSONclass();
   
   public Integer addCard(Deck deck, String answer, String question){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer cardID = null;
      try{
         tx = session.beginTransaction();
         Flashcard card = new Flashcard(deck, answer, question);
         cardID = (Integer) session.save(card); 
         tx.commit();
//          try {
//              json.AddItemJSON();
//          } catch (IOException ex) {
//              Logger.getLogger(Item_controller.class.getName()).log(Level.SEVERE, null, ex);
//          }
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return cardID;
   }
//   
  
   public List<Flashcard> getCards()
    {
        Flashcard item = new Flashcard();
        List<Flashcard> list = item.cards();
        return list;
    }
//   
   public void updateCard(Integer cardId, String answer, String question){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Flashcard card = 
                    (Flashcard)session.get(Flashcard.class, cardId); 
         card.setAnswer(answer);
         card.setQuestion(question);
		 session.update(card); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
//   
   public void deleteCard(Integer cardId){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Flashcard card = 
                   (Flashcard)session.get(Flashcard.class, cardId); 
         session.delete(card); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
