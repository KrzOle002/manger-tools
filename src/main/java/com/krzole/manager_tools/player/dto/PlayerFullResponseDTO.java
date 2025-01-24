package com.krzole.manager_tools.player.dto;

import com.krzole.manager_tools.contract.dto.ContractResponseDTO;
import com.krzole.manager_tools.results.dto.ResultResponseDTO;
import com.krzole.manager_tools.stats.dto.StatsResponseDTO;
import java.time.LocalDate;

public record PlayerFullResponseDTO(long id, String firstName,
                                    String lastName,
                                    LocalDate birthday,
                                    String nationality,
                                    String foot,
                                    Integer weight,
                                    Integer height,
                                    Integer minPotential,
                                    Integer maxPotential,
                                    ResultResponseDTO results,
                                    StatsResponseDTO stats,
                                    ContractResponseDTO contracts) {

}
