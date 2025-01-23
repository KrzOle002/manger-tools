package com.krzole.manager_tools.contract.dto;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;

public record ContractResponseDTO(long id, PlayerEntity player, SeasonEntity season,
                                  int playerValue,
                                  int playerWage,
                                  String clubName,
                                  String clubNationality,
                                  int clubDivision) {

}
