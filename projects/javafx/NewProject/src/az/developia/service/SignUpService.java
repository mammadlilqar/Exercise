package az.developia.service;

import az.developia.LogVar;
import az.developia.repository.SignUpRepository;

public class SignUpService {
	SignUpRepository repository=new SignUpRepository();
	public void add(LogVar data) {
		repository.add(data);
	}
	public boolean checkData(String username) {
		
		return repository.checkData(username);
	}
	
}
