package Model;

public class AppointmentPojo 
{
	private int apid;
	private String sname, spname, srate, date, time,status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AppointmentPojo(String sname, String spname, String srate, String date, String time, String status) {
		super();
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	public AppointmentPojo() {
		super();
	}
	public AppointmentPojo(int apid, String sname, String spname, String srate, String date, String time,
			String status) {
		super();
		this.apid = apid;
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	public AppointmentPojo(String sname, String spname, String srate, String date, String time) {
		super();
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
		this.date = date;
		this.time = time;
	}
	public AppointmentPojo(int apid, String sname, String spname, String srate, String date, String time) {
		super();
		this.apid = apid;
		this.sname = sname;
		this.spname = spname;
		this.srate = srate;
		this.date = date;
		this.time = time;
	}
	public int getApid() {
		return apid;
	}
	public void setApid(int apid) {
		this.apid = apid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
