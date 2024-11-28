package org.hello;
public class User {
    private String name;
    private double monthlySalary;
    private int daysWorked;

    public User(String name, double monthlySalary, int daysWorked) {
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.daysWorked = daysWorked;
    }

    public String getName() {
        return name;
    }

    public double getDailySalary() {
        return monthlySalary / 22;
    }

    public double calculateCurrentSalary() {
        return getDailySalary() * daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', monthlySalary=" + monthlySalary + ", daysWorked=" + daysWorked + "}";
    }
}