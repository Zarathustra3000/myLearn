package Company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private List<Employee> listOfEmployees = new ArrayList<>();
    private static List<Employee> listOfEmployeesInAllCompanies = new ArrayList<>();
    private final int INCOME_MIN = 100_000;
    private final int INCOME_MAX = 20_000_000;
    private final int SALARY_MIN = 20_000;
    private final int SALARY_MAX = 80_000;

    protected int salary = (int) (Math.random() * (SALARY_MAX - SALARY_MIN)) + SALARY_MIN;
    protected int income = (int) (Math.random() * (INCOME_MAX - INCOME_MIN)) + INCOME_MIN;

    // получаем 80% дохода компании
    private int wageFund = (int) (income * 0.8);

    // Проверка на банкротство
    private boolean bankrupt() {
        if (wageFund < listOfEmployees.size() * SALARY_MAX) {
            return true;
        } else {
            return false;
        }
    }

    public int getIncome() {
        return income;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }


    public void hire(Employee employee) {
        if (!bankrupt()) {
            listOfEmployees.add(employee);
            listOfEmployeesInAllCompanies.add(employee);
        }
    }

    public void hireAll(List<Employee> list) {
        if (!bankrupt()) {
            listOfEmployees.addAll(list);
            listOfEmployeesInAllCompanies.addAll(list);
        }
    }

    public void fire(Employee employee) {
        listOfEmployees.remove(employee);
        listOfEmployeesInAllCompanies.remove(employee);
    }

    public static List<Employee> getTopSalaryStaff(int count) {
        List<Employee> list = new ArrayList<>();
        Collections.sort(listOfEmployeesInAllCompanies);

        if (count < listOfEmployeesInAllCompanies.size() && count > 0) {
            for (int i = 0; i < count; i++) {
                list.add(listOfEmployeesInAllCompanies.get(i));
            }
        } else {
            System.out.println("Error");
        }
        return list;

    }

    public static List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> list = new ArrayList<>();
        Collections.sort(listOfEmployeesInAllCompanies, Collections.reverseOrder());

        if (count < listOfEmployeesInAllCompanies.size() && count > 0) {
            for (int i = 0; i < count; i++) {
                list.add(listOfEmployeesInAllCompanies.get(i));
            }
        } else  {
            System.out.println("Error");
        }
        return list;

    }


}
