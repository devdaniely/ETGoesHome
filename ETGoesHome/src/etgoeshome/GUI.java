package etgoeshome;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Daniel
 */
public class GUI extends javax.swing.JFrame implements Observer {

   //Reference to the logic class
   protected final Logic logic;

   /**
    * Creates new form GUI
    */
   public GUI(final Logic logicRef) {
      initComponents();
      this.logic = logicRef;
      this.logic.addObserver(this);
      this.getRootPane().setDefaultButton(btnLogin);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      labelMain = new javax.swing.JLabel();
      tabPane = new javax.swing.JTabbedPane();
      tab1 = new javax.swing.JPanel();
      btnGetData = new javax.swing.JButton();
      tab2 = new javax.swing.JPanel();
      txtLogin = new javax.swing.JTextField();
      txtPassword = new javax.swing.JPasswordField();
      btnLogin = new javax.swing.JButton();
      lblUser = new javax.swing.JLabel();
      lblPw = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("ET Goes Home");
      setMinimumSize(new java.awt.Dimension(700, 600));

      labelMain.setText("Main Frame");

      btnGetData.setText("Get Data");

      javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
      tab1.setLayout(tab1Layout);
      tab1Layout.setHorizontalGroup(
         tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(tab1Layout.createSequentialGroup()
            .addGap(208, 208, 208)
            .addComponent(btnGetData)
            .addContainerGap(319, Short.MAX_VALUE))
      );
      tab1Layout.setVerticalGroup(
         tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(tab1Layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(btnGetData)
            .addContainerGap(350, Short.MAX_VALUE))
      );

      tabPane.addTab("tab1", tab1);

      javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
      tab2.setLayout(tab2Layout);
      tab2Layout.setHorizontalGroup(
         tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 602, Short.MAX_VALUE)
      );
      tab2Layout.setVerticalGroup(
         tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 395, Short.MAX_VALUE)
      );

      tabPane.addTab("tab2", tab2);

      btnLogin.setText("Login");
      btnLogin.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoginActionPerformed(evt);
         }
      });

      lblUser.setText("User:");

      lblPw.setText("Pass:");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(labelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGap(18, 18, 18)
                  .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(44, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblUser))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(lblPw))
            .addGap(11, 11, 11)
            .addComponent(labelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(64, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

      String pw = txtPassword.getText();

      if (pw.equals("") || logic.login(txtLogin.getText(), pw) == false)
      {
         btnLogin.setEnabled(true);
      }
      else
      {
         btnLogin.setEnabled(false);
      }
      txtPassword.setText("");
   }//GEN-LAST:event_btnLoginActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(final Logic logicRef) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Windows".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new GUI(logicRef).setVisible(true);
         }
      });
   }

   @Override
   public void update(Observable o, Object arg) {
      System.out.println(arg.toString());
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnGetData;
   private javax.swing.JButton btnLogin;
   private javax.swing.JLabel labelMain;
   private javax.swing.JLabel lblPw;
   private javax.swing.JLabel lblUser;
   private javax.swing.JPanel tab1;
   private javax.swing.JPanel tab2;
   private javax.swing.JTabbedPane tabPane;
   private javax.swing.JTextField txtLogin;
   private javax.swing.JPasswordField txtPassword;
   // End of variables declaration//GEN-END:variables
}
