package co.edu.uptc.colasJava.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import co.edu.uptc.colasJava.utils.ActionCommandsConstants;

public class AddMoneyDialog extends JDialog {
    private JLabel lblMoney;
    private JTextField txtMoney;
    private JButton btnAdd, btnExit;

    public AddMoneyDialog(ActionListener actionListener) {
        this.setSize(500, 200);
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        createComponents(actionListener);
        addComponents();
    }

    private void createComponents(ActionListener actionListener){
        lblMoney = new JLabel("Dinero a ingresar:");
        txtMoney = new JTextField();
        txtMoney.setPreferredSize(new Dimension(100, 20));
        btnAdd = new JButton("Anadir");
        btnAdd.addActionListener(actionListener);
        btnAdd.setActionCommand(ActionCommandsConstants.ADD_MONEY);
        btnExit = new JButton("Salir");
        btnExit.addActionListener(e -> this.dispose());
    }

    private void addComponents(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        this.getContentPane().add(lblMoney, gbc);
        this.getContentPane().add(txtMoney, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.getContentPane().add(btnAdd, gbc);
        gbc.fill = GridBagConstraints.NONE;
        this.getContentPane().add(btnExit, gbc);
    }

    public void changeVisibility(){
        this.setVisible(!this.isVisible());
    }

    public String moneyAmount(){
        return txtMoney.getText();
    }
}
