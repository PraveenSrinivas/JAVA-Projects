package com.jdbc.assignment.userdoa;

public interface SqlInterface {
	abstract boolean adduser(UserBean u);
	abstract boolean gettable();
	abstract boolean deleteuser(UserBean u);
	abstract boolean updateuser(UserBean u);
	abstract boolean readuser(UserBean u);
	abstract void closecon();
}
