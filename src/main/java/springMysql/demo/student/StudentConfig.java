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
                    LocalDate.of(2023, Month.APRIL,14)
            );
            Student briana = new Student(
                    2L,
                    "Briana",
                    "brianaserna@gmail.com",
                    LocalDate.of(200, Month.NOVEMBER,11)
            );
            repository.saveAll(
                    List.of(arturo,briana)
            );
        };
    }
}
