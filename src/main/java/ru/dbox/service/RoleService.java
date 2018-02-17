package ru.dbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbox.dao.RoleRepo;
import ru.dbox.model.RoleEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleService {
    @Autowired
    public RoleRepo roleRepo;

    public List<RoleEntity> getAllFiles() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(roleRepo.findAll().iterator(), Spliterator.NONNULL), false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
