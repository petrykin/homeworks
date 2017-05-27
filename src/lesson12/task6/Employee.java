package lesson12.task6;

import lesson7.task1.Person;

public class Employee extends Person {
    private double salary;

    public Employee(String fullName) {
        super(fullName);
    }

    public Employee(String fullName, double salary) {
        this(fullName);
        this.salary = salary;
    }

    public String getFullName() {
        return super.getFullName();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary = " + salary +
                '}';
    }
}
