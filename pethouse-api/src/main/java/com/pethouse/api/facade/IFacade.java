package com.pethouse.api.facade;

import java.util.List;

import com.pethouse.api.domain.model.DomainEntity;
import com.pethouse.api.dto.AttrResponseDTO;

public interface IFacade {
	public AttrResponseDTO create(DomainEntity domainEntity);
	public AttrResponseDTO delete(DomainEntity domainEntity);
	public AttrResponseDTO update(DomainEntity domainEntity);
	public List<AttrResponseDTO> list(DomainEntity domainEntity);
	public AttrResponseDTO get(DomainEntity domainEntity);

}
