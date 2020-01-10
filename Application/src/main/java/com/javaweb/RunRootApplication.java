package com.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.javaweb.common.filestorage.StorageProperties;


/**
 * @author DINH SY HUNG
 * @version 1.0
 * @since 2020-01-05
 */

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class RunRootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunRootApplication.class, args);
	}
}
