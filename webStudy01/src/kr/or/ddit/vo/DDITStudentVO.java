package kr.or.ddit.vo;

import java.io.Serializable;

/**
 * ValueObject-DataTransferObject-Model-JavaBean
 * 1. 값을 가질수 있는 속성(property, field) 
 * 2. 캡슐화된 데이터에 접근할 방법 제공(getter, setter)
 * 		get[set]ProertyName - carmel 표기 방식
 * 3. 상태 확인 메소드 제공 (toString)
 * 4. 객체의 상태 비교 메소드 제공(equals)
 * 5. 직렬화 가능.
 */
public class DDITStudentVO implements Serializable{
	private String code; // PK(식별성)
	private String name;
	private String birthday;
	private int age;
	private String grade;
	private String gen;
	private String[] license;
	private String career;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String[] getLicense() {
		return license;
	}
	public void setLicense(String[] license) {
		this.license = license;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "DDITStudentVO [name=" + name + ", birthday=" + birthday + ", age=" + age + ", grade=" + grade + ", gen="
				+ gen + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DDITStudentVO other = (DDITStudentVO) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
}
