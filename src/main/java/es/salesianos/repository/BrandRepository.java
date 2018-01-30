package es.salesianos.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Brand;

@Repository
public class BrandRepository implements es.salesianos.repository.Repository<Brand>{
	
	private static Logger log = LogManager.getLogger(BrandRepository.class);
	
	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public void insert(Brand item) {
		String sql = "INSERT INTO CARBRANDS (name)" + "VALUES ( :name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", item.getName());
		namedJdbcTemplate.update(sql, params);
	}

	@Override
	public List<Brand> listAll() {
		String sql = "SELECT * FROM CARBRANDS";
		List<Brand> brands = template.query(sql, new BeanPropertyRowMapper<Brand>(Brand.class));
		return brands;

	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

}
