package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class bookDao {
	static Dbconnection dbconnection = new Dbconnection();

	public void Addbook(bookinfo Bookinfo) throws SQLException {
		String Query = "insert into BookData values(?,?,?,?,?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);) {
			preparedstatement.setInt(1, bookinfo.getBid());
			preparedstatement.setString(2, bookinfo.getTitle());
			preparedstatement.setString(3, bookinfo.getAuthor());
			preparedstatement.setString(4, bookinfo.getGenre());
			preparedstatement.setString(5, bookinfo.getPub());
			preparedstatement.setInt(6, bookinfo.getQty());
			preparedstatement.setString(7, bookinfo.getAbout());
			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("ADDED BOOK SUCCESSFULLY-: " + bookinfo.getTitle());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}

		}
	}

	public void deletebook(int bid1) throws SQLException {
		String query = "delete from BookData where bid=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(query);) {
			preparedstatement.setInt(1, bid1);
			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("BOOK DELETED SUCCESSFULLY CHECK IN VIEW BOOK IT GET DELETED");
			} else {
				System.out.println("SOMETHING WENT WRONG");
			}
		}
	}

	public void Updatebook(bookinfo Bookinfo) throws SQLException {
		String Query = "update BookData set title=?,author=?,genre=?,pub=?,qty=?,about=? where bid=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);) {
			preparedstatement.setString(1, bookinfo.getTitle());
			preparedstatement.setString(2, bookinfo.getAuthor());
			preparedstatement.setString(3, bookinfo.getGenre());
			preparedstatement.setString(4, bookinfo.getPub());
			preparedstatement.setInt(5, bookinfo.getQty());
			preparedstatement.setString(6, bookinfo.getAbout());
			preparedstatement.setInt(7, bookinfo.getBid());
			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("UPDATED BOOK SUCCESSFULLY-: " + bookinfo.getTitle());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}

		}
	}

	public void Searchbook(String title2) throws SQLException {
		String sql = "select * from BookData where title=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			preparedstatement.setString(1, title2);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("YOUR BOOK FOUND SUCCESSFULLY-:" + resultSet.getString(2));
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}
		}

	}

	public List<bookinfo> getallbooks() throws SQLException {
		List<bookinfo> list = new ArrayList();
		bookinfo b = null;
		String sql = "select * from BookData";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				b = new bookinfo();
				b.setBid(resultSet.getInt(1));
				b.setTitle(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setGenre(resultSet.getString(4));
				b.setPub(resultSet.getString(5));
				b.setQty(resultSet.getInt(6));
				b.setAbout(resultSet.getString(7));
				list.add(b);
			}
		}
		return list;
	}

	public void AddStudent(student Student) throws SQLException {
		String Query = "insert into Studentdata values(?,?,?)";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);) {
			preparedstatement.setString(1, student.getSname());
			preparedstatement.setString(2, student.getSreg());
			preparedstatement.setString(3, student.getSdep());

			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("ADDED STUDENT SUCCESSFULLY-: " + student.getSname());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}

		}
	}

	public void deletestudent(String sregno1) throws SQLException {
		String query = "delete from Studentdata where sregno=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(query);) {
			preparedstatement.setString(1, sregno1);
			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("BOOK DELETED SUCCESSFULLY CHECK IN VIEW BOOK IT GET DELETED");
			} else {
				System.out.println("SOMETHING WENT WRONG");
			}
		}
	}

	public void UpdateStudent(student Student) throws SQLException {
		String Query = "update Studentdata set sname=?,sdept=? where sregno=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(Query);) {
			preparedstatement.setString(1, student.getSname());
			preparedstatement.setString(2, student.getSdep());
			preparedstatement.setString(3, student.getSreg());
			int rows = preparedstatement.executeUpdate();
			if (rows > 0) {
				System.out.println("UPDATED STUDENT SUCCESSFULLY-: " + student.getSname());
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}

		}
	}

	public void Searchstudent(String sregno3) throws SQLException {
		String sql = "select * from Studentdata where sregno=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			preparedstatement.setString(1, sregno3);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("STUDENT FOUND SUCCESSFULLY-:" + resultSet.getString(1));
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}
		}

	}

	public List<student> getallstudents() throws SQLException {
		List<student> list1 = new ArrayList();
		student s = null;
		String sql = "select * from Studentdata";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				s = new student();
				s.setSname(resultSet.getString(1));
				s.setSreg(resultSet.getString(2));
				s.setSdep(resultSet.getString(3));
				list1.add(s);
			}
		}
		return list1;
	}

	public List<bookinfo> getallbook() throws SQLException {
		List<bookinfo> list = new ArrayList();
		bookinfo b = null;
		String sql = "select * from BookData";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				b = new bookinfo();
				b.setBid(resultSet.getInt(1));
				b.setTitle(resultSet.getString(2));
				b.setAuthor(resultSet.getString(3));
				b.setGenre(resultSet.getString(4));
				b.setPub(resultSet.getString(5));
				b.setQty(resultSet.getInt(6));
				b.setAbout(resultSet.getString(7));
				list.add(b);
			}
		}
		return list;
	}

	public void Searchbooks(String title2) throws SQLException {
		String sql = "select * from BookData where title=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);) {
			preparedstatement.setString(1, title2);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("YOUR BOOK FOUND SUCCESSFULLY-:" + resultSet.getString(2));
			} else {
				System.out.println("SOMETHING WENT WRONG.....");
			}
		}

	}

	public void borrowbooks1(int bookId, int BorrowedBook) throws SQLException {
		String sql = "SELECT * FROM BookData WHERE bid=? AND qty>=?";
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, bookId);
			preparedStatement.setInt(2, BorrowedBook);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Scanner sc = new Scanner(System.in);
				System.out.println("ENTER THE STUDENT NAME");
				String student_name = sc.nextLine();

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date currentDate = new Date();
				String dueDateStr = dateFormat.format(new Date(currentDate.getTime() + 14 * 24 * 60 * 60 * 1000));

				String insertSql = "INSERT INTO borrow (student_name, book_id, quantity_borrowed, borrow_date, due_date) VALUES (?, ?, ?, ?, ?)";
				try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
					insertStatement.setString(1, student_name);
					insertStatement.setInt(2, bookId);
					insertStatement.setInt(3, BorrowedBook);
					insertStatement.setDate(4, new java.sql.Date(currentDate.getTime()));
					insertStatement.setDate(5, java.sql.Date.valueOf(dueDateStr));
					insertStatement.executeUpdate();

					System.out.println("BOOK BORROWED SUCCESSFULLY");

					String updateSql = "UPDATE BookData SET qty = qty - ? WHERE bid = ?";
					try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
						updateStatement.setInt(1, bookId);
						updateStatement.setInt(2, BorrowedBook);
						updateStatement.executeUpdate();
					}

					System.out.println("BOOK BORROWED AND QUANTITY OF BOOKS UPDATED IN DATABASE SUCCESSFULLY");
					System.out.println("SUBMIT WITHIN DUE DATE");
					viewBorrowTable(connection, student_name);
				}
			}
		}
	}

	public void viewBorrowTable(Connection connection, String student_name) throws SQLException {
		String selectSql = "SELECT * FROM borrow where student_name=? ";
		try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
			selectStatement.setString(1, student_name);
			try (ResultSet resultSet = selectStatement.executeQuery()) {
				System.out.println("------------BORROWED BOOKS DATA-----------------");
				while (resultSet.next()) {
					System.out.println("Student Name: " + resultSet.getString("student_name"));
					System.out.println("Book ID: " + resultSet.getInt("book_id"));
					System.out.println("Quantity Borrowed: " + resultSet.getInt("quantity_borrowed"));
					System.out.println("Borrow Date: " + resultSet.getDate("borrow_date"));
					System.out.println("Due Date: " + resultSet.getDate("due_date"));
					System.out.println("---------------");
				}
			}
		}

	}

	public void returnBook(Connection connection, String studentName, int bookId1, int quantityBorrowed)
			throws SQLException {
		String selectSql = "SELECT * FROM borrow WHERE student_name=? AND book_id=? AND quantity_borrowed=?";
		try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
			selectStatement.setString(1, studentName);
			selectStatement.setInt(2, bookId1);
			selectStatement.setInt(3, quantityBorrowed);

			try (ResultSet resultSet = selectStatement.executeQuery()) {
				if (resultSet.next()) {
					Date dueDate = resultSet.getDate("due_date");
					double fineAmount = calculateFine(dueDate);

					if (fineAmount > 0) {
						System.out.println("Book returned after due date. Fine applied: " + fineAmount + " rupees.");

						incrementStudentData(connection, studentName, fineAmount);
					} else {
						System.out.println("Book returned on time. No fine applied.");
					}

					incrementBookData(connection, bookId1, quantityBorrowed);

					deleteBorrowEntry(connection, studentName, bookId1, quantityBorrowed);

					System.out.println("Book returned successfully.");
				} else {
					System.out.println("No such book is borrowed by the specified student.");
				}
			}
		}
	}

	private double calculateFine(Date dueDate) {
		long millisecondsPerDay = 24 * 60 * 60 * 1000;
		long currentDateMillis = System.currentTimeMillis();
		long dueDateMillis = dueDate.getTime();

		int daysLate = (int) Math.max(0, (currentDateMillis - dueDateMillis) / millisecondsPerDay);

		return daysLate * 2;
	}

	private void incrementStudentData(Connection connection, String studentName, double fineAmount)
			throws SQLException {
		String updateSql = "UPDATE StudentData SET fines = fines + ? WHERE student_name = ?";
		try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
			updateStatement.setDouble(1, fineAmount);
			updateStatement.setString(2, studentName);
			updateStatement.executeUpdate();
		}
	}

	private void incrementBookData(Connection connection, int bookId1, int quantityBorrowed) throws SQLException {
		String updateSql = "UPDATE BookData SET qty = qty + ? WHERE bid = ?";
		try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
			updateStatement.setInt(1, quantityBorrowed);
			updateStatement.setInt(2, bookId1);
			updateStatement.executeUpdate();
			System.out.println("------BOOK DATA INCREMENTED SUCCESSFULLY-----------");
		}
	}

	private void deleteBorrowEntry(Connection connection, String studentName, int bookId1, int quantityBorrowed)
			throws SQLException {
		String deleteSql = "DELETE FROM borrow WHERE student_name=? AND book_id=? AND quantity_borrowed=?";
		try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			deleteStatement.setString(1, studentName);
			deleteStatement.setInt(2, bookId1);
			deleteStatement.setInt(3, quantityBorrowed);
			deleteStatement.executeUpdate();
			System.out.println(
					"---------IF THERE IS RETURNED ON TIME NO FINE-----YOUR BOOK DATA CAN BE REMOVED FROM BORROW TABLE------------");
		}
	}

	public static void OrderInAdvance(Connection connection, String userName, int bookId2, int quantity, int order_id)
			throws SQLException {
		String insertSql = "INSERT INTO Orders (user_name, book_id, quantity, stat) VALUES (?, ?, ?, 'PENDING')";
		try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
			insertStatement.setString(1, userName);
			insertStatement.setInt(2, bookId2);
			insertStatement.setInt(3, quantity);
			insertStatement.executeUpdate();
			System.out.println("Order placed in advance successfully.");
			vieworderTable(connection, order_id);
		}
	}

	public static void vieworderTable(Connection connection, int order_id) throws SQLException {
		String selectSql = "SELECT * FROM Orders where order_id=? ";
		try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
			selectStatement.setInt(1, order_id);
			try (ResultSet resultSet = selectStatement.executeQuery()) {
				System.out.println("------------VIEW ORDER BOOKS DATA-----------------");
				while (resultSet.next()) {
					System.out.println("Student Name: " + resultSet.getString("order_id"));
					System.out.println("Book ID: " + resultSet.getInt("user_name"));
					System.out.println("Quantity Borrowed: " + resultSet.getInt("book_id"));
					System.out.println("Borrow Date: " + resultSet.getDate("quantity"));
					System.out.println("---------------");
				}
			}
		}

	}

}