package library;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import library.Dbconnection;
import library.Register;

public class RegisterDao {
	Dbconnection dbconnection = new Dbconnection();
	bookDao book = new bookDao();

	public void RegisterUser(Register register) throws SQLException {
		if (register.getPassword() == null || register.getPassword().isEmpty()) {
			System.out.println("Registration failed. Password cannot be null or empty.");
		}
		String Query = "insert into Register values(?,?,?,?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);) {
			preparedstatement.setInt(1, register.getRid());
			preparedstatement.setString(2, register.getName());
			preparedstatement.setString(3, register.getRegno());
			preparedstatement.setString(4, register.getDept());
			preparedstatement.setString(5, register.getPassword());
			preparedstatement.setString(6, register.getAcctype());
			int rs = preparedstatement.executeUpdate();
			if (rs > 0) {
				System.out.println("REGISTER SUCCESSFULLY....!!");
				System.out.println("PLEASE SAVE REGISTRATION ID -: " + register.getRid());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}

		}
	}

	public void LoginUser(int rid, String pass) throws SQLException {
		String sql = "select * from Register where rid=? and Pass=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			preparedstatement.setInt(1, rid);
			preparedstatement.setString(2, pass);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				String storedPassword = resultSet.getString("pass");
				if (storedPassword.equals(pass)) {
					System.out.println("Login successfully-----!!!.");
					if (resultSet.getString(6).equals("ADMIN")) {
						boolean admin = true;
						while (admin) {
							System.out.println("----------------------ONLINE BOOK STORE DASHBOARD ADMIN-: "
									+ resultSet.getString(2) + "------------\n");
							System.out.println("PRESS 1-ADD BOOKS ");
							System.out.println("PRESS 2-DELETE BOOKS");
							System.out.println("PRESS 3-UPDATE BOOKS");
							System.out.println("PRESS 4-SEARCH BOOKS");
							System.out.println("PRESS 5-VIEW ALL BOOKS");
							System.out.println("PRESS 6-ADD STUDENT");
							System.out.println("PRESS 7-DELETE STUDENT");
							System.out.println("PRESS 8-UPDATE STUDENT");
							System.out.println("PRESS 9-SEARCH STUDENT");
							System.out.println("PRESS 10-VIEW ALL STUDENT");
							System.out.println("PRESS 11-VIEW ORDERS");
							System.out.println("PRESS 11-LOGOUT");

							System.out.println("...................ENTER THE OPTION .....................");
							Scanner sc = new Scanner(System.in);
							int adminoption = Integer.parseInt(sc.nextLine());
							switch (adminoption) {
							case 1:
								System.out.println("-----------ADD BOOKS----------");
								System.out.println("ENTER THE BOOK ID");
								int bid = Integer.parseInt(sc.nextLine());
								System.out.println("ENTER BOOK TITLE");
								String title = sc.nextLine();
								System.out.println("ENTER BOOK AUTHOR");
								String author = sc.nextLine();
								System.out.println("ENTER BOOK GENRE");
								String genre = sc.nextLine();
								System.out.println("ENTER BOOK PUBLICATION");
								String pub = sc.nextLine();
								System.out.println("ENTER BOOK QUANTITY");
								int qty = sc.nextInt();
								sc.nextLine();
								System.out.println("ENTER ABOUT THE BOOK BREIFLY");
								String about = sc.nextLine();
								book.Addbook(new bookinfo(bid, title, author, genre, pub, qty, about));
								break;
							case 2:
								System.out.println("-----------DELETE BOOKS----------");
								System.out.println("ENTER BOOK ID");
								int bid1 = sc.nextInt();
								book.deletebook(bid1);
								break;
							case 3:
								System.out.println("-----------UPDATE BOOKS----------");
								System.out.println("ENTER THE BOOK ID");
								int bid2 = Integer.parseInt(sc.nextLine());
								System.out.println("ENTER BOOK TITLE");
								String title1 = sc.nextLine();
								System.out.println("ENTER BOOK AUTHOR");
								String author1 = sc.nextLine();
								System.out.println("ENTER BOOK GENRE");
								String genre1 = sc.nextLine();
								System.out.println("ENTER BOOK PUBLICATION");
								String pub1 = sc.nextLine();
								System.out.println("ENTER THE QUANTITY");
								int qty1 = sc.nextInt();
								sc.nextLine();
								System.out.println("ENTER ABOUT THE BOOK BREIFLY");
								String about1 = sc.nextLine();
								book.Updatebook(new bookinfo(bid2, title1, author1, genre1, pub1, qty1, about1));
								break;
							case 4:
								System.out.println("-----------SEARCH BOOKS----------");
								System.out.println("ENTER BOOK TITLE");
								String title2 = sc.nextLine();
								book.Searchbook(title2);
								break;
							case 5:
								System.out.println("-----------VIEW ALL BOOKS----------");
								List<bookinfo> list = book.getallbooks();
								for (bookinfo b : list) {
									System.out.println("-----BOOK DETAILS-----");
									System.out.println("BOOKID=" + b.getBid());
									System.out.println("TITLE OF BOOK=" + b.getTitle());
									System.out.println("AUTHOR OF THE BOOK=" + b.getAuthor());
									System.out.println("GENRE OF THE BOOK=" + b.getGenre());
									System.out.println("Publication=" + b.getPub());
									System.out.println("Quantity=" + b.getQty());
									System.out.println("About=" + b.getAbout());
									System.out.println("----------------------------");
								}
								break;
							case 6:
								System.out.println("-----------ADD STUDENTS----------");
								System.out.println("ENTER STUDENT NAME");
								String sname = sc.nextLine();
								System.out.println("ENTER STUDENT REGISTRATION NUMBER");
								String sregno = sc.nextLine();
								System.out.println("ENTER STUDENT DEPARTMENT");
								String sdept = sc.nextLine();
								book.AddStudent(new student(sname, sregno, sdept));
								break;
							case 7:
								System.out.println("-----------DELETE STUDENTS----------");
								System.out.println("ENTER STUDENT REGISTRATION NUMBER");
								String sregno1 = sc.nextLine();
								book.deletestudent(sregno1);
								break;
							case 8:
								System.out.println("-----------UPDATE STUDENTS----------");
								System.out.println("ENTER STUDENT NAME");
								String sname1 = sc.nextLine();
								System.out.println("ENTER STUDENT REGISTRATION NUMBER");
								String sregno2 = sc.nextLine();
								System.out.println("ENTER DEPARTMENT NAME");
								String sdept1 = sc.nextLine();
								book.UpdateStudent(new student(sname1, sregno2, sdept1));
								break;
							case 9:
								System.out.println("-----------SEARCH STUDENTS----------");
								System.out.println("ENTER STUDENT REGISTRATION NUMBER");
								String sregno3 = sc.nextLine();
								book.Searchstudent(sregno3);
								break;
							case 10:
								System.out.println("-----------VIEW ALL STUDENTS----------");
								List<student> list1 = book.getallstudents();
								for (student s : list1) {
									System.out.println("-----STUDENT DETAILS-----");
									System.out.println("----------------------------");
									System.out.println("STUDENT NAME=" + s.getSname());
									System.out.println("STUDENT REGISTRATION NUMBER=" + s.getSreg());
									System.out.println("DEPARTMENT NAME=" + s.getSdep());
									System.out.println("----------------------------");
								}
								break;
							case 11:
								System.out.println("----------VIEW ORDERS----------------");

							case 12:
								admin = false;
								System.out.println("THANK YOU FOR USING MY ADMIN APPLICATION");

								break;
							default:
								System.out.println("INVALID OPTION");
							}
						}
					} else {
						System.out.println("-----------------WELCOME TO ONLINE BOOK STORE DASHBOARD USER-:"
								+ resultSet.getString(2) + "-----------\n");
						boolean user = true;
						while (user) {
							System.out.println("PRESS 1-VIEW BOOKS ");
							System.out.println("PRESS 2- SEARCH BOOKS");
							System.out.println("PRESS 3- BORROW BOOKS");
							System.out.println("PRESS 4- RETURNBOOKS");
							System.out.println("PRESS 5-FOR MORE E-BOOKS GO THROUGH LINK");
							System.out.println("PRESS 6- ORDER IN ADVANCE");
							System.out.println("PRESS 7- LOGOUT");
							System.out.println("...................ENTER THE OPTION .....................");
							Scanner sc = new Scanner(System.in);
							int useroption = Integer.parseInt(sc.nextLine());
							switch (useroption) {
							case 1:
								System.out.println("-----------VIEW ALL BOOKS----------");
								List<bookinfo> list = book.getallbook();
								for (bookinfo b : list) {
									System.out.println("-----BOOK DETAILS-----");
									System.out.println("BOOKID=" + b.getBid());
									System.out.println("TITLE OF BOOK=" + b.getTitle());
									System.out.println("AUTHOR OF THE BOOK=" + b.getAuthor());
									System.out.println("GENRE OF THE BOOK=" + b.getGenre());
									System.out.println("Publication=" + b.getPub());
									System.out.println("Quantity=" + b.getQty());
									System.out.println("About=" + b.getAbout());
									System.out.println("----------------------------");
								}
								break;
							case 2:
								System.out.println("-----------SEARCH BOOKS----------");
								System.out.println("ENTER BOOK TITLE");
								String title2 = sc.nextLine();
								book.Searchbooks(title2);
								break;
							case 3:
								System.out.println("---------BORROW BOOKS-------------");
								System.out.println("ENTER BOOK ID");
								int bookId = Integer.parseInt(sc.nextLine());
								System.out.println("HOW MANY BOOKS U WANT TO BORROW");
								int BorrowedBook = Integer.parseInt(sc.nextLine());
								book.borrowbooks1(bookId, BorrowedBook);
								break;
							case 4:
								System.out.println("-----------RETURN BOOKS--------------");
								System.out.println("Enter Student Name:");
								String studentName = sc.nextLine();
								System.out.println("Enter Book ID:");
								int bookId1 = sc.nextInt();
								System.out.println("Enter Quantity Borrowed:");
								int quantityBorrowed = sc.nextInt();
								book.returnBook(connection, studentName, bookId1, quantityBorrowed);
								break;
							case 5:
								System.out.println("----------VIEW  BOOK STORE FOE E-BOOKS--------------");
								Desktop desktop = Desktop.getDesktop();
								URI oURL1 = new URI("https://www.bookswagon.com");
								desktop.browse(oURL1);
								desktop.browse(oURL1);
							case 6:
								System.out.println("Enter your username:");
								String userName = sc.nextLine();
								System.out.println("Enter the book ID you want to order:");
								int bookId2 = sc.nextInt();
								System.out.println("Enter the quantity you want to order:");
								int quantity = sc.nextInt();
								sc.nextLine();
								Random random = new Random();
								int order_id = random.nextInt(99999);
								book.OrderInAdvance(connection, userName, bookId2, quantity, order_id);
								break;
							case 7:
								user = false;
								System.out.println("-------------LOGOUT OUT SUCCESSFULLY-----------");
								System.out.println("------------THANK FOR USING MY APPLICATION----------");
								break;
							default:
								System.out.println("INVALID OPTION");
								break;
							}
						}
					}
				} else {
					System.out.println("------------LOGIN FAILED!!!!!!---------------");
				}
			}
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void viewOrders(Connection connection) {
		// TODO Auto-generated method stub

	}
}
