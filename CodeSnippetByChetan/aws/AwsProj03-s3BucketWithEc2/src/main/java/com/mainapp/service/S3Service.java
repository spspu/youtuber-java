package com.mainapp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
	
	public void uploadFile(MultipartFile file) throws IOException;
	public byte[] downloadFile(String key);
	
	

}
