package edu.bionic.dao.mock;

import edu.bionic.dao.UserDao;
import edu.bionic.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Pavel on 007 07.09.17.
 */
public class UserDaoMock implements UserDao {
    private List<User> userStorage;

    @Override
    public User save(User user) {
        userStorage.add(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userStorage);
    }

    @Override
    public Optional<User> getById(int userId) {
        return userStorage.stream().filter(user -> user.getId() == userId).findAny();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return null;
    }
}
