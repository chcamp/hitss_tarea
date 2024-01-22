package com.rol.dao.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.rol.entities.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ProductoServiceImpl(JdbcTemplate jdbcTemplate) {
		
		this.jdbcTemplate = jdbcTemplate;
		
	}
	

	@Override
	public List<Producto> findAll() {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("SP_EJEMPLO_HITSS")
				.withoutProcedureColumnMetaDataAccess()
				.returningResultSet("RESULT", BeanPropertyRowMapper.newInstance(Producto.class));
		
		Map<String, Object> result = jdbcCall.execute();
		
		@SuppressWarnings("unchecked")
		List<Producto> productos = (List<Producto>) result.get("RESULT");
		
		return productos;
		
	}


	@Override
	public Producto save(Producto producto) {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("SP_EJEM_HITSS_SAVE");
		
		SqlParameterSource inPams = new MapSqlParameterSource()
				.addValue("p_producto_id", producto.getId())
				.addValue("p_nombre", producto.getNombre())
				.addValue("p_codigo", producto.getCodigo())
				.addValue("p_precio", producto.getPrecio())
				.addValue("p_cantidad", producto.getCantidad())
				.addValue("p_marca", producto.getMarca());
		
		jdbcCall.execute(inPams);
		
		return producto;
	}

}
