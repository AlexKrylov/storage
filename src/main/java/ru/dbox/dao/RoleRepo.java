package ru.dbox.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dbox.model.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
}
