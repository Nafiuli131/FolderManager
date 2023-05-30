package com.example.FolderManager.BE.Repository;

import com.example.FolderManager.BE.Entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long> {
}
