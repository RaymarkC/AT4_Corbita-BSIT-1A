
package GUIapp;

import java.io.*;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.File;
import javax.swing.JOptionPane;


/**
 * @author raymark
 */

public class DeleteStudent extends javax.swing.JFrame {

    
    public DeleteStudent() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        clrr = new javax.swing.JButton();
        bck = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Delete Student");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 36, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 115, 195, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 118, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 189, -1, -1));

        clrr.setBackground(new java.awt.Color(0, 0, 0));
        clrr.setForeground(new java.awt.Color(255, 255, 255));
        clrr.setText("Clear");
        clrr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrrActionPerformed(evt);
            }
        });
        jPanel1.add(clrr, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 189, 80, -1));

        bck.setBackground(new java.awt.Color(204, 51, 0));
        bck.setForeground(new java.awt.Color(0, 0, 0));
        bck.setText("Back");
        bck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckActionPerformed(evt);
            }
        });
        jPanel1.add(bck, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 265, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void bckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckActionPerformed
        
        new WelcomeWindow().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bckActionPerformed
//THESE FUNCTION WILL GO BACK TO THE WELCOME WINDOW
    
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String usernameToDelete = jTextField1.getText().trim();

    if (usernameToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error");
        return;
    }//GEN-LAST:event_jButton1ActionPerformed
    
    File file = new File("C:\\Users\\raymark\\Documents\\NetBeansProjects\\AT4_Corbita\\src\\users.json"); {
    if (!file.exists()) {
        JOptionPane.showMessageDialog(this, "Error");
    }
    
    try {
        
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));
        JSONArray usersArray = (JSONArray) jsonObject.get("users");

        boolean userFound = false;
        ArrayList<JSONObject> updatedUsers = new ArrayList<>();

        for (Object obj : usersArray) {
            JSONObject user = (JSONObject) obj;
            String username = (String) user.get("username");

            if (username.equals(usernameToDelete)) {
                userFound = true;
            } else {
                updatedUsers.add(user);
            }
        }
        if (userFound) {
            // Update JSON file
            jsonObject.put("users", updatedUsers);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

            JOptionPane.showMessageDialog(this, "Successfully Deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Error!");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error!");
        e.printStackTrace();
    }
}
    }
    private void clrrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrrActionPerformed
        jTextField1.setText("");     
    }//GEN-LAST:event_clrrActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteStudent().setVisible(true);
            }
        });
    }
/* THIS FUNCTION ALLOWS USERS TO DELETE A STUDENT BY ENTERING A USERNAME, CHECKING IF IT
   EXISTS IN THE JSON FILE, REMOVING IT IF FOUND, AND SAVING THE UPDATED LIST, WHILE
   SHOWING ERROR MESSAGES IF THE USERNAME IS NOT FOUND OR THERE'S AN ISSUE. */
    
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bck;
    private javax.swing.JButton clrr;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
