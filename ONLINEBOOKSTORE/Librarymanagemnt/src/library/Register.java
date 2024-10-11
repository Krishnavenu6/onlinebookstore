package library;

public class Register {
	public Register(int rid, String password) {
		super();
		this.rid = rid;
		this.password = password;
	}

	public Register(int rid, String name, String regno, String dept, String password, String acctype) {
		super();// CREATING CONSTRUCTORS
		this.rid = rid;
		this.name = name;
		this.regno = regno;
		this.dept = dept;
		this.password = password;
		this.acctype = acctype;
	}

	private int rid;// CREATE GETTERS AND SETTERS FOR REGISTERED DATA
	private String name;
	private String regno;
	private String dept;
	private static String password;
	private String acctype;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

}
