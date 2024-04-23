package co.edu.uptc.colasJava.view;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.uptc.colasJava.utils.ActionCommandsConstants;

public class LeftPanel extends JPanel {

    private JButton btnNext, btnAddMoney;
    
    private JList<String> listPeople;

    public LeftPanel(ActionListener actionListener) {
        this.setBackground(Color.DARK_GRAY);
        this.setMaximumSize(getMaximumSize());
        this.setLayout(new GridBagLayout());
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        listPeople = new JList<>();
        
        createButtons(actionListener);
        putButtonsActionCommand();
        addComponents();
    }

    private void addComponents() {
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 20, 20, 50);
        add(listScroll(), gbc);
        add(btnNext, gbc);
        add(btnAddMoney, gbc);
    }

    private JScrollPane listScroll(){
        JScrollPane listPeopleScroll = new JScrollPane(listPeople);
        listPeopleScroll.setPreferredSize(new Dimension(150, 300));
        return listPeopleScroll;
    }

    private void createButtons(ActionListener actionListener) {
        this.btnNext = createButton("Siguiente", actionListener, Color.YELLOW);
        this.btnAddMoney = createButton("Agregar dinero", actionListener, new Color(51, 59, 178));

    }

    private JButton createButton(String text, ActionListener actionListener, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.addActionListener(actionListener);
        btn.setForeground(Color.BLACK);
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        return btn;
    }

    private void putButtonsActionCommand() {
        this.btnNext.setActionCommand(ActionCommandsConstants.NEXT);
        this.btnAddMoney.setActionCommand(ActionCommandsConstants.OPEN_ADD_MONEY_MENU);
    }

    public void putListElements(String[] elements) {
        listPeople.setListData(elements);
    }

   

}
