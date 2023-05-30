package com.example.FolderManager.BE.Dto;

import com.example.FolderManager.BE.Entity.Folder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FolderDto {
    private String name;
    private Long parentFolderId;
}
