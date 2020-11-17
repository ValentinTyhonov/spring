package com.example.spring.service;

import com.example.spring.model.FileMultipart;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileMultipartService
{
    List<FileMultipart> findAllFiles();

    FileMultipart saveFile(MultipartFile file) throws IOException;

    FileMultipart getFile(String id) throws FileNotFoundException;
}
