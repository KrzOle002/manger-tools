package com.krzole.manager_tools.player.entity;

import com.krzole.manager_tools.contract.dto.ContractResponseDTO;
import com.krzole.manager_tools.contract.entity.ContractEntity;
import com.krzole.manager_tools.player.dto.PlayerFullRequestDTO;
import com.krzole.manager_tools.player.dto.PlayerFullResponseDTO;
import com.krzole.manager_tools.player.dto.PlayerRequestDTO;
import com.krzole.manager_tools.player.dto.PlayerResponseDTO;
import com.krzole.manager_tools.results.dto.ResultResponseDTO;
import com.krzole.manager_tools.results.entity.ResultEntity;
import com.krzole.manager_tools.stats.dto.StatsResponseDTO;
import com.krzole.manager_tools.stats.entity.StatsEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Entity
@Setter
@Slf4j
@Table(name = "players")
public class PlayerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private LocalDate birthday;
  private String nationality;
  private String foot;
  private Integer height;
  private Integer weight;
  private Integer minPotential;
  private Integer maxPotential;

  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<StatsEntity> stats;
  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ResultEntity> results;
  @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ContractEntity> contracts;

  public PlayerEntity(String firstName, String lastName, LocalDate birthday, String nationality,
      String foot, Integer weight, Integer height, Integer minPotential, Integer maxPotential) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.nationality = nationality;
    this.foot = foot;
    this.weight = weight;
    this.height = height;
    this.minPotential = minPotential;
    this.maxPotential = maxPotential;
  }

  public PlayerEntity() {
  }

  public PlayerEntity(PlayerRequestDTO playerRequestDTO) {
    this.firstName = playerRequestDTO.firstName();
    this.lastName = playerRequestDTO.lastName();
    this.birthday = playerRequestDTO.birthday();
    this.nationality = playerRequestDTO.nationality();
    this.foot = playerRequestDTO.foot();
    this.weight = playerRequestDTO.weight();
    this.height = playerRequestDTO.height();
    this.minPotential = playerRequestDTO.minPotential();
    this.maxPotential = playerRequestDTO.maxPotential();
  }

  public PlayerEntity(PlayerFullRequestDTO playerRequestDTO) {
    this.firstName = playerRequestDTO.firstName();
    this.lastName = playerRequestDTO.lastName();
    this.birthday = playerRequestDTO.birthday();
    this.nationality = playerRequestDTO.nationality();
    this.foot = playerRequestDTO.foot();
    this.weight = playerRequestDTO.weight();
    this.height = playerRequestDTO.height();
    this.minPotential = playerRequestDTO.minPotential();
    this.maxPotential = playerRequestDTO.maxPotential();
  }

  public PlayerResponseDTO toPlayerResponseDTO() {
    return new PlayerResponseDTO(id, firstName, lastName, birthday, nationality, foot, weight,
        height, minPotential, maxPotential);
  }

  public PlayerFullResponseDTO toPlayerFullResponseDTO() {

    ResultResponseDTO resultDTO = this.results.getFirst().toResultResponseDTO();

    StatsResponseDTO statsDTO = this.stats.getFirst().toStatsResponseDTO();

    ContractResponseDTO contractDTO = this.contracts.getFirst().toContractResponseDTO();

    return new PlayerFullResponseDTO(id, firstName, lastName, birthday, nationality, foot, weight,
        height, minPotential, maxPotential, resultDTO, statsDTO, contractDTO);
  }


}
