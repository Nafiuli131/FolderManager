package com.example.FolderManager.BE.Controller;

import com.example.FolderManager.BE.Dto.FolderDto;
import com.example.FolderManager.BE.Service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fileManager/")
public class FolderController {
    @Autowired
    FolderService folderService;

    @PostMapping("/createFolder")
    public ResponseEntity<?> createFolder(@RequestBody FolderDto folderDto) {
        return folderService.createFolder(folderDto);
    }
    @DeleteMapping("deleteFolder/{id}")
    public ResponseEntity<?> deleteFolder(@PathVariable Long id){
        return folderService.deleteFolder(id);
    }

    @GetMapping("/getFolderDetails/{id}")
    public ResponseEntity<?> getFolderDetails(@PathVariable Long id){
        return folderService.getFolderDetails(id);
    }

    @GetMapping("/getAllFolderDetails")
    public ResponseEntity<?> getAllFolderDetails(){
        return folderService.getAllFolderDetails();
    }
}
