package com.krzole.manager_tools.contract.dto;

public record ContractResponseDTO(long id,
                                  int playerValue,
                                  int playerWage,
                                  String clubName,
                                  String clubNationality,
                                  int clubDivision) {

}
