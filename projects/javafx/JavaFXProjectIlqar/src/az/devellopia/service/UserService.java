package az.devellopia.service;

import az.devellopia.User;
import az.devellopia.repository.UserRepository;

public class UserService {
UserRepository reporsitory=new UserRepository();
public void add(User user) {
	reporsitory.add(user);
}

public boolean check(String username,String password) {
return	reporsitory.checkData(username, password);
}
}
