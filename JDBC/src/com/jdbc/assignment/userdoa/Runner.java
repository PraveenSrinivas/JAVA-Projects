package com.jdbc.assignment.userdoa;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		String name,gender,col_name1,col_name2,cond,val1,val2;
		int age,i;
		long phoneno;
		boolean res=true;
		
		UserBean u = new UserBean();
		UserDoa user1 = new UserDoa();
		user1.getcon();
		user1.getdb();
		if(user1.con!=null)
			do {
				Scanner sc =new Scanner(System.in);
				Scanner  sc1 = new Scanner(System.in);
				System.out.println("\nEnter your choice");
				System.out.println("1.ADD user\t2.UPDATE user\t3.GET table data\t4.DELETE user\t5.READ user data\t6.EXIT");
				i=sc.nextInt();
				switch (i) {
				case 1:
					System.out.println("Enter details of user");
					System.out.println("Name : ");
					name = sc1.nextLine();
					System.out.println("Gender : ");
					gender = sc1.nextLine();
					System.out.println("Age : ");
					age = sc.nextInt();
					System.out.println("Phone number : ");
					phoneno = sc.nextLong();

					u.setName(name);
					u.setAge(age);
					u.setGender(gender);
					u.setPhoneno(phoneno);


					
					if(!user1.adduser(u))
						System.out.println("User Added Successfully");
					else
						System.out.println("Error while adding user");

					break;


				case 2:
					System.out.println("Enter the column name to be updated");
					col_name1 = sc1.nextLine();
					System.out.println("Enter the value for "+col_name1+" : ");
					val1 = sc1.nextLine();
					System.out.println("Enter the where condition");
					cond = sc1.nextLine();
					u.setCol_name(col_name1);
					u.setVal(val1);
					u.setCond(cond);
					res = user1.updateuser(u);
					if(res == false)
						System.out.println("User updated Successfully");
					else
						System.out.println("Error while updating user");

					break;


				case 3:
					user1.gettable();
					break;


				case 4:
					System.out.println("Enter the name of the user to be deleted");
					name = sc1.nextLine();
					u.setName(name);
					res = user1.deleteuser(u);
					if(res == false)
						System.out.println("User deleted successfully");
					else
						System.out.println("Error while deleting the user");
					break;


				case 5:
					System.out.println("Enter the name of the user whose data is to be displayed");
					name = sc1.nextLine();
					u.setName(name);
					res = user1.readuser(u);
					if(res == true)
						System.out.println("End of user data");
					else
						System.out.println("User data not available in the database");
					break;


				case 6:
					user1.closecon();
					System.out.println("Thank you for the visit. Good Bye");
					break;


				default: System.out.println("Enter valid input");
				break;
				}
			} while (i!=6);
	}

}
