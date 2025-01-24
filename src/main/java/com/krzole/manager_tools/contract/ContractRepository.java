package com.krzole.manager_tools.contract;

import com.krzole.manager_tools.contract.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Long> {


}
