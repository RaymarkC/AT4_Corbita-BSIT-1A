
package GUIapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.JOptionPane;


public class AddStudent extends javax.swing.JFrame {

    
    public AddStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        clr = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 97, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 166, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 97, 190, -1));
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 163, 190, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 225, 82, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Student");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 21, -1, -1));

        clr.setBackground(new java.awt.Color(0, 0, 0));
        clr.setForeground(new java.awt.Color(255, 255, 255));
        clr.setText("Clear");
        clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrActionPerformed(evt);
            }
        });
        jPanel1.add(clr, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 225, 89, -1));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 271, 60, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String username = jTextField1.getText().trim();
    String password = new String(jPasswordField1.getPassword()).trim();
    
    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Invalid Input!");
        return;
    }//GEN-LAST:event_jButton1ActionPerformed

    String filePath = "C:\\Users\\raymark\\Documents\\NetBeansProjects\\AT4_Corbita\\src\\users.json"; 
    JSONParser parser = new JSONParser();

     try (FileReader reader = new FileReader(filePath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray usersArray = (JSONArray) jsonObject.get("users");

        
        for (Object obj : usersArray) {
            JSONObject user = (JSONObject) obj;
            if (user.get("username").equals(username)) {
                JOptionPane.showMessageDialog(this, "Error");
                return;
            }
        }
            
        JSONObject newUser = new JSONObject();
        newUser.put("username", username);
        newUser.put("password", password);
        usersArray.add(newUser);

        
        try (FileWriter file = new FileWriter(filePath)) {
            jsonObject.put("users", usersArray);
            file.write(jsonObject.toJSONString());
            file.flush();
        }

        JOptionPane.showMessageDialog(this, "Student Added successfully!");
        jTextField1.setText("");
        jPasswordField1.setText("");    
        } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error!");
        e.printStackTrace();
}       catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Error");
        e.printStackTrace();
    }   
        }
/* THIS FEATURE ALLOWS USERS TO ADD A NEW STUDENT BY ENTERING A USERNAME AND PASSWORD,
   CHECKING IF THE USERNAME ALREADY EXISTS IN "USERS.JSON," AND SAVING THE NEW STUDENT IF IT
   DOES NOT, WHILE SHOWING ERROR MESSAGES FOR INVALID INPUTS OR ISSUES. */
       
 
    
    private void clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrActionPerformed
         jTextField1.setText("");
        jPasswordField1.setText("");
    }//GEN-LAST:event_clrActionPerformed
// THESE FUNCTION WILL CLEAR ALL THE TEXT THAT YOU PUT IN THE FIELD
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new WelcomeWindow().setVisible(true);
        this.dispose();      
    }//GEN-LAST:event_jButton2ActionPerformed
// THESE FUNCTION WILL GO BACK TO WELCOME WINDOW
    
    
    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
