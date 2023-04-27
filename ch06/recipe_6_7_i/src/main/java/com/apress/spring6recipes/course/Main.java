package com.apress.spring6recipes.course;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.apress.spring6recipes.course.config.CourseConfiguration;

public class Main {

	public static void main(String[] args) {

		var cfg = CourseConfiguration.class;
		try (var context = new AnnotationConfigApplicationContext(cfg)) {
			var courseDao = context.getBean(CourseDao.class);

			var course = new Course();
			course.setTitle("Core Spring");
			course.setBeginDate(LocalDate.of(2007, 8, 1));
			course.setEndDate(LocalDate.of(2007, 9, 1));
			course.setFee(1000);

			System.out.println("\nCourse before persisting");
			System.out.println(course);

			courseDao.store(course);

			System.out.println("\nCourse after persisting");
			System.out.println(course);

			var courseId = course.getId();
			var courseFromDb = courseDao.findById(courseId);

			System.out.println("\nCourse fresh from database");
			System.out.println(courseFromDb);

			courseDao.delete(courseId);
		}
	}
}
