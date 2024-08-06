package edu.miu.cs.cs425.mystudentmgmtapp.service.impl;


import edu.miu.cs.cs425.mystudentmgmtapp.model.Course;
import edu.miu.cs.cs425.mystudentmgmtapp.repository.CourseRepository;
import edu.miu.cs.cs425.mystudentmgmtapp.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}





