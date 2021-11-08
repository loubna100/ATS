package com.MercureIt.GestionCandidats.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="upload")
public class uploadPath {

	
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
