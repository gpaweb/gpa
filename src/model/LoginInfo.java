package model;

public final class LoginInfo {

	private static String userName;
	private static String password;

	private LoginInfo() {

	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		LoginInfo.userName = userName;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		LoginInfo.password = password;
	}

}
