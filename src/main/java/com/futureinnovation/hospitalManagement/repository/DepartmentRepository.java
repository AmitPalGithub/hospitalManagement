package com.futureinnovation.hospitalManagement.repository;

import com.futureinnovation.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}