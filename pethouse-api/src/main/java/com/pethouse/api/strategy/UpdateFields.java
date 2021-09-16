package com.pethouse.api.strategy;

import com.pethouse.api.domain.model.DomainEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateFields implements IStrategy{
    @Override
    public String applyBusinessRule(DomainEntity domainEntity) {
        if( Long.toString(domainEntity.getId()) == null){
            return "A entidade não pode ter id nulo";
        }
        return "";
    }
}
