package Company;

public class Manager implements Employee {

    private int salary;

    public Manager(Company company){
        salary  = company.salary + (int) (company.income * 0.05);
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
