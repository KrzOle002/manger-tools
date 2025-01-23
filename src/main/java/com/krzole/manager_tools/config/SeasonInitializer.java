package com.krzole.manager_tools.config;

import com.krzole.manager_tools.season.SeasonService;
import com.krzole.manager_tools.season.dto.SeasonRequestDTO;
import jakarta.annotation.PostConstruct;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeasonInitializer {

  @Autowired
  private SeasonService seasonService;

  @PostConstruct
  public void initializeSeasons() {
    IntStream.rangeClosed(2023, 2039).forEach(year -> {
      String seasonName = year + "/" + (year + 1);
      int uid = year - 2000;
      if (!seasonService.existsByName(seasonName)) {
        SeasonRequestDTO season = new SeasonRequestDTO(seasonName, uid);
        seasonService.add(season);
        System.out.println("Dodano sezon: " + seasonName);
      }
    });
  }
}
