package com.example.dboperations;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StdRepo extends JpaRepository<Student, Long> {

}
