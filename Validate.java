package Controller;

public class Validate implements Parame{

	public static boolean ValidateNames(String names) {
		return names.matches(ERNames);
	}

	public static boolean ValidateAge(int age) {

		return String.valueOf(age).matches(ERAge);
	}

	public static boolean ValidateDNI(long dni) {

		return String.valueOf(dni).matches(ERCI);
	}
}
