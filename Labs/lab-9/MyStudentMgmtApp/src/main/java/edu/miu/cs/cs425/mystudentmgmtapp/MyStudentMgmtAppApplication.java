package edu.miu.cs.cs425.mystudentmgmtapp;

import edu.miu.cs.cs425.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmtapp.service.ClassroomService;
import edu.miu.cs.cs425.mystudentmgmtapp.service.CourseService;
import edu.miu.cs.cs425.mystudentmgmtapp.service.StudentService;
import edu.miu.cs.cs425.mystudentmgmtapp.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner{

	private StudentService studentService;
	private TranscriptService transcriptService;
	private ClassroomService classroomService;
	private CourseService courseService;


	public MyStudentMgmtAppApplication(StudentService studentService,
									   TranscriptService transcriptService,
									   ClassroomService classroomService,
									   CourseService courseService) {
		this.studentService = studentService;
		this.transcriptService = transcriptService;
		this.classroomService = classroomService;
		this.courseService = courseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


		Transcript transcript = new Transcript(1L, "BS Computer Science",null);
		transcriptService.saveTranscript(transcript);

		Classroom classroom = new Classroom(1L, "McLaughlin building", "M105", null);
		classroomService.saveClassroom(classroom);


		Course course = new Course(1L, "CS401", "Modern Prog Practices");
		courseService.saveCourse(course);


		Student student = new Student(1L, "000-61-0001", "Anna",
				"Lynn","Smith",
				3.45, LocalDate.of(2019,5,24),transcript, classroom, new ArrayList<>(List.of(course)));


		studentService.saveStudent(student);


		// update a student name
		studentService.updateStudentName(1L,"Mussie");
	}
}
