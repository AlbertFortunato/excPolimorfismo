package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i =1; i<=3;i++){
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours: ");
            int  hours = sc.nextInt();
            System.out.print("Value Per Hour: ");
            double valuePerHour = sc.nextDouble();
            if (ch == 'y'){
                System.out.print("Additional charge: ");
                double addionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours,valuePerHour,addionalCharge));
            }
            else{
            list.add(new Employee(name,hours,valuePerHour));
            }

        }
        System.out.println();
        System.out.println("PAYMENTS: ");
        for (Employee emp: list){
            System.out.println(emp.getName()+" - $ "+ String.format("%.2f",emp.payment()));
        }
        sc.close();
    }
}
