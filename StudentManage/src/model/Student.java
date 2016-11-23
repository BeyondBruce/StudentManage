package model;

import java.util.Date;

//web端学生信息数据模型
public class Student {

	private int stuId;
	private String stuNo;
	private String stuName;
	private int gradeId = -1;
	private Date data;
	private String java;
	private String javaweb;
	private String android;
	private String English;
	private String stuDesc;
	private String gradeName;

	public Student() {
		super();
	}

	public Student(String stuNo, String stuName,int gradeId,Date data, String java,   String javaweb,String android,String English, String stuDesc) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.gradeId = gradeId;
		this.data = data;
		
		this.java = java;
		this.javaweb = javaweb;
		this.android = android;
		this.English = English;
		this.stuDesc = stuDesc;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getJavaweb() {
		return javaweb;
	}

	public void setJavaweb(String javaweb) {
		this.javaweb = javaweb;
	}

	public String getAndroid() {
		return android;
	}

	public void setAndroid(String android) {
		this.android = android;
	}

	public String getEnglish() {
		return English;
	}

	public void setEnglish(String english) {
		English = english;
	}

	public String getStuDesc() {
		return stuDesc;
	}

	public void setStuDesc(String stuDesc) {
		this.stuDesc = stuDesc;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
