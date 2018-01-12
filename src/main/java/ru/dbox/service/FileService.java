package ru.dbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbox.dao.FileRepo;
import ru.dbox.model.FileEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FileService {
    @Autowired
    public FileRepo repository;

    public List<FileEntity> getAllFiles() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL), false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public void addFile(FileEntity entity) {
        repository.saveAndFlush(entity);
    }

    public FileEntity getFileByUrl(String url) {
        return repository.findByUrl(url);
    }


}
