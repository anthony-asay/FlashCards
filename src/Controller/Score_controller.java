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
import Model.Score;
import Model.User;
import java.io.IOException;
import java.util.List; 
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator; 
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Score_controller {
   private static SessionFactory factory;
   private static JSONclass json = new JSONclass();
   
   public Integer addScore(Deck deck, User user, Float score){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer scoreID = null;
      try{
         tx = session.beginTransaction();
         Score scoreItem = new Score(deck, user, score, new Date());
         scoreID = (Integer) session.save(scoreItem); 
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
      return scoreID;
   }

//   
   public List<Score> getScoresByUser(User user)
    {
        Score score = new Score();
        List<Score> list = score.scores(user);
        return list;
    }
//   
//   public void updateItem(Integer itemId, Medium medium, Date dateReleased, String title, Double rating, String synopsis){
//      Session session = HibernateUtil.getSessionFactory().openSession();
//      Transaction tx = null;
//      try{
//         tx = session.beginTransaction();
//         Item item = 
//                    (Item)session.get(Item.class, itemId); 
//         item.setMedium(medium);
//         item.setDateReleased(dateReleased);
//         item.setTitle(title);
//         item.setRating(rating);
//         item.setSynopsis(synopsis);
//		 session.update(item); 
//         tx.commit();
//      }catch (HibernateException e) {
//         if (tx!=null) tx.rollback();
//         e.printStackTrace(); 
//      }finally {
//         session.close(); 
//      }
//   }
//   
//   public void deleteItem(Integer itemId){
//      Session session = HibernateUtil.getSessionFactory().openSession();
//      Transaction tx = null;
//      try{
//         tx = session.beginTransaction();
//         Item item = 
//                   (Item)session.get(Item.class, itemId); 
//         session.delete(item); 
//         tx.commit();
//      }catch (HibernateException e) {
//         if (tx!=null) tx.rollback();
//         e.printStackTrace(); 
//      }finally {
//         session.close(); 
//      }
//   }
}
