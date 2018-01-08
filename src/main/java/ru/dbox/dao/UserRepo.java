package ru.dbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbox.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
}
