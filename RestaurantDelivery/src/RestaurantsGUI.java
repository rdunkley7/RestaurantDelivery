
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ai7321lr
 */
public class RestaurantsGUI extends javax.swing.JFrame {

    
    Orders order = new Orders();
     String customerID;

    /**
     * Creates new form UserGUI3
     */
    public RestaurantsGUI(String customerID) {
        this.customerID = customerID;
        initComponents();
    }

    private RestaurantsGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        restaurantComboBox = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        orderField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addtoOrderButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTextBox = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        checkOutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextPane1.setText("Select from the available restaurants below to start:");
        jTextPane1.setToolTipText("");
        jScrollPane1.setViewportView(jTextPane1);

        restaurantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a restaurant!", "Mexican", "SushiSushi" }));
        restaurantComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantComboBoxActionPerformed(evt);
            }
        });

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        jScrollPane3.setViewportView(resultTextArea);

        jLabel1.setText("Enter Menu Number:");

        addtoOrderButton.setText("Add to Order");
        addtoOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoOrderButtonActionPerformed(evt);
            }
        });

        orderTextBox.setColumns(20);
        orderTextBox.setRows(5);
        jScrollPane2.setViewportView(orderTextBox);

        jLabel2.setText("Your Current Order:");

        checkOutButton.setText("Finish Order");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(restaurantComboBox, 0, 208, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(checkOutButton)
                                .addComponent(addtoOrderButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(restaurantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addtoOrderButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkOutButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restaurantComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantComboBoxActionPerformed
        // TODO add your handling code here:
        int x = restaurantComboBox.getSelectedIndex();
        //String comboName = restaurantComboBox.getname();
        String restName = restaurantComboBox.getSelectedItem().toString();
        
        System.out.println(customerID);
        
        Restaurant restaurant = new Restaurant();
       
            try {
                //first selection can be mexican for now
                

                //call restaruarnt from db to read the menu then print results
                ResultSet menuResult = restaurant.readMenu(restName);
                resultTextArea.append(restName + " menu: ");
                writeRestaurantResultSet(menuResult);
  
                }catch(Exception e){
                e.printStackTrace();
            
                }
            
        
    }//GEN-LAST:event_restaurantComboBoxActionPerformed

    private void addtoOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoOrderButtonActionPerformed
        // TODO add your handling code here:
        String menuItemID = orderTextBox.getText();
        
        //get the menuID from textbox
        //send to Order for insert to foodOrder table
        //also update customer table by customerID - update the paymentID and orderID
        
        
        
    }//GEN-LAST:event_addtoOrderButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        // TODO add your handling code here:
        
        //update foodOrder table - update orderStatus & timesubmitted
        
        
    }//GEN-LAST:event_checkOutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RestaurantsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantsGUI().setVisible(true);
            }
        });
    }

    public void writeRestaurantResultSet(ResultSet menuResult) throws SQLException {
        // ResultSet is initially before the first data set
     

            while (menuResult.next()) {
                   
                   
                    String menuItemID = menuResult.getString("menuItemID");
                    String menuItemName = menuResult.getString("menuItemName");
                    String menuItemDesc = menuResult.getString("menuItemDescription");
                    Double menuItemPrice = menuResult.getDouble("menuItemPrice");
                    String restID = menuResult.getString("restID");

                    
                    resultTextArea.append(String.format("%n %-5s %-20s $%-20.2f %-5s" ,menuItemID, menuItemName, menuItemPrice, menuItemDesc));
//                    resultTextArea.append("menuItemID: " + menuItemID);
//                    resultTextArea.append("menuItemName: " + menuItemName);
//                    resultTextArea.append("menuItemDesc : " + menuItemDesc);
//                    resultTextArea.append("menuItemPrice : " + menuItemPrice);
//                    resultTextArea.append("restID : " + restID);
//                    resultTextArea.append("\n");
                }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoOrderButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField orderField;
    private javax.swing.JTextArea orderTextBox;
    private javax.swing.JComboBox<String> restaurantComboBox;
    private javax.swing.JTextArea resultTextArea;
    // End of variables declaration//GEN-END:variables
}
