package com.soft.classwork.mapper;

import com.soft.classwork.model.Charge;
import org.apache.ibatis.annotations.Param;

public interface ChargeMapper {
    int addCharge(Charge charge);
    Charge getChargeById(@Param("id") int id);
    int updateChargeById(@Param("charge") Charge charge);
}
