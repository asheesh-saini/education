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
		Map<String,Object> params = new HashMap();
		List<StudentEnity> studentList = jdbcTemplate.query("select * from students", new StudentMapper());
		return studentList;
	}
	private final class StudentMapper implements RowMapper<StudentEnity>{

		@Override
		public StudentEnity mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			StudentEnity student = new StudentEnity();
			//Address address = new Address();
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

}
