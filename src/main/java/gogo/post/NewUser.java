package gogo.post;

public class NewUser {
//created a class to implement new user

public String email;
public String first_name;
public String last_name;
public String gender;

public void setEmail(String email)
{
	this.email = email;
	}
public void setFirst(String first_name)
{
	this.first_name = first_name;
	}
public void setLast(String last_name)
{
	this.last_name = last_name;
	}
public void setGender(String gender)
{
	this.gender = gender;
	}

public String getEmail()
{
	return this.email;
	}
public String getFirst()
{
	return this.first_name;
	}
public String getLast()
{
	return this.last_name;
	}
public String getGender()
{
	return this.gender;
	}


}

