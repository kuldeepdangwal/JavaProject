package com.cg.payroll.client;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {
	public static void main(String[] args) {
//			PayrollServices services = new PayrollServicesImpl();
//			int associateId=services.acceptAssociateDetails("Kuldeep", "Dangwal", "kuldeepd@gmail.com", "RTF", "A4", "CHD9876", 80000, 30000, 1000, 1500, 5896642, "Citi", "citi0001");
//			System.out.println("Associate Id: "+associateId);
			
//			PayrollServices services1 = new PayrollServicesImpl();
//			associateId=services1.acceptAssociateDetails("Kuldeep", "Sharma", "ksharma@gmail.com", "RTF", "A4", "CHD9876", 80000, 30000, 1000, 1500, 5896642, "Citi", "citi0001");
//			System.out.println("Associate Id: "+associateId);
//			
//			PayrollServices services2 = new PayrollServicesImpl();
//			associateId=services2.acceptAssociateDetails("Deepak", "Singh", "dsingh@gmail.com", "RTF", "A4", "CHD9876", 80000, 30000, 1000, 1500, 5896642, "Citi", "citi0001");
//			System.out.println("Associate Id: "+associateId);
			
			Scanner sc = new Scanner(System.in);
//			PayrollServices ser1 = new PayrollServicesImpl();
//			System.out.println("Enter associate id to find details: ");
//			int id = sc.nextInt();
//			Associate associateDetails = ser1.getAssociateDetails(id);
//			System.out.println(associateDetails);
			
//			PayrollServices serv1 = new PayrollServicesImpl();
//			List<Associate> allAssociateDetails = serv1.getAllAssociatesDetails();		
//			System.out.println(allAssociateDetails);
			
			
			System.out.println("******************Payroll********************");
			char ch='y';
			while(ch=='y'||ch=='Y') {
				System.out.println("Enter your choice:\n1. Save Associate\n2. Get Associate Details\n3. Get All Associate Details"
						+ "\n4.Calculate Net Salary");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					PayrollServices services = new PayrollServicesImpl();
					int associateId=services.acceptAssociateDetails("Kuldeep", "Dangwal", "kuldeepd@gmail.com", "RTF", "A4", "CHD9876", 80000, 30000, 1000, 1500, 5896642, "Citi", "citi0001");
					System.out.println("Associate Id: "+associateId);
					break;
				case 2: 
					PayrollServices ser1 = new PayrollServicesImpl();
					System.out.println("Enter associate id to find details: ");
					int id = sc.nextInt();
					Associate associateDetails = ser1.getAssociateDetails(id);
					System.out.println(associateDetails);
					break;
				case 3:
					PayrollServices serv1 = new PayrollServicesImpl();
					List<Associate> allAssociateDetails = serv1.getAllAssociatesDetails();		
					System.out.println(allAssociateDetails);
					break;
				case 4:
					//Salary salary = new Salary();
					PayrollServices serv2 = new PayrollServicesImpl();
					System.out.println("Enter associate id to calculate net salary: ");
					id = sc.nextInt();
					int netSalary = serv2.calculateNetSalary(id);
					System.out.println("Net Salary = "+netSalary);
					//System.out.println("Monthly tax = "+salary.getMonthlyTax());
					break;
			default:
				System.out.println("Please enter a valid number");
				break;
			}
				System.out.println("Do you want to continue(y/n): ");
				ch = sc.next().charAt(0);
			}
	}
}
