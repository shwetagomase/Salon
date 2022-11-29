package Model;

public class ServicesPojo {
	private int sid;
	private String sname, spname, srate;
	
	
	public ServicesPojo() {
		super();
	}
	public ServicesPojo(String sname, String spname, String srate) {
		super();
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
	}
	public ServicesPojo(int sid, String sname, String spname, String srate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getSrate() {
		return srate;
	}
	public void setSrate(String srate) {
		this.srate = srate;
	}
}
