package com.krzole.manager_tools.season.entity;

import com.krzole.manager_tools.season.dto.SeasonRequestDTO;
import com.krzole.manager_tools.season.dto.SeasonResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seasons")
public class SeasonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private int uid;

  public SeasonEntity(String name, int uid) {
    this.name = name;
    this.uid = uid;
  }

  public SeasonEntity(SeasonRequestDTO seasonRequestDTO) {
    this.name = seasonRequestDTO.name();
    this.uid = seasonRequestDTO.uid();
  }

  public SeasonEntity() {
  }

  public SeasonResponseDTO toSeasonResponseDTO() {
    return new SeasonResponseDTO(id, name, uid);
  }

}
