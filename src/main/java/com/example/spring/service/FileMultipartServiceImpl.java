package com.example.spring.service;

import com.example.spring.model.FileMultipart;
import com.example.spring.repository.FileMultipartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class FileMultipartServiceImpl implements FileMultipartService
{
    private FileMultipartRepository repository;

    @Autowired
    public FileMultipartServiceImpl(FileMultipartRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<FileMultipart> findAllFiles()
    {
        return repository.findAll();
    }

    @Override
    public FileMultipart saveFile(MultipartFile file) throws IOException
    {
        System.out.println("Original filename : " + file.getOriginalFilename());
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println("Cleaned filename : " + filename);
        FileMultipart fileMultipart = new FileMultipart(filename, file.getContentType(), file.getSize(), file.getBytes());
        return repository.save(fileMultipart);
    }

    @Override
    public FileMultipart getFile(String id) throws FileNotFoundException
    {
        return repository.findById(id).orElseThrow(FileNotFoundException::new);
    }
}
