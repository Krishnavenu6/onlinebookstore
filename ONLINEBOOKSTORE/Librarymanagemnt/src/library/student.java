package library;

public class student {
	private static String sname;
	private static String sreg;
	private static String sdep;

	public student() {
		super();
		this.sname = sname;
		this.sreg = sreg;
		this.sdep = sdep;
	}

	public student(String sname2, String sregno, String sdept) {

	}

	public static String getSname() {
		return sname;
	}

	public static void setSname(String sname) {
		student.sname = sname;
	}

	public static String getSreg() {
		return sreg;
	}

	public static void setSreg(String sreg) {
		student.sreg = sreg;
	}

	public static String getSdep() {
		return sdep;
	}

	public static void setSdep(String sdep) {
		student.sdep = sdep;
	}

}
