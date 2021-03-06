
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Container;

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
        
        Container c = RestaurantsGUI.this.getContentPane();
        c.setBackground(Color.getHSBColor(302, 102, 85));
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
        orderTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        checkOutButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
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

        resultTextArea.setEditable(false);
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

        orderTextArea.setEditable(false);
        orderTextArea.setColumns(20);
        orderTextArea.setRows(5);
        jScrollPane2.setViewportView(orderTextArea);

        jLabel2.setText("Your Current Order:");

        checkOutButton.setText("Finish Order");
        checkOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitButton))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutButton)
                    .addComponent(exitButton))
                .addGap(0, 0, Short.MAX_VALUE))
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

        Restaurant restaurant = new Restaurant();

        try {
            //first selection can be mexican for now
            
            
            if(restName.equals("Mexican")) {
                    resultTextArea.setText("");
                    ResultSet mexicanMenu = restaurant.readMenu(restName);
                    resultTextArea.append(restName+ " menu: ");
                    writeRestaurantResultSet(mexicanMenu);
                }
                else if (restName.equals("SushiSushi")){
                    resultTextArea.setText("");
                    ResultSet sushiMenu = restaurant.readMenu(restName);
                    resultTextArea.append(restName+ " menu: ");
                    writeRestaurantResultSet(sushiMenu);
                }else {
                    resultTextArea.setText("");
                }

            //call restaruarnt from db to read the menu then print results

        } catch (Exception e) {
            e.printStackTrace();

        }


    }//GEN-LAST:event_restaurantComboBoxActionPerformed

    private void addtoOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoOrderButtonActionPerformed
        try {
            // TODO add your handling code here:
            String menuItemID = orderField.getText();

            int orderID = order.addOrderForCustomer(menuItemID, customerID);
            System.out.println(menuItemID);
            //send to Order for insert to foodOrder table

            ResultSet orderResult = order.readOrdersMenu(orderID);
            writeOrderResultSet(orderResult);
            //also update customer table by customerID - update the paymentID and orderID
        } catch (Exception ex) {
            Logger.getLogger(RestaurantsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addtoOrderButtonActionPerformed

    private void checkOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutButtonActionPerformed
        try {
            // TODO add your handling code here:

//update foodOrder table - update orderStatus & timesubmitted
            //also handles the total purchase price for order
            Double totalPrice = order.readCheckout(customerID);

            String deliveryTime = order.checkoutUpdate(customerID);

            orderTextArea.append(String.format("%n%nYour order total: $%.2f", totalPrice));
            orderTextArea.append(String.format("%nThank you for your purchase."));
            orderTextArea.append(String.format("%nYour order is being processed and has an estimated delivery time of " + deliveryTime));

        } catch (Exception ex) {
            Logger.getLogger(RestaurantsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_checkOutButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        //close the GUI
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

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
        while (menuResult.next()) {
            String menuItemID = menuResult.getString("menuItemID");
            String menuItemName = menuResult.getString("menuItemName");
            String menuItemDesc = menuResult.getString("menuItemDescription");
            Double menuItemPrice = menuResult.getDouble("menuItemPrice");
            String restID = menuResult.getString("restID");
            resultTextArea.append(String.format("%n %-5s %-20s $%-20.2f %-5s", menuItemID, menuItemName, menuItemPrice, menuItemDesc));
        }
    }

    public void writeOrderResultSet(ResultSet menuResult) throws SQLException {
        while (menuResult.next()) {
            String menuItemID = menuResult.getString("menuItemID");
            String menuItemName = menuResult.getString("menuItemName");
            String menuItemDesc = menuResult.getString("menuItemDescription");
            Double menuItemPrice = menuResult.getDouble("menuItemPrice");
            String restID = menuResult.getString("restID");
            orderTextArea.append(String.format("%n %-5s %-20s $%-20.2f %-5s", menuItemID, menuItemName, menuItemPrice, menuItemDesc));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoOrderButton;
    private javax.swing.JButton checkOutButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField orderField;
    private javax.swing.JTextArea orderTextArea;
    private javax.swing.JComboBox<String> restaurantComboBox;
    private javax.swing.JTextArea resultTextArea;
    // End of variables declaration//GEN-END:variables
}
