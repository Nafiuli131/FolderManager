package com.example.FolderManager.BE.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileDTO {
    private String name;
    private String fileUrl;
    private Long folderId;
}
