package com.navya.repoitory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.navya.entity.StudentReference;

@Repository
public class ReferenceRepositoryImpl implements ReferenceRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<StudentReference> getStudentReferences() {
		String sql = "SELECT * FROM REFERENCE";
		List<StudentReference> refList = jdbcTemplate.query(sql, new ReferenceMapper());
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

}
