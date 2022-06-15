package com.dh.clase23sClinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class Clase23sClinicaApplication {

	private static void cargarDB(){
		Connection connection = null;
		try{
			Class.forName("org.h2.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				connection.close();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		cargarDB();
		SpringApplication.run(Clase23sClinicaApplication.class, args);
	}

}
