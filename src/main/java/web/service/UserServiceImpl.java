package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao uD = new UserDaoImpl();

    @Override
    @Transactional
    public void add(User user) {
        uD.add(user);
    }

    @Override
    @Transactional
    public void delete(Long id){
        uD.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        uD.update(id, user);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return uD.getUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return uD.getAllUser();
    }
}
