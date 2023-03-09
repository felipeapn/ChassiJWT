package com.felipeapn.ChassiJWT;

import com.felipeapn.ChassiJWT.security.dto.UsuarioDTO;
import com.felipeapn.ChassiJWT.security.entity.Usuario;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class ChassiJwtApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ChassiJwtApplication.class, args);
	}

}
