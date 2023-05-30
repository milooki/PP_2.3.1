package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
     void add(User user);

     void delete(Long id);

     void update(Long id, User user);

     User getUser(Long id);

     List<User> getAllUser();
}
