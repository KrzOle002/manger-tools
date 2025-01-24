package com.krzole.manager_tools.stats;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import com.krzole.manager_tools.stats.dto.StatsRequestDTO;
import com.krzole.manager_tools.stats.entity.StatsEntity;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

  private final StatsRepository statsRepository;

  public StatsService(StatsRepository statsRepository) {
    this.statsRepository = statsRepository;
  }

  public StatsEntity addStats(StatsRequestDTO statsDTO, PlayerEntity playerEntity,
      SeasonEntity seasonEntity) {

    StatsEntity statsEntity = new StatsEntity(statsDTO);
    statsEntity.setPlayer(playerEntity);
    statsEntity.setSeason(seasonEntity);
    statsRepository.save(statsEntity);

    return statsRepository.save(statsEntity);
  }
}
