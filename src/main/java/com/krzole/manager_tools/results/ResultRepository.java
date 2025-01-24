package com.krzole.manager_tools.results;

import com.krzole.manager_tools.results.entity.ResultEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

  Optional<ResultEntity> findByPlayerIdAndSeasonUid(Long playerId, int seasonUid);

}
