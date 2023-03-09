package az.developia.service;

import az.developia.LogVar;
import az.developia.repository.Repository;

public class Service {
Repository repository=new Repository();
public boolean check(String username,String password) {
	return repository.check(username,password);
}

}
