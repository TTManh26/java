package org.hello;

public class Employees {
    private int id;
    private String name;
    private int salary;
    private int working_days;

    public Employees() {
    }

    public Employees(String name, int salary, int working_days) {
        this.setName(name);
        this.setSalary(salary);
        this.setWorking_days(working_days);
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

    public int getWorking_days() {
        return working_days;
    }

    public void setWorking_days(int working_days) {
        this.working_days = working_days;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", working_days=" + getWorking_days() +
                '}';
    }

}
