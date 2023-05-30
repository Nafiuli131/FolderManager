package com.example.FolderManager.BE.Controller;

import com.example.FolderManager.BE.Dto.FileDTO;
import com.example.FolderManager.BE.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fileManager/")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/createFile")
    public ResponseEntity<?> createFile(@RequestBody FileDTO fileDTO) {
        return fileService.createFile(fileDTO);
    }

    @GetMapping("/getFileDetails/{id}")
    public ResponseEntity<?> getFileDetails(@PathVariable Long id) {
        return fileService.getFileDetails(id);
    }

    @GetMapping("/getAllFileDetails")
    public ResponseEntity<?> getAllFileDetails() {
        return fileService.getAllFileDetails();
    }

    @DeleteMapping("deleteFile/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id){
        return fileService.deleteFile(id);
    }
}
