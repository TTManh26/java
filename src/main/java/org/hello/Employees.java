package org.hello;

public class Employees {
    private int id;
    private String name;
    private int salary;
    private int workingdays;
    private int receipt;
    private int payment;

    public Employees() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(int workingdays) {
        this.workingdays = workingdays;
    }

    public int getReceipt() {
        return receipt;
    }

    public void setReceipt(int receipt) {
        this.receipt = receipt;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", workingdays=" + getWorkingdays() +
                ", receipt=" + getReceipt() +
                ", payment=" + getPayment() +
                '}';
    }
}