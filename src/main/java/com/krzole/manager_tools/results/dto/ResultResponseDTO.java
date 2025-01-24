package com.krzole.manager_tools.results.dto;

public record ResultResponseDTO(int matches, int goals, int assists, int cleanSheets,
                                int yellowCards,
                                int redCards, long id) {

}
