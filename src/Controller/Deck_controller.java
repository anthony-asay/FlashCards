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
import Model.User;
import java.io.IOException;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
import java.util.logging.Level;
import java.util.logging.Logger;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Deck_controller {
   private static SessionFactory factory;
   private static JSONclass json = new JSONclass();
   
   public Integer addDeck(User user, String name){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer itemID = null;
      try{
         tx = session.beginTransaction();
         Deck deck = new Deck(user, name);
         itemID = (Integer) session.save(deck); 
         tx.commit();
          try {
              json.AddItemJSON();
          } catch (IOException ex) {
              Logger.getLogger(Deck_controller.class.getName()).log(Level.SEVERE, null, ex);
          }
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return itemID;
   }
//   
//   public void listItems( ){
//      Session session = HibernateUtil.getSessionFactory().openSession();
//      Transaction tx = null;
//      try{
//         tx = session.beginTransaction();
//         List items = session.createQuery("FROM Item").list(); 
//         for (Iterator iterator = 
//                    items.iterator(); iterator.hasNext();){
//            Item item = (Item) iterator.next(); 
//            System.out.println("Title: " + item.getTitle()); 
//            System.out.println("Medium: " + item.getMedium().getTypeMedium()); 
//            System.out.println("Date Released: " + item.getDateReleased()); 
//         }
//         tx.commit();
//      }catch (HibernateException e) {
//         if (tx!=null) tx.rollback();
//         e.printStackTrace(); 
//      }finally {
//         session.close(); 
//      }
//   }
//   
   public List<Deck> getItems()
    {
        Deck item = new Deck();
        List<Deck> list = item.decks();
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
