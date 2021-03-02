package com.serialization;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  private static int menuChoice;
  private static final Scanner scanner = new Scanner(System.in);
  private static ArrayList<Employee> employeeArrayList;
  
  public static void main(String[] args) {
    employeeArrayList = EmployeeData.getInstance().loadEmployees();
    do {
      displayMenu();
    } while(menuChoice != MenuChoice.QUIT);
    
  }
  
  private static void displayMenu() {
    System.out.println("Main Menu:");
    System.out.println("\t1.Add an employee");
    System.out.println("\t2.Display All");
    System.out.println("\t3. Write all the entered employees to file");
    System.out.println("\t4.Read all the employees from the file");
    System.out.println("\t5.Exit");
    
    menuChoice = scanner.nextInt();
    
    switch (menuChoice) {
      case MenuChoice.ADDEMPLOYEE:
        addEmployee();
      
      case MenuChoice.SAVE:
        saveData();
        break;
      
      case MenuChoice.DISPLAY:
        displayEmployees();
        break;
        
      case MenuChoice.LOAD:
        loadData();
        break;
        
      case MenuChoice.QUIT:
        System.exit(0);
        break;
      
      default:
        System.out.println("Invalid Input");
    }
  }
  
  private static void loadData() {
    employeeArrayList = EmployeeData.getInstance().loadEmployees();
  }
  
  private static void saveData() {
    EmployeeData.getInstance().saveEmployees(employeeArrayList);
  }
  
  private static void displayEmployees() {
    System.out.println();
    System.out.println("Employee Data in Memory:");
    for(var e : employeeArrayList) {
      System.out.println("\t" + e);
    }
    System.out.println();
  }
  
  private static void addEmployee() {
    System.out.println("Enter the Employee id:");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Enter the name of the Employee:");
    String name = scanner.nextLine();
    System.out.println("Enter the salary of the Employee:");
    double salary = scanner.nextDouble();
    scanner.nextLine();
    System.out.println("Enter the age of the Employee:");
    int age = scanner.nextInt();
    scanner.nextLine();
    employeeArrayList.add(new Employee(id, name, salary, age));
  }
}
