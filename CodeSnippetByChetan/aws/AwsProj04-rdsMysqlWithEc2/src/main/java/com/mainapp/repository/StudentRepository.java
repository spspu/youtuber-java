package com.mainapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainapp.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>{

}
