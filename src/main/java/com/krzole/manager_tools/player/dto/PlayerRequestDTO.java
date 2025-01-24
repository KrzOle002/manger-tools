package com.krzole.manager_tools.player.dto;

import java.time.LocalDate;

public record PlayerRequestDTO(String firstName, String lastName, LocalDate birthday,
                               String nationality,
                               String foot, Integer weight, Integer height, Integer minPotential,
                               Integer maxPotential) {

}
