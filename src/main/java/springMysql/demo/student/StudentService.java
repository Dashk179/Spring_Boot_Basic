package springMysql.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
boolean exits =    studenRepository.existsById(studentId);
if (!exits){
    throw new IllegalStateException("student with id " + studentId + "does not exits");
}
studenRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studenRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException( "student with id " + studentId + "does not exits"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studenRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}
