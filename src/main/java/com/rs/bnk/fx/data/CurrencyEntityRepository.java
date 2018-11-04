package com.rs.bnk.fx.data;

import com.rs.bnk.fx.data.entity.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyEntityRepository extends CrudRepository<CurrencyEntity, Long> {
}
