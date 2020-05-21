package Company;

public class TopManager implements Employee {

    private int salary = 200_000;
    private int bonusOt = 10_000_000;

    public TopManager(Company company) {
        salary += company.salary;
        if (company.income > bonusOt) {
            // получаем зп + 150% бонусов
            salary = (salary * 2) + (salary / 2);
        }
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
