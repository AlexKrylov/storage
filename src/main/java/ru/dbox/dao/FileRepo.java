package ru.dbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dbox.model.FileEntity;

@Repository
@Transactional
public interface FileRepo extends JpaRepository<FileEntity, Integer> {
}
