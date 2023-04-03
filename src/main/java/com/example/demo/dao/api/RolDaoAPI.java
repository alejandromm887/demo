package com.example.demo.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Rol;

public interface RolDaoAPI {
	public interface UsuarioDaoAPI extends JpaRepository<Rol, Long> {

		@Query(value="SELECT rol"
				+ "FROM rol"
				+ "WHERE (usuario = :id)",nativeQuery = true)
		List<Rol> obtenerRoles(@Param ("id") String user);
		
	}

	
	
	
}
