package com.krzole.manager_tools.player;

import com.krzole.manager_tools.player.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {


}
