package com.dhn.spring_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class SpringDemoApplication implements CommandLineRunner {
	@Autowired
	private DataSource datasource;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		showConnection();
	}

	private void showConnection() throws SQLException {
		log.info(datasource.toString());
		Connection conn = datasource.getConnection();
		log.info(conn.toString());
		conn.close();
	}
}
