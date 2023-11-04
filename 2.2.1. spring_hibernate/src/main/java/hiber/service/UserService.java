package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User getToCar(String model, int series);

    List<User> listUsers();
}
