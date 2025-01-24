package com.krzole.manager_tools.stats.entity;


import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import com.krzole.manager_tools.stats.dto.StatsRequestDTO;
import com.krzole.manager_tools.stats.dto.StatsResponseDTO;
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
@Table(name = "stats")
public class StatsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int shirtNumber;
  private int age;
  private String position;
  private int rating;
  private int skillStars;
  private int weakFoot;
  private int pace;
  private int shooting;
  private int passing;
  private int dribbling;
  private int defending;
  private int physical;

  @ManyToOne()
  @JoinColumn(name = "idPlayer", referencedColumnName = "id")
  private PlayerEntity player;

  @ManyToOne()
  @JoinColumn(name = "idSeason", referencedColumnName = "uid")
  private SeasonEntity season;

  public StatsEntity(StatsRequestDTO statsRequestDTO) {
    this.age = statsRequestDTO.age();
    this.shirtNumber = statsRequestDTO.shirtNumber();
    this.position = statsRequestDTO.position();
    this.rating = statsRequestDTO.rating();
    this.skillStars = statsRequestDTO.skillStars();
    this.weakFoot = statsRequestDTO.weakFoot();
    this.pace = statsRequestDTO.pace();
    this.shooting = statsRequestDTO.shooting();
    this.passing = statsRequestDTO.passing();
    this.dribbling = statsRequestDTO.dribbling();
    this.defending = statsRequestDTO.defending();
    this.physical = statsRequestDTO.physical();

  }

  public StatsEntity() {

  }

  public StatsResponseDTO toStatsResponseDTO() {
    return new StatsResponseDTO(id, shirtNumber, age, position, rating, skillStars,
        weakFoot, pace, shooting, passing, dribbling, defending, physical);
  }
}
