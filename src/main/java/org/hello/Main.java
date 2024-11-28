package org.hello;

import org.hello.User;
import org.hello.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect a function:");
            System.out.println("1. Enter the user list.");
            System.out.println("2. Enter receipt.");
            System.out.println("3. Enter expense.");
            System.out.println("4. Calculate current user salary.");
            System.out.println("5. Total profit.");
            System.out.println("6. Exit.");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter monthly salary: ");
                    double monthlySalary = scanner.nextDouble();
                    System.out.print("Enter number of days worked this month: ");
                    int daysWorked = scanner.nextInt();
                    scanner.nextLine();
                    service.addUser(new User(name, monthlySalary, daysWorked));
                    break;

                case 2:
                    System.out.print("Enter receipt amount: ");
                    double receiptAmount = scanner.nextDouble();
                    scanner.nextLine();
                    service.addTransaction(new Transaction("receipt", receiptAmount));
                    break;

                case 3:
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();
                    service.addTransaction(new Transaction("expense", expenseAmount));
                    break;

                case 4:
                    System.out.println("Current salary of users:");
                    for (User user : service.getUserList()) {
                        System.out.println("Salary of " + user.getName() + ": "
                                + String.format("%.0f", user.calculateCurrentSalary()));
                    }
                    break;

                case 5:
                    double profit = service.calculateProfit();
                    System.out.println("Current profit: " + String.format("%.0f", profit));
                    break;

                case 6:
                    System.out.println("Exit.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}