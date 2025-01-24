package com.krzole.manager_tools.player.dto;

import com.krzole.manager_tools.contract.dto.ContractRequestDTO;
import com.krzole.manager_tools.results.dto.ResultRequestDTO;
import com.krzole.manager_tools.stats.dto.StatsRequestDTO;
import java.time.LocalDate;

public record PlayerFullRequestDTO(
    String firstName,
    String lastName,
    LocalDate birthday,
    String nationality,
    String foot,
    Integer weight,
    Integer height,
    Integer minPotential,
    Integer maxPotential,
    ResultRequestDTO results,
    StatsRequestDTO stats,
    ContractRequestDTO contracts
) {

}
