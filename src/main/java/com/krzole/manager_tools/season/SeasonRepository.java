package com.krzole.manager_tools.season;

import com.krzole.manager_tools.season.entity.SeasonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<SeasonEntity, Long> {

    List<SeasonEntity> findByName(String name);

    Page<SeasonEntity> findAllBy(Pageable pageable);

    boolean existsByName(String name);

}
