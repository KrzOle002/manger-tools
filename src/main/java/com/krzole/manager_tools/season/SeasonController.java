package com.krzole.manager_tools.season;

import com.krzole.manager_tools.season.dto.SeasonRequestDTO;
import com.krzole.manager_tools.season.dto.SeasonResponseDTO;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/season")
public class SeasonController {

    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<SeasonResponseDTO>> getAllSeason( Pageable pageable) {
        return ResponseEntity.ok(seasonService.getAllSeasons(pageable));
    }

    @PostMapping()
    public ResponseEntity<SeasonResponseDTO> createSeason(@RequestBody SeasonRequestDTO seasonRequestDTO) {

        return ResponseEntity.ok(seasonService.add(seasonRequestDTO).toSeasonResponseDTO());
    }


}
