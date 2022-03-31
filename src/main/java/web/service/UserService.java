package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User showUser(int id);

    public void save(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
