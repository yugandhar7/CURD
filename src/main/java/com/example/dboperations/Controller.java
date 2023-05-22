package com.example.dboperations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    StdRepo stdRepo;

    @PostMapping("/data")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(stdRepo.save(student), HttpStatus.CREATED);

    }

    @GetMapping("/stdata")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(stdRepo.findAll(), HttpStatus.OK);

    }

    @GetMapping("stdata/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Optional<Student> student = stdRepo.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("stdata/{id}")
    public ResponseEntity<Student> updateStudents(@PathVariable long id, @RequestBody Student x) {
        Optional<Student> student = stdRepo.findById(id);
        if (student.isPresent()) {
            student.get().setStName(x.getStName());
            student.get().setStRollno(x.getStRollno());
            student.get().setStEmail(x.getStEmail());
            return new ResponseEntity<>(stdRepo.save(student.get()), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("stdata/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable long id) {
        Optional<Student> student = stdRepo.findById(id);
        if (student.isPresent()) {
            stdRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}
