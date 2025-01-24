package com.krzole.manager_tools.season;

import com.krzole.manager_tools.season.dto.SeasonRequestDTO;
import com.krzole.manager_tools.season.dto.SeasonResponseDTO;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SeasonService {

  private final SeasonRepository seasonRepository;

  public SeasonService(SeasonRepository seasonRepository) {
    this.seasonRepository = seasonRepository;
  }

  public Page<SeasonResponseDTO> getAllSeasons(Pageable pageable) {
    return seasonRepository.findAllBy(pageable).map(SeasonEntity::toSeasonResponseDTO);
  }

  public SeasonEntity add(SeasonRequestDTO seasonRequestDTO) {
    SeasonEntity season = seasonRepository.save(new SeasonEntity(seasonRequestDTO));
    return seasonRepository.save(season);
  }

  public boolean existsByName(String name) {
    return seasonRepository.existsByName(name);
  }

  public SeasonEntity getSeasonByUID(int seasonUID) {
    return seasonRepository.findByUid(seasonUID).orElse(null);
  }

}