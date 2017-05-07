package View;

import Database.CustomerConnection;
import Database.PaymentConnection;
import Database.ReservationConnection;
import Models.Customer;
import Models.Payment;
import Models.Perk;
import Models.Reservation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Charlie
 */
public class PaymentGUI extends javax.swing.JPanel {
    
    PaymentConnection paymentCon = new PaymentConnection();
    ReservationConnection reservationConnection = new ReservationConnection();
    CustomerConnection customerconnection = new CustomerConnection();
    GUI gui;
    /**
     * Creates new form PaymentGUI
     */
    public PaymentGUI(GUI gui) 
    {
        
        initComponents();
        this.gui=gui;
        int id = customerconnection.getNewestCustomerID();
        Customer customer =customerconnection.searchCustomerID(id);
        String name = customer.getfName();
        String surname = customer.getlName();
        nameTF.setText(name);
        surnameTF.setText(surname);
        numberOfRoomsTF.setText(String.valueOf(reservationConnection.getNewestReservation().getNumberOfRooms()));
        priceForRoomTF.setText(String.valueOf(reservationConnection.getNewestReservation().getTotalPrice()));
        totalPriceTF.setText("0");
    }
    
     private void setPerkPrice(int perkID, JCheckBox cb)
    {
        int totalPrice = Integer.parseInt(totalPriceTF.getText());
        int roomPrice = Integer.parseInt(priceForRoomTF.getText());
        int total = totalPrice + roomPrice;
        Perk perk = customerconnection.getPerk(perkID);
        int perkPrice = perk.getPrice();
            
        if(cb.isSelected()){
            total += perkPrice;
            totalPriceTF.setText(""+total);
        } else if (!cb.isSelected()) {
            total -= perkPrice;
            totalPriceTF.setText(""+total);
        }
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
        jLabel2 = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        surnameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numberOfRoomsTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceForRoomTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalPriceTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        breakfastCB = new javax.swing.JCheckBox();
        lunchCB = new javax.swing.JCheckBox();
        spaCB = new javax.swing.JCheckBox();
        reserveButton = new javax.swing.JButton();
        paymentButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        jLabel2.setText("Name:");

        jLabel3.setText("Surname:");

        jLabel4.setText("Number of rooms:");

        jLabel5.setText("Price for room:");

        jLabel6.setText("Total Price:");

        jLabel7.setText("Extras:");

        breakfastCB.setText("Breakfast");
        breakfastCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breakfastCBActionPerformed(evt);
            }
        });

        lunchCB.setText("Lunch");
        lunchCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunchCBActionPerformed(evt);
            }
        });

        spaCB.setText("Spa+Fitness");
        spaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaCBActionPerformed(evt);
            }
        });

        reserveButton.setText("Reserve");
        reserveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                reserveButtonMouseReleased(evt);
            }
        });

        paymentButton.setText("Pay");
        paymentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paymentButtonMouseReleased(evt);
            }
        });

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameTF)
                        .addComponent(surnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breakfastCB)
                    .addComponent(lunchCB)
                    .addComponent(spaCB)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(totalPriceTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(priceForRoomTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numberOfRoomsTF, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(reserveButton)
                        .addGap(18, 18, 18)
                        .addComponent(paymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backButton)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(surnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(breakfastCB)
                .addGap(18, 18, 18)
                .addComponent(lunchCB)
                .addGap(18, 18, 18)
                .addComponent(spaCB)
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberOfRoomsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceForRoomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentButton)
                    .addComponent(reserveButton)
                    .addComponent(backButton))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reserveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveButtonMouseReleased
        String fName = nameTF.getText();
        String lName = surnameTF.getText();
        Boolean breakfast = breakfastCB.isEnabled();
        Boolean lunch = lunchCB.isEnabled();
        Boolean fitnessSpa = spaCB.isEnabled();
        int numberOfRooms = Integer.parseInt(numberOfRoomsTF.getText());
        int priceForRoom = Integer.parseInt(priceForRoomTF.getText());
        int totalPrice = Integer.parseInt(priceForRoomTF.getText());
        
        
       Payment payment = new Payment(fName, lName, breakfast, lunch, fitnessSpa, numberOfRooms, priceForRoom, totalPrice);
        try {
            paymentCon.createPayment(payment);
        } catch (SQLException ex) {
            Logger.getLogger(FirstFloorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         JOptionPane.showMessageDialog(null, "Your reservation has been made");
    }//GEN-LAST:event_reserveButtonMouseReleased

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
         AvailableRoomsGUI availableRooms=new AvailableRoomsGUI(gui);
  
            
            gui.jPanel2Main.removeAll();
            gui.jPanel2Main.repaint();
            gui.jPanel2Main.add(availableRooms);
            gui.jPanel2Main.repaint();
            gui.setVisible(true);
    }//GEN-LAST:event_backButtonMouseReleased

    private void breakfastCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breakfastCBActionPerformed
        setPerkPrice(1, breakfastCB);  
    }//GEN-LAST:event_breakfastCBActionPerformed

    private void lunchCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunchCBActionPerformed
        setPerkPrice(2, lunchCB);
    }//GEN-LAST:event_lunchCBActionPerformed

    private void spaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaCBActionPerformed
        setPerkPrice(3, spaCB);
    }//GEN-LAST:event_spaCBActionPerformed

    private void paymentButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentButtonMouseReleased
        String fName = nameTF.getText();
        String lName = surnameTF.getText();
        Boolean breakfast = breakfastCB.isEnabled();
        Boolean lunch = lunchCB.isEnabled();
        Boolean fitnessSpa = spaCB.isEnabled();
        int numberOfRooms = Integer.parseInt(numberOfRoomsTF.getText());
        int priceForRoom = Integer.parseInt(priceForRoomTF.getText());
        int totalPrice = Integer.parseInt(priceForRoomTF.getText());
        
        
       Payment payment = new Payment(fName, lName, breakfast, lunch, fitnessSpa, numberOfRooms, priceForRoom, totalPrice);
        try {
            paymentCon.createPayment(payment);
        } catch (SQLException ex) {
            Logger.getLogger(FirstFloorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         JOptionPane.showMessageDialog(null, "Payment is completed");
    }//GEN-LAST:event_paymentButtonMouseReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JCheckBox breakfastCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox lunchCB;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField numberOfRoomsTF;
    private javax.swing.JButton paymentButton;
    private javax.swing.JTextField priceForRoomTF;
    private javax.swing.JButton reserveButton;
    private javax.swing.JCheckBox spaCB;
    private javax.swing.JTextField surnameTF;
    private javax.swing.JTextField totalPriceTF;
    // End of variables declaration//GEN-END:variables
}
