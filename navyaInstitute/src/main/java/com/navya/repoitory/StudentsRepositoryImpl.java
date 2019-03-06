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
import com.navya.entity.StudentReference;

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
					System.out.println("rs :" + rs);
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
		boolean flag = false;
		int result = 0;
		String sql = "INSERT INTO STUDENTS (ID,NAME,DOB,MOB,BATCHID,REFERENCE) VALUES (:id,:name,:dob,:mob,:batchId,:reference)";
		// check reference is is valid or not
		flag = checkReferenceId(student.getReference());
		//System.out.println("flag as: " + flag);
		Map<String, Object> param = new HashMap();
		param.put("id", student.getId());
		param.put("dob", student.getDob());
		param.put("batchId", student.getBatchId());
		param.put("mob", student.getMob());
		param.put("name", student.getName());
		param.put("reference", student.getReference());
		if (flag == true) {
			Thread t = new Thread(() -> {
				// increase the reference count in reference table
				String refId = student.getReference();
			//	System.out.println("ref in repo" + refId);
				checkReference(refId);
				// updateReferenceInformation();
			});
			t.start();
			result = jdbcTemplate.update(sql, param);
		}
		if (result == 0)
			try {
				throw new Exception("Student does not exist with id " + student.getReference());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return result + "";
	}

	private void checkReference(String reference) {
		String sql = "SELECT * FROM REFERENCE WHERE REFERENCEID = :reference";
		String sql1 = null;
		StudentReference ref = null;
		int count = 0;
		// boolean flag = false;
		Map<String, Object> param = new HashMap();
		param.put("reference", reference);
		try {
			ref = jdbcTemplate.queryForObject(sql, param, new StudentRefMapper());
		} catch (Exception e) {

			e.printStackTrace();
		}
		//System.out.println("dfsdfsd");
		if (ref != null) {
			count = ref.getCount() + 1;
			param.put("count", count);
		//	System.out.println("count :" + count);
		//	System.out.println("reference : "+reference);
			sql1 = "UPDATE REFERENCE SET COUNT = :count WHERE REFERENCEID = :reference ";
			jdbcTemplate.update(sql1, param);
			return;
		}
		// update the count to reference table...
		param.put("count", count+1);
		sql1 = "INSERT INTO REFERENCE (REFERENCEID,COUNT) VALUES (:reference,:count)";
		jdbcTemplate.update(sql1, param);
	}

	private final class StudentRefMapper implements RowMapper<StudentReference> {

		@Override
		public StudentReference mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			StudentReference ref = new StudentReference();
			ref.setReferenceId(rs.getString("referenceId"));
			ref.setCount(rs.getInt("count"));
			return ref;
		}

	}

	private boolean checkReferenceId(String reference) {
		// fetch all information from the database about students
		String sql = "SELECT * FROM STUDENTS WHERE ID = :reference";
		boolean flag = false;
		Map<String, Object> param = new HashMap();
		param.put("reference", reference);
		// System.out.println("reference : "+reference);
		try {
			if (!reference.isEmpty()) {
				jdbcTemplate.queryForObject(sql, param, new StudentMapper());
				flag = true;
			}
		} catch (Exception e) {
			flag = false;
			System.out.println("student does not exist");
			e.printStackTrace();
		}
		return flag;
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
