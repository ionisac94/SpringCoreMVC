package org.example.repository;

import org.example.model.Login;
import org.example.model.User;

public interface UserDao {

	int register(User user);

	User validateUser(Login login);
}
