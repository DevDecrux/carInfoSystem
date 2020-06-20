package com.tu.carinfocore.persistance.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodesEntityRepository extends JpaRepository<CodesEntity, Long> {

}
