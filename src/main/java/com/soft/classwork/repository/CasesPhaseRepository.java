package com.soft.classwork.repository;

import com.soft.classwork.model.CasesPhase;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yuukiiii
 * on 2018/4/8 14:09
 */


public interface CasesPhaseRepository extends JpaRepository<CasesPhase,Integer>{
    public List<CasesPhase> findAllByCaseid(Integer casesid);

    public List<CasesPhase> findAllByCaseidAndCasephasename(Integer casesid,String casephasename);

    public CasesPhase getByDataid(Integer dataid);

    public void deleteCasesPhasesByCaseid(Integer caseid);


}
