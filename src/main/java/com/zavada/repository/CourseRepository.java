package com.zavada.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zavada.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Query("SELECT c FROM Course c WHERE c.title = :title")
	Course findCourseByTitle(@Param("title") String title);
	
	@Query("SELECT c FROM Course c LEFT JOIN c.user u WHERE u.id = :id")
	List<Course> findAllCoursesByTeacher(@Param("id") int id);
}
