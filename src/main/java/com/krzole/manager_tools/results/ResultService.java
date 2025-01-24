package com.krzole.manager_tools.results;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.results.dto.ResultRequestDTO;
import com.krzole.manager_tools.results.entity.ResultEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

  private final ResultRepository resultRepository;

  @Autowired
  public ResultService(ResultRepository resultRepository) {
    this.resultRepository = resultRepository;
  }

  public ResultEntity addResult(ResultRequestDTO resultDTO, PlayerEntity playerEntity,
      SeasonEntity seasonEntity) {
    ResultEntity resultEntity = new ResultEntity(resultDTO);
    resultEntity.setPlayer(playerEntity);
    resultEntity.setSeason(seasonEntity);
    return resultRepository.save(resultEntity);
  }
}
