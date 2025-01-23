package com.krzole.manager_tools.results.dto;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;

public record ResultRequestDTO(int matches, int goals, int assists, int cleanSheets,
                               int yellowCards,
                               int redCards, PlayerEntity player, SeasonEntity season) {

}
