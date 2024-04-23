package co.edu.uptc.colasJava.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Dashboard extends JFrame {
    LeftPanel leftPanel;
    RightPanel rightPanel;

    public Dashboard(ActionListener actionListener) {
        super("Cola Cajero");
        // this.setResizable(false);
        this.setSize(new Dimension(600, 600));
        this.initComponents(actionListener);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComponents(ActionListener actionListener) {
        leftPanel = new LeftPanel(actionListener);
        rightPanel = new RightPanel();
        add(leftPanel);
        add(rightPanel);
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    
}