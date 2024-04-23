package co.edu.uptc.colasJava.view;



import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RightPanel extends JPanel {
    private JLabel lblName, lblBalance, lbltotal, lblNameText, lblBalanceText, lbltotalText, lblStatus;
    public RightPanel() {
        this.setLayout(new GridBagLayout());
        createLabels();
        labels();
    }

    public void labels() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 10);
        add(lblName, gbc);
        add(lblNameText, gbc);
        add(lblBalance, gbc);
        add(lblBalanceText, gbc);
        add(lblStatus, gbc);
        gbc.insets = new Insets(100, 10, 10, 20);
        add(lbltotal, gbc);
        gbc.insets = new Insets(0, 10, 10, 10);
        add(lbltotalText, gbc);
    }

    public void createLabels() {
        this.lblName = createLabel("Nombre:");
        this.lblBalance = createLabel("Balance:");
        this.lbltotal = createLabel("Total:");
        Font font = new Font("Look and feel", Font.PLAIN, 32);
        this.lblNameText = createLabel("");
        lblNameText.setFont(font);
        this.lblBalanceText = createLabel("");
        lblBalanceText.setFont(font);
        this.lbltotalText = createLabel("");
        lbltotalText.setFont(font);
        this.lblStatus = new JLabel(" ", SwingConstants.CENTER);
    }

    public JLabel createLabel(String data) {
        JLabel label = new JLabel(data);
        label.setBackground(Color.LIGHT_GRAY);
        label.setForeground(Color.BLACK);
        return label;
    }

    public void setLblName(String name) {
        lblNameText.setText(name);
    }

    public void setLblBalance(String balance) {
        lblBalanceText.setText(balance);
    }

    public void setLbltotal(String total) {
        lbltotalText.setText(total);
    }

    public void putSuccessStatus() {
        lblStatus.setText(" ");
    }

    public void putFailStatus(String text) {
        lblStatus.setForeground(Color.RED);
        lblStatus.setText(text);
    }
}
