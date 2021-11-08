package com.MercureIt.GestionCandidats.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MercureIt.GestionCandidats.exceptions.StorageException;

import lombok.var;
@Service
public class FilesService {

	



    @Value("${upload.path}")
    private String uploadpath;
    
    @PostConstruct
    public void init() {
        try {
        
            Files.createDirectories(Paths.get(uploadpath+"\\cv"));
            System.out.println("creat");
        } catch (IOException e) {
            System.out.println("not create");
            throw new RuntimeException("Could not create upload folder!");
        }
    }
    public void save(MultipartFile file) {
        try {
            Path root = Paths.get(uploadpath);
            if (!Files.exists(root)) {
                init();
                System.out.println("not exist");
            }
       Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

}

