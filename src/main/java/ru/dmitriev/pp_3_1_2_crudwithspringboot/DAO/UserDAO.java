package ru.dmitriev.pp_3_1_2_crudwithspringboot.DAO;

import ru.dmitriev.pp_3_1_2_crudwithspringboot.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
