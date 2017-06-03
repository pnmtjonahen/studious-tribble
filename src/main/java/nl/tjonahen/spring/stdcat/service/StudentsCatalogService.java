/*
 * Copyright (C) 2017 Philippe Tjon-A-Hen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.spring.stdcat.service;

import java.util.List;
import nl.tjonahen.spring.stdcat.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Philippe Tjon - A - Hen
 */
@Component
public class StudentsCatalogService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> read() {
        return studentRepository.findAll();
    }
    
    public void create(List<Student> students) {
        studentRepository.deleteAll();
        students.forEach((student) -> {
            studentRepository.save(student);
        });
    }
    
    public void create(Student cursist) {
        studentRepository.save(cursist);
    }

    public Student read(Long id) {
        return studentRepository.findOne(id);
    }

    public boolean update(Long id, Student updatedStudent) {
        final Student student = studentRepository.findOne(id);
        if (student != null) {
            student.setAcademicBackground(updatedStudent.getAcademicBackground());
            student.setName(updatedStudent.getName());
            student.setNationality(updatedStudent.getNationality());
            student.setSurname(updatedStudent.getSurname());
            student.setTitle(updatedStudent.getTitle());
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        final Student student = studentRepository.findOne(id);
        if (student != null) {
            studentRepository.delete(id);
            return true;
        }
        return false;
    }

}
