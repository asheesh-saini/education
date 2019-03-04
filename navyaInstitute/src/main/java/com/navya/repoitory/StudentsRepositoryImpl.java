package com.navya.repoitory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.navya.entity.StudentEnity;

@Repository
public class StudentsRepositoryImpl implements StudentsRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<StudentEnity> getAllStudent() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap();
		List<StudentEnity> studentList = jdbcTemplate.query("select * from students", params, new StudentMapper());
		return studentList;
	}

	private final class StudentMapper implements RowMapper<StudentEnity> {

		@Override
		public StudentEnity mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			try {
				if (rs == null) {	
					System.out.println("rs :"+ rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			StudentEnity student = new StudentEnity();
			// Address address = new Address();
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setBatchId(rs.getString("batchId"));
			student.setDob(rs.getString("dob"));
			student.setMob(rs.getString("mob"));
//			address.setHomeNo(rs.getString("homeNo"));
//			address.setCity("city");
//			address.setArea("area");
//			address.setState("state");
//			address.setPincode("pincode");
//			address.setStreetName("streetName");
//			//student.setAddress(address);
			return student;

		}
	}

	@Override
	public StudentEnity getStudentById(String id) {
		String sql = "select * from students where id = :id";
		Map<String, Object> params = new HashMap();
		params.put("id", id);
		StudentEnity student = jdbcTemplate.queryForObject(sql, params, new StudentMapper());
		return student;
	}

	@Override
	public String addStudent(StudentEnity student) {
		String sql = "INSERT INTO STUDENTS (ID,NAME,DOB,MOB,BATCHID,REFERENCE) VALUES (:id,:name,:dob,:mob,:batchId,:reference)";
		// create a thread
		Thread t = new Thread(() -> {
			String sql1 = "SELECT * FROM STUDENTS WHERE ID = :reference";
			Map<String, Object> paramRef = new HashMap();
			System.out.println("reference : "+student.getReference());
			paramRef.put("reference", student.getReference());
			try {
			jdbcTemplate.queryForObject(sql, paramRef, new StudentMapper());
			}
			catch(Exception e) {
				//set the flag to indicate whether to insert the data to reference table or not if 0 not otherwise yes.
				System.out.println("Student Id does not exist");
				e.printStackTrace();
			}
		});
		t.start();
		Map<String, Object> param = new HashMap();
		param.put("id", student.getId());
		param.put("dob", student.getDob());
		param.put("batchId", student.getBatchId());
		param.put("mob", student.getMob());
		param.put("name", student.getName());
		param.put("reference", student.getReference());
		int result = jdbcTemplate.update(sql, param);
		if (result == 0)
			try {
				throw new Exception("some problems");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result + "";
	}

	@Override
	public String deleteStudent(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM STUDENTS WHERE ID=:id";
		Map<String, Object> param = new HashMap();
		param.put("id", id);
		int result = jdbcTemplate.update(sql, param);
		return result + "";
	}

}
