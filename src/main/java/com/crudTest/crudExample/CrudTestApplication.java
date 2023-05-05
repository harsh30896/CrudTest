package com.crudTest.crudExample;

import com.crudTest.crudExample.model.Employee;
import com.crudTest.crudExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudTestApplication{

	public static void main(String[] args) {
		SpringApplication.run(CrudTestApplication.class, args);
	}


}
