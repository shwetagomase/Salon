package Model;

public class UserPojo {
	
	private int uid;
	private String uname, ugender, uemail, umobile, uaddress, upassword;
		
	public UserPojo() {
	}
	
	public UserPojo(String uname, String ugender, String uemail, String umobile, String uaddress, String upassword) {
		super();
		this.uname = uname;
		this.ugender = ugender;
		this.uemail = uemail;
		this.umobile = umobile;
		this.uaddress = uaddress;
		this.upassword = upassword;
	}
	public UserPojo(int uid, String uname, String ugender, String uemail, String umobile, String uaddress,
			String upassword) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.ugender = ugender;
		this.uemail = uemail;
		this.umobile = umobile;
		this.uaddress = uaddress;
		this.upassword = upassword;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUmobile() {
		return umobile;
	}
	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

}
