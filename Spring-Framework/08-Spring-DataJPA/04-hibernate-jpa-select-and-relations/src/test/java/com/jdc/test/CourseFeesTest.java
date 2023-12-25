package com.jdc.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Course;
import com.jdc.entity.CourseFees;
import com.jdc.entity.Register;
import com.jdc.entity.dto.StudentCountByClassRoomDto;

public class CourseFeesTest extends HibernateFactory{

	@Test
	@Order(1)
	void test_many_to_one() {
		var em = emf.createEntityManager();
		var fee = em.find(CourseFees.class, 1);
		System.out.println(fee.getCourse().getName());
	}
	
	@Test
	@Order(2)
	void jpql_with_many_to_one() {
		var em = emf.createEntityManager();
		var query = em.createQuery("select cf from CourseFees cf where lower(cf.course.name) = lower(:name)", CourseFees.class);
		
		query.setParameter("name", "java");
		
		var stream = query.getResultStream();
		stream.map(cf -> cf.getFees()).forEach(f -> System.out.println(f));
		
	}
	
	@Test
	@Order(3)
	void jpql_with_one_to_many() {
		var em = emf.createEntityManager();
		var query = em.createQuery("select c from Course c join c.courseFees cf where cf.fees >= :fees", Course.class);
		
		query.setParameter("fees", 250000);
		
		var list = query.getResultList();
		
		System.out.println(list.size());
		
	}
	
	@Test
	@Order(4)
	void jpql_with_register() {
		var em = emf.createEntityManager();
		var query = em.createQuery("select r from Register r", Register.class);
		var list = query.getResultList();
		list.forEach(r -> 
		System.out.println("Student_Name :%s\t Class_room :%s\t Course :%s\t"
				.formatted(r.getStudent().getName(),
						r.getClassroom().getName(),
						r.getCourse().getName())));
	}
	
	@Test
	@Order(5)
	void jpql_with_register_and_dto() {
		var em = emf.createEntityManager();
		var query = em.createQuery("""
				select new com.jdc.entity.dto.StudentCountByClassRoomDto(r.classroom.name, r.classroom.createDate, count(distinct(r.student.id)) as Student_Count) 
				from Register r group by r.classroom.name, r.classroom.createDate
				""", StudentCountByClassRoomDto.class);
		var list = query.getResultList();
		list.forEach(r -> 
		System.out.println("Student_Name :%s\t Class_room :%s\t Course :%s\t"
				.formatted(r.name(),
						r.date(),
						r.studentCount())));
	}

}
