/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Controller.HibernateUtil;
import Model.User;
import java.util.Date;

 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class User_controller {
   private User model = new User();
   private static SessionFactory factory;
   private static JSONclass json = new JSONclass();
   
   public Integer addUser(String nameUser, String password, String email){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer userID = null;
      try{
         tx = session.beginTransaction();
         User user = new User(nameUser, password, new Date(), email);
         userID = (Integer) session.save(user); 
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
      return userID;
   }
   
   public boolean updateUser(Integer userId, String nameUser, String password, String email){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         User user = 
                    (User)session.get(User.class, userId); 
         user.setNameUser(nameUser);
         user.setEmail(email);
         user.setPassword(password);
		 session.update(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return true;
   }
   
   public boolean deleteUser(Integer userId){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         User user = 
                   (User)session.get(User.class, userId); 
         session.delete(user); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return true;
   }
   
   public User getUser(Integer id)
   {
       User user = model.getUserById(id);
       return user;
   }
   
   public Integer authenticate(String name, String password)
   {
       Integer id = 0;
       id = model.getUserByNameAndPassword(name, password);
       return id;
   }
}
