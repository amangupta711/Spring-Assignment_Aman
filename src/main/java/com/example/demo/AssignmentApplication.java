package com.example.demo;

import org.springframework.boot.SpringApplication;
import com.example.demo.Course;
import com.example.demo.Student;
import com.example.demo.CourseRepository;
import com.example.demo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;




@SpringBootApplication
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {

 
            Book book = new Book("Spring", "Aman", "Aman123");

            

            bookRepository.save(book);



            pageRepository.save(new Page(1, "Index contents", "Index", book));
            pageRepository.save(new Page(65, "Boot contents", "Boot", book));
            pageRepository.save(new Page(95, "Hibernate contents", "Hibernate", book));

        };
    
	}
	
	@Bean
    public CommandLineRunner mappingDemo2(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            // create a student
            Student student = new Student("Aman Gupta", 21, "Btech");

            // save the student
            studentRepository.save(student);

            // create three courses
            Course course1 = new Course("Java", "ML", 12, 1500);
            Course course2 = new Course("Spring", "DS", 8, 1300);
            Course course3 = new Course("Angular", "WB", 10, 7800);

            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student
            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            // update the student
            studentRepository.save(student);
        };
    }

}
