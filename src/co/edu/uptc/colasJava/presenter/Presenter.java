package co.edu.uptc.colasJava.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import co.edu.uptc.colasJava.models.ATM;
import co.edu.uptc.colasJava.models.Customer;
import co.edu.uptc.colasJava.utils.ActionCommandsConstants;
import co.edu.uptc.colasJava.utils.RandomName;
import co.edu.uptc.colasJava.view.QueueView;

public class Presenter implements ActionListener {

    private LinkedList<Customer> customerQueue = new LinkedList<>();
    private ATM atm = new ATM();
    private QueueView view;

    public Presenter() {
        initCustomers();
        view = new QueueView(this);
        loadData();
    }

    private void initCustomers() {
        for (int i = 0; i < 12; i++) {
            customerQueue.offer(randomCustomer());
        }
    }

    private void loadData() {
        view.putListNames(customersNameArray());
        putFirstCustomerInfo();
        view.putTotalMoney(stringCurrencyFormat(atm.getAvailableMoney()));
    }

    private String[] customersNameArray() {
        String[] customersNameArray = new String[customerQueue.size()];
        return customerNameList().toArray(customersNameArray);
    }

    private void putFirstCustomerInfo() {
        view.putCustomerName(customerQueue.getFirst().getName());
        view.putCustomerBalance(stringCurrencyFormat(customerQueue.getFirst().getBalance()));
    }

    private String stringCurrencyFormat(int amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(amount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case ActionCommandsConstants.NEXT:
                nextCustomerAction();
                break;
            case ActionCommandsConstants.OPEN_ADD_MONEY_MENU:
                view.openAddMoneyDialog();
                break;
            case ActionCommandsConstants.ADD_MONEY:
                addMoneyAction();
                break;
            default:
                break;
        }
    }

    private void nextCustomerAction() {
        if (atm.isMoneyAvailable() && pollCustomer()) {
            loadData();
            view.putSuccessStatus();
        } else {
            view.putFailStatus("DINERO INSUFICIENTE");
        }
    }

    private void addMoneyAction() {
        atm.addMoney(Integer.parseInt(view.moneyAmountToAdd()));
        view.putTotalMoney(stringCurrencyFormat(atm.getAvailableMoney()));
    }

    public boolean pollCustomer() {
        if (customerQueue.getFirst().getBalance() < atm.getAvailableMoney()) {
            atm.removeMoney((customerQueue.poll()).getBalance());
            customerQueue.offer(randomCustomer());
            return true;
        }
        return false;
    }

    public void addATMMoney(int money) {
        atm.addMoney(money);
    }

    public List<String> customerNameList() {
        List<String> namesList = new ArrayList<>();
        for (Customer customer : customerQueue) {
            namesList.add(customer.getName());
        }
        return namesList;
    }

    private Customer randomCustomer() {
        Customer customer = new Customer();
        RandomName randomName = new RandomName();
        customer.setBalance((int) (Math.random() * 100));
        customer.setName(randomName.ramdonName());
        return customer;
    }

    public static void main(String[] args) throws Exception {
        new Presenter();
    }
}
