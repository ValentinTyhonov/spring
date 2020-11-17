package com.example.spring.controller;

import com.example.spring.model.FileMultipart;
import com.example.spring.service.FileMultipartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class FileMultipartController
{
    private FileMultipartService service;

    @Autowired
    public FileMultipartController(FileMultipartService service)
    {
        this.service = service;
    }

    @PostMapping("/uploadFile")
    public FileMultipart uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException
    {
        FileMultipart savedFileMultipart = service.saveFile(multipartFile);

        return savedFileMultipart;
    }

    @GetMapping("/files")
    public List<FileMultipart> findAllFiles()
    {
        return service.findAllFiles();
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") String id) throws FileNotFoundException
    {
        FileMultipart fileMultipart = service.getFile(id);

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment ; fileName=\"" + fileMultipart.getFileName() + "\"")
            .body(new ByteArrayResource(fileMultipart.getData()));
    }



}
