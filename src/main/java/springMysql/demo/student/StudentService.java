package springMysql.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService  {
    private final StudenRepository studenRepository;

    public StudentService(StudenRepository studenRepository) {
        this.studenRepository = studenRepository;
    }

    public List<Student> getStudents() {
        return studenRepository.findAll();
    }
}
