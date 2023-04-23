public class User {
	private String loginName;
	private String password;
	
	class IncorrectPasswordException extends Exception {
	    private static final long serialVersionUID = 1L;

		public IncorrectPasswordException(String string) {
	        super("Incorrect password.");
	    }
	}

	public User(String loginName,String password) {
		this.loginName=loginName;
		this.password=password;
	}

	public String getLoginName() {
		return loginName;
	}

	public boolean checkPassword(String password) throws IncorrectPasswordException {
		if (this.password.equals(password)) {
			return true;
		} else {
			throw new IncorrectPasswordException("Incorrect password.");
		}
	}
}
