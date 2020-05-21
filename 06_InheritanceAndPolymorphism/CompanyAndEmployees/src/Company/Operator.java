package Company;

public class Operator implements Employee {
    private int salary;

    public Operator(Company company){
        salary = company.salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee employee) {
        if (getMonthSalary() > employee.getMonthSalary()) {
            return -1;
        } else if (getMonthSalary() < employee.getMonthSalary()) {
            return 1;
        }
        return 0;
    }
}
