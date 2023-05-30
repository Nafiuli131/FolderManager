package com.example.FolderManager.BE.Service;

import com.example.FolderManager.BE.CustomError.ErrorResponse;
import com.example.FolderManager.BE.Dto.FileDTO;
import com.example.FolderManager.BE.Entity.File;
import com.example.FolderManager.BE.Entity.Folder;
import com.example.FolderManager.BE.Repository.FileRepository;
import com.example.FolderManager.BE.Repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;

    public ResponseEntity<?> createFile(FileDTO fileDTO) {
        File file = new File();
        file.setName(fileDTO.getName());
        file.setFileUrl(fileDTO.getFileUrl());

        if (Objects.nonNull(fileDTO.getFolderId())) {
            Optional<Folder> folder = folderRepository.findById(fileDTO.getFolderId());
            if (folder.isPresent()) {
                file.setFolder(folder.get());
                fileRepository.save(file);
                return ResponseEntity.ok("File saved successfully");
            } else {
                return ResponseEntity.ok(new ErrorResponse("Folder not found"));
            }
        } else {
            return ResponseEntity.ok(new ErrorResponse("Folder Id must not be null"));
        }
    }

    public ResponseEntity<?> getFileDetails(Long id){
        Optional<File> file = fileRepository.findById(id);
        if(file.isPresent()){
            return ResponseEntity.ok(file.get());
        }else{
            return ResponseEntity.ok(new ErrorResponse("File not found"));
        }
    }

    public ResponseEntity<?> getAllFileDetails() {
        List<File> fileList = fileRepository.findAll();
        return ResponseEntity.ok(fileList);
    }

    public ResponseEntity<?> deleteFile(Long id) {
        Optional<File> file = fileRepository.findById(id);
        if(file.isPresent()){
            fileRepository.delete(file.get());
            return ResponseEntity.ok("File deleted successfully");
        }else{
            return ResponseEntity.ok(new ErrorResponse("File not found"));
        }
    }
}
