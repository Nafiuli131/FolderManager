package com.example.FolderManager.BE.Repository;

import com.example.FolderManager.BE.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
}
