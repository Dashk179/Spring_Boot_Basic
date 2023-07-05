package springMysql.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudenRepository repository){
        return args -> {
            Student arturo = new Student(
                    1L,
                    "Arturo",
                    "arturoperznoriega@gmail.com",
                    LocalDate.of(1994, Month.NOVEMBER,14)
            );
            Student briana = new Student(
                    2L,
                    "Briana",
                    "brianaserna@gmail.com",
                    LocalDate.of(1998, Month.NOVEMBER,11)
            );
            Student leo = new Student(
                    3L,
                    "leo",
                    "leo@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER,11)
            );
            repository.saveAll(
                    List.of(arturo,briana,leo)
            );
        };
    }
}
