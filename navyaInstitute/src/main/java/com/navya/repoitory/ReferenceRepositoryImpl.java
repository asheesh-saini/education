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
public class ReferenceRepositoryImpl implements ReferenceRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<StudentReference> getStudentReferences() {
		String sql = "SELECT * FROM REFERENCE";
		Map<String,Object> param = new HashMap();
		List<StudentReference> refList = jdbcTemplate.query(sql,param, new ReferenceMapper());
		return refList;
	}
	private final class ReferenceMapper implements RowMapper<StudentReference>{

		@Override
		public StudentReference mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentReference ref = new StudentReference();
			ref.setReferenceId(rs.getString("referenceid"));
			ref.setCount(rs.getInt("count"));
			return ref;
		}
		
	}
	
	public List<StudentEnity> getStudentRefList(String refId){
		String sql = "SELECT * FROM STUDENTS WHERE REFERENCE = :refId";
		Map<String,Object> param = new HashMap();
		param.put("refId",refId);
		return jdbcTemplate.query(sql, param, new StudentMapper());
	}
	
	private final class StudentMapper implements RowMapper<StudentEnity> {

		@Override
		public StudentEnity mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			StudentEnity student = new StudentEnity();
			// Address address = new Address();
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setBatchId(rs.getString("batchId"));
			student.setDob(rs.getString("dob"));
			student.setMob(rs.getString("mob"));
			student.setReference(rs.getString("reference"));
			return student;

		}
	}

}
