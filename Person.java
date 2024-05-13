package Model;

import java.util.Arrays;

import LibreriaV2.Generica;

public class Person {

	private Generica<String,String> dp;
	private Generica<Integer,Long> dpe;
	
	private String photoPath;

	public Person() {
		dp = new Generica<>();
		dpe = new Generica<>();
	}

	public Person(String name, int age, long dni, String gender, String lvlest, String...hobb) {
		dp = new Generica<>(name,gender,lvlest);
		dp.loadElementos(hobb);
		dpe = new Generica<>(age, dni);

	}

	public String getName() {
		return dp.getA1();
	}
	public void setName(String name) {
		this.dp.setA1(name);
	}

	public int getAge() {
		return dpe.getA1();
	}

	public void setAge(int age) {
		this.dpe.setA1(age);
	}

	public long getDni() {
		return dpe.getA3();
	}

	public void setDni(long dni) {
		this.dpe.setA3(dni);
	}

	public String getGender() {
		return dp.getA2();
	}
	public void setGender(String gen) {
		this.dp.setA2(gen);
	}

	public String getLvlestudy() {
		return dp.getA3();
	}
	public void setLvlestudy(String gen) {
		this.dp.setA3(gen);
	}
	
	public String[] getHobbies() {
		return dp.getA5();
	}
	
	public void setHobbies(String...hobbies) {
	    this.dp.setA5(hobbies);
	}
	
	public void setLvlestudy(String...stu) {
		this.dp.setA5(stu);
	}
	
	public String getPhotoPath() {
        return photoPath;
    }
	
	public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

	@Override
	public String toString() {
		return "Person [getName()=" + getName() + ", getAge()=" + getAge() + ", getDni()=" + getDni() + ", getGender()="
				+ getGender() + ", getLvlestudy()=" + getLvlestudy() + ", getHobbies()=" + Arrays.toString(getHobbies())
				+ "]";
	}

	public String personalInfo() {
		String hobb = "";
		for (String h:getHobbies()) {
			hobb+=h+" ";
		}
		return String.format("%s;%d;%d;%s;%s;%s", getName(), getAge(), getDni(), getGender(), getLvlestudy(), hobb);
	}

}
