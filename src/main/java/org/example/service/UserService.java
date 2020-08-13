package org.example.service;

import org.example.model.Login;
import org.example.model.User;

public interface UserService {

	int register(User user);

	User validateUser(Login login);
}
