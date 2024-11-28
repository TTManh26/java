package org.hello;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private final List<User> userList = new ArrayList<>();
    private final List<Transaction> transactionList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public double calculateProfit() {
        double totalReceipts = 0;
        double totalExpenses = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.getType().equals("receipt")) {
                totalReceipts += transaction.getAmount();
            } else if (transaction.getType().equals("expense")) {
                totalExpenses += transaction.getAmount();
            }
        }
        return totalReceipts - totalExpenses;
    }

    public double calculateTotalCurrentSalaries(int daysWorked) {
        return userList.stream()
                .mapToDouble(user -> user.getDailySalary() * daysWorked).sum();
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}
