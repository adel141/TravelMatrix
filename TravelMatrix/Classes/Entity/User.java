package Classes.Entity;

public class User 
{
	private String firstName;
	private String surName;
	private String userName;
	private String email;
	private String password;
	private String gender;

	public User(String firstName, String surName, String userName, String email, String password, String gender) 
	{  
		this.firstName = firstName;
		this.surName = surName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getSurName() 
	{
		return surName;
	}

	public String getUserName() 
	{
		return userName;
	}

	public String getEmail() 
	{
		return email;
	}

	public String getPassword() 
	{
		return password;
	}

	public String getGender() 
	{
		return gender;
	}
}
