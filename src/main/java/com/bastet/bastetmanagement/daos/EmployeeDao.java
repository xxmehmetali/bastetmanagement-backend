package com.bastet.bastetmanagement.daos;

import com.bastet.bastetmanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDao extends JpaRepository<Employee, UUID> {

}
