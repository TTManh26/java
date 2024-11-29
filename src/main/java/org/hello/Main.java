package org.hello;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyJDBC myJDBC = new MyJDBC();
        int choice = 0;

        while (true) {
            System.out.println("1. List Employees");
            System.out.println("2. Add Employees");
            System.out.println("3. Update Employees");
            System.out.println("4. Delete Employees By Id");
            System.out.println("5. Calculate Current Employees Salary");
            System.out.println("6. Exit");
            System.out.print("Choose: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid option.");
                continue;
            }

            if (choice == 6) {
                break;
            }

            switch (choice) {
                case 1:
                    myJDBC.findAll().forEach(employees -> System.out.println(employees));
                    break;
                case 2:
                    Employees employees = new Employees();
                    System.out.print("Name: ");
                    employees.setName(scanner.nextLine());
                    System.out.print("Salary: ");
                    try {
                        employees.setSalary(Integer.parseInt(scanner.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary input. Please enter a valid number.");
                        continue;
                    }
                    System.out.print("Working days: ");
                    try {
                        employees.setWorkingdays(Integer.parseInt(scanner.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid working days input. Please enter a valid number.");
                        continue;
                    }
                    System.out.print("Receipt: ");
                    try {
                        employees.setReceipt(Integer.parseInt(scanner.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid receipt input. Please enter a valid number.");
                        continue;
                    }
                    System.out.print("Payment: ");
                    try {
                        employees.setPayment(Integer.parseInt(scanner.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid payment input. Please enter a valid number.");
                        continue;
                    }

                    if (myJDBC.add(employees)) {
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Failed to create employee.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Id To Update: ");
                    Employees employees1 = myJDBC.findById(Integer.parseInt(scanner.nextLine()));
                    if (employees1 == null) {
                        System.out.println("Employee not found.");
                        break;
                    }
                    while (true) {
                        System.out.println(employees1);
                        System.out.println("1. Update Name");
                        System.out.println("2. Update Salary");
                        System.out.println("3. Update Working Days");
                        System.out.println("4. Update Receipt");
                        System.out.println("5. Update Payment");
                        System.out.println("6. Save");
                        int choice1 = Integer.parseInt(scanner.nextLine());
                        if (choice1 == 1) {
                            System.out.print("Name: ");
                            employees1.setName(scanner.nextLine());
                        }
                        if (choice1 == 2) {
                            System.out.print("Salary: ");
                            employees1.setSalary(Integer.parseInt(scanner.nextLine()));
                        }
                        if (choice1 == 3) {
                            System.out.print("Working Days: ");
                            employees1.setWorkingdays(Integer.parseInt(scanner.nextLine()));
                        }
                        if (choice1 == 4) {
                            System.out.print("Receipt: ");
                            employees1.setReceipt(Integer.parseInt(scanner.nextLine()));
                        }
                        if (choice1 == 5) {
                            System.out.print("Payment: ");
                            employees1.setPayment(Integer.parseInt(scanner.nextLine()));
                        }
                        if (choice1 == 6) {
                            myJDBC.update(employees1);
                            System.out.println("Update successful.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Id To Delete: ");
                    if (myJDBC.delete(Integer.parseInt(scanner.nextLine()))) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Failed to delete employee.");
                    }
                    break;
                case 5:
                    myJDBC.findAll().forEach(employees2 -> {
                        int salary = employees2.getSalary();
                        int workingDays = employees2.getWorkingdays();
                        int receipt = employees2.getReceipt();
                        int payment = employees2.getPayment();

                        if (workingDays == 0) {
                            System.out.println("Employee" + employees2.getName() + "has no salary.");
                            return;
                        }

                        double calculatedSalary = (salary / (double) workingDays) + payment + (receipt * 0.1);

                        System.out.printf("Employee: %s\n", employees2.getName());
                        System.out.printf("Salary per day: %.0f\n", salary / (double) workingDays);
                        System.out.printf("Receipt: %d, Payment: %d\n", receipt, payment);
                        System.out.printf("Calculated Salary: %.0f\n", calculatedSalary);
                        System.out.println("-------------------------------------------");
                    });
                    break;
            }
        }
    }
}
