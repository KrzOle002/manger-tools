package com.krzole.manager_tools.stats.dto;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;

public record StatsRequestDTO(int shirtNumber, int age, String position, int rating, int skillStars,
                              int weakFoot, int pace, int shooting, int passing, int dribbling,
                              int defending, int physical,
                              PlayerEntity player, SeasonEntity season) {

}
