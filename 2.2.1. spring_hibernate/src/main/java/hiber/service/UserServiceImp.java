package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
   private final UserDao userDao;

   @Autowired
   private UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User findUser(String model, int series) {
      return userDao.findUser(model,series);
   }
}
