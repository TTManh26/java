package org.hello;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Employee> listEmployees() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employee", Employee.class).list();
        }
    }

    public void updateEmployee(int id, String name, double salary, double workingdays, double receipt, double payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setName(name);
                employee.setSalary(salary);
                employee.setWorkingdays(workingdays);
                employee.setReceipt(receipt);
                employee.setPayment(payment);
                session.update(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            for (Employee employee : employees) {
                double salary = employee.getSalary();
                double workingdays = employee.getWorkingdays();
                double payment = employee.getPayment();
                double receipt = employee.getReceipt();

                double individualTotalSalary = (salary / workingdays) + payment + (receipt * 0.1);
                System.out.printf("Employee ID: %d, Name: %s, Total Salary: %.0f%n",
                        employee.getId(), employee.getName(), individualTotalSalary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalSalary;
    }
}
