package com.bastet.bastetmanagement;

import com.bastet.bastetmanagement.daos.OccupationDao;
import com.bastet.bastetmanagement.models.Corporation;
import com.bastet.bastetmanagement.models.Currency;
import com.bastet.bastetmanagement.models.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class BastetmanagementApplication implements CommandLineRunner {

	@Autowired
	OccupationDao occupationDao;
	public static void main(String[] args) {
		SpringApplication.run(BastetmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Corporation corporation = occupationDao.findAll().get(0);
		corporation.getProjects();
	}
}
