package library;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class userinfo {
	public static void main(String[] args) throws SQLException {
		RegisterDao reg = new RegisterDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------WELCOME TO ONLINE BOOK STORE -------------------------");
		boolean option = true;
		while (option) {
			System.out.println("PRESS 1 REGISTRATION ");
			System.out.println("PRESS 2 LOGIN");
			System.out.println("PRESS 3 EXIT");
			System.out.println("----------------------------ENTER THE OPTION-----------------------------");
			int inneroption = Integer.parseInt(sc.nextLine());
			switch (inneroption) {
			case 1:
				System.out.println("-----------------------------WELCOME TO REGISTRATION PANEL----------------------");
				System.out.println("ENTER THE USER NAME");
				String name = sc.nextLine();
				System.out.println("ENTER THE REGISTRATION NUMBER");
				String regno = sc.nextLine();
				System.out.println("ENTER THE DEPARTMENT NAME");
				String dept = sc.nextLine();
				System.out.println("CREATE PASSWORD");
				String password = sc.nextLine();
				System.out.println("ENTER THE ACCOUNT-TYPE " + " ADMIN or USER");
				String acctype = sc.nextLine();
				Random random = new Random();
				int regid = random.nextInt(99999);
				reg.RegisterUser(new Register(regid, name, regno, dept, password, acctype));
				break;
			case 2:
				System.out.println("-------------------WELCOME TO LOGIN PANEL---------------------\n");
				System.out.println("ENTER THE REGISTRATION ID");
				int rid = Integer.parseInt(sc.nextLine());
				System.out.println("ENTER THE PASSWORD");
				String pass = sc.nextLine();
				reg.LoginUser(rid, pass);
				break;
			case 3:
				option = false;
				System.out.println("THANK YOU .....!! " + "VISIT AGAIN...");
				break;

			default:
				System.out.println("INVALID OPTION");
				break;
			}
		}

	}
}
