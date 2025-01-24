package com.krzole.manager_tools.contract;

import com.krzole.manager_tools.contract.dto.ContractRequestDTO;
import com.krzole.manager_tools.contract.entity.ContractEntity;
import com.krzole.manager_tools.player.entity.PlayerEntity;
import com.krzole.manager_tools.season.entity.SeasonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

  private final ContractRepository contractRepository;

  @Autowired
  public ContractService(ContractRepository contractRepository) {
    this.contractRepository = contractRepository;
  }

  public ContractEntity addContract(ContractRequestDTO contractDTO, PlayerEntity playerEntity,
      SeasonEntity seasonEntity) {
    ContractEntity contractEntity = new ContractEntity(contractDTO);
    contractEntity.setPlayer(playerEntity);
    contractEntity.setSeason(seasonEntity);
    return contractRepository.save(contractEntity);
  }
}
