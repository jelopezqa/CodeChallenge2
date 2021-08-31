package pojo;

import com.google.gson.annotations.SerializedName;

public class Employees {
	
	@SerializedName("id")
	private String eId;
	
	@SerializedName("email")
	private String eemail;
	
	@SerializedName("first_name")
	private String efname;
	
	@SerializedName("last_name")
	private String elname;
	
	@SerializedName("avatar")
	private String eavatar;

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEfname() {
		return efname;
	}

	public void setEfname(String efname) {
		this.efname = efname;
	}

	public String getElname() {
		return elname;
	}

	public void setElname(String elname) {
		this.elname = elname;
	}

	public String getEavatar() {
		return eavatar;
	}

	public void setEavatar(String eavatar) {
		this.eavatar = eavatar;
	}
	
	

}
