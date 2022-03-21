package com.jpa.hibernate.jpademo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<KunalCourse, Long> {
	
	List<KunalCourse> findByNameAndId(String name, Long id);

	List<KunalCourse> findByName(String name);

	List<KunalCourse> countByName(String name);

	List<KunalCourse> findByNameOrderByIdDesc(String name);

	List<KunalCourse> deleteByName(String name);

	@Query("Select  c  From Course c where name like '%100 Steps'")
	List<KunalCourse> courseWith100StepsInName();

	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
	List<KunalCourse> courseWith100StepsInNameUsingNativeQuery();

	@Query(name = "query_get_100_Step_courses")
	List<KunalCourse> courseWith100StepsInNameUsingNamedQuery();
}