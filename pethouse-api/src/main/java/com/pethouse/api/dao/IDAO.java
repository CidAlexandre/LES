package com.pethouse.api.dao;

import java.util.List;

import com.pethouse.domain.model.DomainEntity;

public interface IDAO {
	public DomainEntity create (DomainEntity domainEntity);
	public DomainEntity delete (Long id);
	public DomainEntity update (DomainEntity domainEntity);
	public List<DomainEntity> list(DomainEntity domainEntity);
	public DomainEntity get(Long id);
}
