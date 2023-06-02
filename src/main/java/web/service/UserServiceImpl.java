package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private final UserDao uD;

    @Autowired
    public UserServiceImpl(UserDao uD) {
        this.uD = uD;
    }

    @Override
    @Transactional
    public void add(User user) {
        uD.add(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        uD.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        uD.update(id, user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return uD.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return uD.getAllUser();
    }
}
