package com.krzole.manager_tools.contract.entity;

import com.krzole.manager_tools.contract.dto.ContractRequestDTO;
import com.krzole.manager_tools.contract.dto.ContractResponseDTO;
import com.krzole.manager_tools.player.entity.PlayerEntity;
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
@Table(name = "contracts")
public class ContractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int playerValue;
  private int playerWage;
  private String clubName;
  private String clubNationality;
  private int clubDivision;

  @ManyToOne()
  @JoinColumn(name = "idPlayer", referencedColumnName = "id")
  private PlayerEntity player;

  @ManyToOne()
  @JoinColumn(name = "idSeason", referencedColumnName = "uid")
  private SeasonEntity season;

  public ContractEntity(ContractRequestDTO requestDTO) {
    this.clubDivision = requestDTO.clubDivision();
    this.clubName = requestDTO.clubName();
    this.clubNationality = requestDTO.clubNationality();
    this.playerValue = requestDTO.playerValue();
    this.playerWage = requestDTO.playerWage();
    this.season = requestDTO.season();
    this.player = requestDTO.player();

  }

  public ContractEntity() {
  }

  public ContractResponseDTO toContractResponseDTO() {
    return new ContractResponseDTO(id, playerValue, playerWage, clubName,
        clubNationality, clubDivision);
  }

}
