package com.krzole.manager_tools.results.entity;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.results.dto.ResultRequestDTO;
import com.krzole.manager_tools.results.dto.ResultResponseDTO;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
@Table(name = "results")
public class ResultEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int matches;
  private int goals;
  private int assists;
  private int cleanSheets;
  private int yellowCards;
  private int redCards;
  @ManyToOne()
  @JoinColumn(name = "idPlayer", referencedColumnName = "id")
  private PlayerEntity player;

  @ManyToOne()
  @JoinColumn(name = "idSeason", referencedColumnName = "uid")
  private SeasonEntity season;

  public ResultEntity(ResultRequestDTO resultRequestDTO) {
    this.matches = resultRequestDTO.matches();
    this.goals = resultRequestDTO.goals();
    this.assists = resultRequestDTO.assists();
    this.cleanSheets = resultRequestDTO.cleanSheets();
    this.yellowCards = resultRequestDTO.yellowCards();
    this.redCards = resultRequestDTO.redCards();
    this.player = resultRequestDTO.player();
    this.season = resultRequestDTO.season();
  }

  public ResultEntity() {
  }

  public ResultResponseDTO toResultResponseDTO() {
    return new ResultResponseDTO(
        matches,
        goals,
        assists,
        cleanSheets,
        yellowCards,
        redCards,
        id);
  }
}

