import Company.*;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    public static void main(String[] args) {

        //создание компаний
        Company companyOne = new Company();
        Company companyTwo = new Company();
        Company companyThree = new Company();

        //найм персонала
        for (int i = 0; i < 60; i++) {
            companyOne.hire(new Operator(companyOne));
            companyTwo.hire(new Operator(companyTwo));
            companyThree.hire(new Operator(companyThree));
            if (i == 39) {
                companyOne.hire(new Manager(companyOne));
                companyTwo.hire(new Manager(companyTwo));
                companyThree.hire(new Manager(companyThree));
            }
            if (i == 55) {
                companyOne.hire(new TopManager(companyOne));
                companyTwo.hire(new TopManager(companyTwo));
                companyThree.hire(new TopManager(companyThree));
            }
        }

        // 10 самых высоких зп
        List<Employee> top = Company.getTopSalaryStaff(10);

        for (Employee employee: top) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("\n--------------------------------------\n");

        //30 самых низких зп
        List<Employee> lowest = Company.getLowestSalaryStaff(30);

        for (Employee employee: lowest) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("\n--------------------------------------\n");

        //уволить 50%
        for (int i = 0; i < companyOne.getListOfEmployees().size()/2; i++) {
            companyOne.fire(companyOne.getListOfEmployees().get(i));
        }
        for (int i = 0; i < companyTwo.getListOfEmployees().size()/2; i++) {
            companyTwo.fire(companyTwo.getListOfEmployees().get(i));
        }
        for (int i = 0; i < companyThree.getListOfEmployees().size()/2; i++) {
            companyThree.fire(companyThree.getListOfEmployees().get(i));
        }

        System.out.println("\n--------------------------------------\n");

        //10 самых высоких зп(2)
        List<Employee> top2 = Company.getTopSalaryStaff(10);

        for (Employee employee: top2) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("\n--------------------------------------\n");

        //30 самых низких зп(2)
        List<Employee> lowest2 = Company.getLowestSalaryStaff(30);

        for (Employee employee: lowest2) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("\n--------------------------------------\n");

    }
}
