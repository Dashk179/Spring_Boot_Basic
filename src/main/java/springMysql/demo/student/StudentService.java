package springMysql.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {
    private final StudenRepository studenRepository;

    public StudentService(StudenRepository studenRepository) {
        this.studenRepository = studenRepository;
    }

    public List<Student> getStudents() {
        return studenRepository.findAll();
    }

    public void addNewStudent(Student student) {
          Optional<Student> studentOptional= studenRepository
                  .findStudentByEmail(student.getEmail());
          if (studentOptional.isPresent()){
              throw new IllegalStateException("email taken");
          }
          studenRepository.save(student);
    }
}
