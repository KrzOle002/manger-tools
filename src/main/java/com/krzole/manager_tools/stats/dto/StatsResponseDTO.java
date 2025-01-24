package com.krzole.manager_tools.stats.dto;

public record StatsResponseDTO(long id, int shirtNumber, int age, String position, int rating,
                               int skillStars,
                               int weakFoot, int pace, int shooting, int passing, int dribbling,
                               int defending, int physical) {

}
