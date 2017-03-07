package cn.edu.hust.highschoolexam;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String mUsername;
	private String mPassword;
	private String mName;
	private String mSid, mClass, mSchool,mType,mSex;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String name, String school, String type,
			String sex, String sid, String classs) {
		super();
		this.mUsername = username;
		this.mPassword = password;
		this.mName = name;
		this.mSid = sid;
		this.mClass = classs;
		this.mSchool = school;
		this.mType = type;
		this.mSex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchool() {
		return mSchool;
	}

	public void setSchool(String school) {
		this.mSchool = school;
	}

	public String getClasss() {
		return mClass;
	}

	public void setClass(String classs) {
		this.mClass = classs;
	}

	public String getUsername() {
		return mUsername;
	}

	public void setUsername(String username) {
		this.mUsername = username;
	}

	public String getPassword() {
		return mPassword;
	}

	public void setPassword(String password) {
		this.mPassword = password;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public String getSid() {
		return mSid;
	}

	public void setSid(String sid) {
		this.mSid = sid;
	}

	
	public void setSex(String sex) {
		this.mSex = sex;
	}

	public String getSex() {
		return mSex;
	}
	
	public void setType(String type) {
		this.mType = type;
	}

	public String getType() {
		return mType;
	}


}
