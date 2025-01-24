package com.krzole.manager_tools.player;

import com.krzole.manager_tools.contract.ContractService;
import com.krzole.manager_tools.player.dto.PlayerFullRequestDTO;
import com.krzole.manager_tools.player.dto.PlayerFullResponseDTO;
import com.krzole.manager_tools.results.ResultService;
import com.krzole.manager_tools.season.SeasonService;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import com.krzole.manager_tools.stats.StatsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

  private final PlayerService playerService;
  private final SeasonService seasonService;

  public PlayerController(PlayerService playerService, SeasonService seasonService,
      ContractService contractService,
      ResultService resultService, StatsService statsService) {
    this.playerService = playerService;
    this.seasonService = seasonService;

  }

  @PostMapping(params = {"seasonUID"})
  public PlayerFullResponseDTO createPlayer(
      @RequestBody PlayerFullRequestDTO playerFullRequestDTO,
      @RequestParam(value = "seasonUID") int seasonUID) {

    SeasonEntity seasonEntity = seasonService.getSeasonByUID(seasonUID);
    return playerService.addPlayer(playerFullRequestDTO, seasonEntity);
  }
}
