package com.example.FolderManager.BE.Service;

import com.example.FolderManager.BE.CustomError.ErrorResponse;
import com.example.FolderManager.BE.Dto.FolderDto;
import com.example.FolderManager.BE.Entity.Folder;
import com.example.FolderManager.BE.Repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class FolderService {
    @Autowired
    FolderRepository folderRepository;

    public ResponseEntity<?> createFolder(FolderDto folderDto) {
        Folder folder = new Folder();
        folder.setName(folderDto.getName());

        if (Objects.nonNull(folderDto.getParentFolderId())) {
            Optional<Folder> parentFolder = folderRepository.findById(folderDto.getParentFolderId());
            if (parentFolder.isPresent()) {
                folder.setParentFolder(parentFolder.get());
            } else {
                return ResponseEntity.ok(new ErrorResponse("Parent folder not found"));
            }
        }

        folderRepository.save(folder);
        return ResponseEntity.ok("Folder saved successfully");
    }

    public ResponseEntity<?> deleteFolder(Long id) {
        Optional<Folder> folder = folderRepository.findById(id);
        if(folder.isPresent()){
            folderRepository.delete(folder.get());
            return ResponseEntity.ok(new ErrorResponse("Folder deleted successfully"));
        }else{
            return ResponseEntity.ok(new ErrorResponse("Folder not found"));
        }
    }
}
