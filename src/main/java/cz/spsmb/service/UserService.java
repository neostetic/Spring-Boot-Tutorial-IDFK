package cz.spsmb.service;

import cz.spsmb.entity.User;

public interface UserService {

    void signUpUser(String name, String password);

    User getUserByName(String userName);
}
