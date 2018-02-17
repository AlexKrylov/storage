package ru.dbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbox.model.FileEntity;

@Repository
public interface FileRepo extends JpaRepository<FileEntity, Integer> {
}
