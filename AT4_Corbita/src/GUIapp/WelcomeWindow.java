// C H A N G E S

/* Changes in the Welcome Window
I added four new buttons:

Add Student – To add a new student.
Delete Student – To remove a student.
Update Student – To change student details.
Logout – To exit the system. */

/* These buttons make it easy to manage students. They give users quick access to each function.
--------------------------------------------------------------------------------------------------*/

/* Separate Windows for Each Feature
Each button opens a new window for that feature:

Add Student Window – Lets users add student details.
Delete Student Window – Helps remove a student from the system.
Update Student Window – Allows changes to a student’s details.
Logout – Closes the program to keep it secure. */

/* Having separate windows makes the system easier to use and understand.
Each part works on its own, so there are fewer errors.
----------------------------------------------------------------------------------------------------*/

//Navigation Controls

/*Each window has a Back button (except Logout) to return to the Welcome Window.
This helps users move around the system easily. They won’t get stuck in one place.
-----------------------------------------------------------------------------------------------------*/



package GUIapp;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WelcomeWindow extends javax.swing.JFrame {

    /**
     * Creates new form AddStudent
     */
    public WelcomeWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lgout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 76, 115, 33));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete Student");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 136, 136, 33));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 76, -1, 33));

        lgout.setBackground(new java.awt.Color(204, 0, 0));
        lgout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lgout.setForeground(new java.awt.Color(0, 0, 0));
        lgout.setText("Logout");
        lgout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgoutActionPerformed(evt);
            }
        });
        jPanel1.add(lgout, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 228, 80, 34));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("STXihei", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 19, -1, 28));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose(); 
        new AddStudent().setVisible(true);         
    }//GEN-LAST:event_jButton1ActionPerformed
// THIS FUNCTION WILL GO TO ADD STUDENT FEATURE
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        this.dispose(); 
        new UpdateStudent().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
// THIS FUNCTION WILL GO TO UPDATE STUDENT FEATURE
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose(); 
        new DeleteStudent().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
// THIS FUNCTION WILL GO TO DELETE STUDENT FEATURE
    
   

    private void lgoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgoutActionPerformed
        JOptionPane.showMessageDialog(this, "Logout successful!");
        new LoginPage().setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_lgoutActionPerformed
 //THIS FUNCTION WILL GO BACK TO THE LOGIN PAGE BECAUSE YOU LOGGED OUT
    
    
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lgout;
    // End of variables declaration//GEN-END:variables
}

 

