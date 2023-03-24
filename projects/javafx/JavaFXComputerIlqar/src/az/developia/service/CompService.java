package az.developia.service;

import java.util.ArrayList;

import az.developia.Computers;
import az.developia.repository.CompRepository;

public class CompService {

	private CompRepository compRepository=new CompRepository();
	public void add(Computers c) {
		compRepository.add(c);
	}
	public ArrayList<Computers> findAll() {
		
		return CompRepository.findAll();
	}
	public void delete(Integer id) {
		compRepository.delete(id);
		
	}
	public static void update(Computers computers) {
		CompRepository.update(computers);
		
	}
}
