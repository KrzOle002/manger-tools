package com.krzole.manager_tools.player;

import com.krzole.manager_tools.contract.ContractService;
import com.krzole.manager_tools.contract.entity.ContractEntity;
import com.krzole.manager_tools.player.dto.PlayerFullRequestDTO;
import com.krzole.manager_tools.player.dto.PlayerFullResponseDTO;
import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.results.ResultService;
import com.krzole.manager_tools.results.entity.ResultEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import com.krzole.manager_tools.stats.StatsService;
import com.krzole.manager_tools.stats.entity.StatsEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlayerService {

  private final PlayerRepository playerRepository;
  private final ContractService contractService;
  private final ResultService resultService;
  private final StatsService statsService;


  public PlayerService(PlayerRepository playerRepository,
      ContractService contractService, ResultService resultService, StatsService statsService) {
    this.playerRepository = playerRepository;
    this.contractService = contractService;
    this.resultService = resultService;
    this.statsService = statsService;
  }

  public PlayerFullResponseDTO addPlayer(PlayerFullRequestDTO playerFullRequestDTO,
      SeasonEntity seasonEntity) {
    PlayerEntity playerEntity = playerRepository.save(new PlayerEntity(playerFullRequestDTO));

    StatsEntity statsEntity = statsService.addStats(playerFullRequestDTO.stats(), playerEntity,
        seasonEntity);
    ResultEntity resultEntity = resultService.addResult(playerFullRequestDTO.results(),
        playerEntity, seasonEntity);
    ContractEntity contractEntity = contractService.addContract(playerFullRequestDTO.contracts(),
        playerEntity, seasonEntity);

    List<ResultEntity> resultEntities = new ArrayList<>();
    resultEntities.add(resultEntity);

    List<StatsEntity> statsEntities = new ArrayList<>();
    statsEntities.add(statsEntity);

    List<ContractEntity> contractEntities = new ArrayList<>();
    contractEntities.add(contractEntity);

    playerEntity.setResults(resultEntities);
    playerEntity.setStats(statsEntities);
    playerEntity.setContracts(contractEntities);

    return playerEntity.toPlayerFullResponseDTO();
  }

  public PlayerFullResponseDTO getPlayerFullResponseDTO(PlayerEntity playerEntity,
      SeasonEntity seasonEntity) {
    PlayerEntity player = playerRepository.getById(playerEntity.getId());

    return player.toPlayerFullResponseDTO();
  }
}
