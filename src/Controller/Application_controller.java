/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Deck;
import Model.User;
import View.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Anthony
 */
public class Application_controller {
    
    private User user = new User();
    
    public void getMainFrame()
    {
        new Home().setVisible(true);
    }
    
    public void getAddDeckView(JFrame view, User user)
    {
        this.user = user;
        view.dispose();
        new AddDeckView(this.user).setVisible(true);
    }
   
    public void getMenuView(User user, JFrame view)
    {
        this.user = user;
        System.out.println(user);
        view.dispose();
        new MenuView(user).setVisible(true);
    }
    
    public void getMenuView(JFrame view)
    {
        view.dispose();
        new MenuView(this.user).setVisible(true);
    }
    
    public void getDeckListView(JFrame view, User user)
    {
        this.user = user;
        view.dispose();
        new DeckListView(user).setVisible(true);
    }
    
    public User getUser() {
        return this.user;
    }
    
    public void getRegisterView(JFrame view)
    {
        view.dispose();
        new RegisterView().setVisible(true);
    }
    
    public void getUserDecksView(JFrame view, User user)
    {
        view.dispose();
        new UserDecksView(user).setVisible(true);
    }
    
    public void getDeckView(JFrame view, Integer id)
    {
        view.dispose();
        new DeckView(id).setVisible(true);
    }
    
    public void getAddCardView(JFrame view, Deck deck)
    {
        view.dispose();
        new AddFlashcardView(deck).setVisible(true);
    }
    
    public void getEditDeck(JFrame view, Deck deck)
    {
        view.dispose();
        new EditDeckView(deck).setVisible(true);
    }
    
    public void getEditCard(JFrame view, Integer id)
    {
        view.dispose();
        new EditCardView(id).setVisible(true);
    }
    
    public void getStudyView(JFrame view, Integer id, User user)
    {
        view.dispose();
        new StudyView(id, user).setVisible(true);
    }
    
    public void getScoreView(JFrame view, User user)
    {
        view.dispose();
        new ScoreView(user).setVisible(true);
    }
    
    public void getStartStudy(JFrame view, User user, Deck deck, int seconds)
    {
        view.dispose();
        new StartStudyView(user, deck, seconds).setVisible(true);
    }
}
