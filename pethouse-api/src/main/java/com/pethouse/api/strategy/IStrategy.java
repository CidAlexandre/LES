package com.pethouse.api.strategy;

import com.pethouse.api.domain.model.DomainEntity;

public interface IStrategy {
    public String applyBusinessRule(DomainEntity domainEntity);
}
