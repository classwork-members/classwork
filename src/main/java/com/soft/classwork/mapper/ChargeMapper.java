package com.soft.classwork.mapper;

import com.soft.classwork.model.Charge;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface ChargeMapper {
    int addCharge(Charge charge);
    Charge getChargeById(@Param("id") int id);
    int updateChargeById(@Param("charge") Charge charge);
    int deleteChargeById(@Param("id") int id);
    List<Charge> getChargeList();
    List<Charge> getChargeByDt_create(@Param("time") String time);
    List<Charge> getChargeByPayment(@Param("low") float low, @Param("high") float high);
}
