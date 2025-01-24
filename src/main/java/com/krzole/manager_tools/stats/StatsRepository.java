package com.krzole.manager_tools.stats;

import com.krzole.manager_tools.stats.entity.StatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<StatsEntity, Long> {


}
