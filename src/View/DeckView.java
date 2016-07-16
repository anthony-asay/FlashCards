/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Application_controller;
import Controller.Deck_controller;
import Controller.HibernateUtil;
import Model.Deck;
import Model.Flashcard;
import Model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Anthony
 */
public class DeckView extends javax.swing.JFrame {
    private Application_controller app = new Application_controller();
    private Deck_controller control = new Deck_controller();
    private Deck deck = new Deck();
    public DeckView(Integer id) {
        initComponents();  
        this.deck = deck.getDeck(id);
        jLabel1.setText(deck.getName());
        
        displayResult(deck.getFlashcards());
    }
    
    private void displayResult(Set resultList) 
    {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Id");
        tableHeaders.add("Answer");
        tableHeaders.add("Question");
        tableHeaders.add("Edit");

        for(Object o : resultList) 
        {
            Flashcard item = (Flashcard)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(item.getId());
            oneRow.add(item.getAnswer());
            oneRow.add(item.getQuestion());
          
            oneRow.add("Edit " + item.getId());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders)
        {
            private static final long serialVersionUID = 1L;
            
            public boolean isCellEditable(int row, int column)
            {
                return column == 3;
            }
        });
        resultTable.getColumnModel().getColumn(3).setCellRenderer(new DeckView.ClientsTableButtonRenderer());
        resultTable.getColumnModel().getColumn(3).setCellEditor(new DeckView.ClientsTableRenderer(new JCheckBox(), this));
        resultTable.setPreferredScrollableViewportSize(resultTable.getPreferredSize());
        resultTable.setShowHorizontalLines(true);
        resultTable.setShowVerticalLines(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        editDeck = new javax.swing.JToggleButton();
        deleteDeckButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        addCard = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        editDeck.setText("Edit Deck");
        editDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDeckActionPerformed(evt);
            }
        });

        deleteDeckButton.setText("Delete Deck");
        deleteDeckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDeckButtonActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jLabel2.setText("Flashcards");

        addCard.setText("Add Flashcard");
        addCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardActionPerformed(evt);
            }
        });

        jButton3.setText("Return to Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editDeck)
                            .addComponent(deleteDeckButton)
                            .addComponent(addCard))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCard)
                        .addGap(20, 20, 20)
                        .addComponent(editDeck)
                        .addGap(18, 18, 18)
                        .addComponent(deleteDeckButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        app.getMenuView(deck.getUser(), this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCardActionPerformed
        app.getAddCardView(this, deck);
    }//GEN-LAST:event_addCardActionPerformed

    private void editDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDeckActionPerformed
        app.getEditDeck(this, deck);
    }//GEN-LAST:event_editDeckActionPerformed

    private void deleteDeckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDeckButtonActionPerformed
        control.deleteDeck(deck.getId());
        app.getMenuView(deck.getUser(), this);
    }//GEN-LAST:event_deleteDeckButtonActionPerformed

   class ClientsTableButtonRenderer extends JButton implements TableCellRenderer
  {
    
    public ClientsTableButtonRenderer()
    {
      setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
      setForeground(Color.black);
      setBackground(UIManager.getColor("Button.background"));
      setText((value == null) ? "" : value.toString());
      return this;
    }
  }
  public class ClientsTableRenderer extends DefaultCellEditor
  {
    private JFrame view;
    private JButton button;
    private String label;
    private boolean clicked;
    private int row, col;
    private JTable table;

    public ClientsTableRenderer(JCheckBox checkBox, JFrame view)
    {
      super(checkBox);
      this.view = view;
      button = new JButton();
      button.setOpaque(true);
      button.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          fireEditingStopped();
        }
      });
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
    {
      this.table = table;
      this.row = row;
      this.col = column;

      button.setForeground(Color.black);
      button.setBackground(UIManager.getColor("Button.background"));
      label = (value == null) ? "" : value.toString();
      button.setText(label);
//      button.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectDeck(evt);
//            }
//            });
      clicked = true;
      return button;
    }
    public Object getCellEditorValue()
    {
      if (clicked)
      {
        app.getEditCard(this.view, Integer.parseInt(table.getValueAt(row, 0).toString()));
        //JOptionPane.showMessageDialog(button, "Column with Value: "+table.getValueAt(row, 0) + " -  Clicked!");
      }
      clicked = false;
      return new String(label);
    }

    public boolean stopCellEditing()
    {
      clicked = false;
      return super.stopCellEditing();
    }

    protected void fireEditingStopped()
    {
      super.fireEditingStopped();
    }
  }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCard;
    private javax.swing.JButton deleteDeckButton;
    private javax.swing.JToggleButton editDeck;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
}
