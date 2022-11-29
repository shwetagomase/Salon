package Model;

public class AdminPojo {
	private int aid;
	private String  aname, agender, aemail, amobile, aaddress, apassword;
	
	
	public AdminPojo() {
		super();
	}
	public AdminPojo(String aname, String agender, String aemail, String amobile, String aaddress, String apassword) {
		super();
		this.aname = aname;
		this.agender = agender;
		this.aemail = aemail;
		this.amobile = amobile;
		this.aaddress = aaddress;
		this.apassword = apassword;
	}
	public AdminPojo(int aid, String aname, String agender, String aemail, String amobile, String aaddress,
			String apassword) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.agender = agender;
		this.aemail = aemail;
		this.amobile = amobile;
		this.aaddress = aaddress;
		this.apassword = apassword;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAgender() {
		return agender;
	}
	public void setAgender(String agender) {
		this.agender = agender;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAmobile() {
		return amobile;
	}
	public void setAmobile(String amobile) {
		this.amobile = amobile;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	

}
