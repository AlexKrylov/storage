package ru.dbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbox.dao.UserRepo;
import ru.dbox.model.UserEntity;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    public UserRepo repository;
    public UserEntity userEntity;

    Collection collection;

    public List<UserEntity> getAll() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public UserEntity findUser (Integer id) {
        return repository.findOne(id);
    }
}
