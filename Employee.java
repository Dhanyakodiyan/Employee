package com.Employee;

import java.util.Scanner;
import java.util.Random;

public class Employee {
	public static void main(String[]args) {
		CredentialService credentialService = new CredentialService();
		Scanner scanner = new Scanner(System.in);
		EmployeeDetails emp = new EmployeeDetails("Dhanya","Kodiyan");
			
			System.out.println("Please enter the department from the following");
			System.out.println("1.Technical");
			System.out.println("2.Admin");
			System.out.println("3.Human Resource");
			System.out.println("4.Legal");
			int department = scanner.nextInt();
			
			if (department==1) {
				emp.setDepartment("Technical");
		
			}else if (department==2) {
				emp.setDepartment("admin");
			}else if (department==3) {
				emp.setDepartment("hr");
				}else if (department==4) {
					emp.setDepartment("legal");
					}
			
			
			String password = credentialService.generatepassword();
			emp.setpassword(password);
			String emailId = credentialService.generateEmailId(emp);
			emp.setEmailId(emailId);
			credentialService.showCredentials(emp);
	     }
	}


	 class EmployeeDetails {

	String FirstName;
	String LastName ;
	String EmailId ;
	String password;
	String department;
	public EmployeeDetails(String FirstName, String LastName) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
		
	}public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	public String getEmailId() {
		return EmailId;
		
	}
	   public void setEmailId(String EmailId)  {
		   this.EmailId = EmailId;
	   }
	   public String getDepartment() {
		   return department;
		   
	   }
	   public void setDepartment(String department) {
		   this.department =department;
	   }
	   public String getpassword() {
		   return password;
		   
	   }
	   public void setpassword(String password) {
		   this.password = password;
	   }
	    
	 }
	     class CredentialService{
		public String generatepassword() {
			String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
			Random random = new Random();
			StringBuilder stringBuilder = new StringBuilder(10);
			for (int i=0; i < 10;i++)
				stringBuilder.append(chars.charAt(random.nextInt(chars.length())));
			return stringBuilder.toString();
		}
		public String generateEmailId(EmployeeDetails employee) {
			String EmailId = employee.getFirstName() + employee.getLastName() + "@" +
		    employee.getDepartment() + "abc.com";
			return EmailId;
			
		}
		public void showCredentials(EmployeeDetails emp) {
		System.out.println("Dear" + emp.FirstName + "your generated credentials as follows");
		System.out.println("Email --->"+emp.getEmailId());
		System.out.println("password ---->" +emp.getpassword());
			
			
		}

}
