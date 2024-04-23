package co.edu.uptc.colasJava.view;

import java.awt.event.ActionListener;

public class QueueView {
    private Dashboard dashboard;
    private AddMoneyDialog addMoneyDialog;

    public QueueView(ActionListener actionListener) {
        initComponents(actionListener);
    }

    private void initComponents(ActionListener actionListener) {
        dashboard = new Dashboard(actionListener);
        addMoneyDialog = new AddMoneyDialog(actionListener);
    }

    public void putListNames(String[] nameStrings){
        dashboard.getLeftPanel().putListElements(nameStrings);
    }

    public void putCustomerName(String name){
        dashboard.getRightPanel().setLblName(name);
    }

    public void putCustomerBalance(String balance){
        dashboard.getRightPanel().setLblBalance(balance);
    }

    public void putTotalMoney(String money){
        dashboard.getRightPanel().setLbltotal(money);
    }

    public void putSuccessStatus(){
        dashboard.getRightPanel().putSuccessStatus();
    }

    public void putFailStatus(String status){
        dashboard.getRightPanel().putFailStatus(status);
    }

    public void openAddMoneyDialog(){
        addMoneyDialog.changeVisibility();
    }
    
    public String moneyAmountToAdd(){
       return addMoneyDialog.moneyAmount();
    }
}
