package com.tu.carinfocore.managers;

import com.tu.carinfocore.persistance.entities.CodesEntity;
import com.tu.carinfocore.persistance.entities.CodesEntityRepository;
import com.tu.carinfocore.persistance.entities.MeteoInfoEntity;
import com.tu.carinfocore.persistance.entities.MeteoInfoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeteoInfoManager {

    @Autowired
    private MeteoInfoEntityRepository meteoInfoEntityRepository;

    @Autowired
    private CodesEntityRepository codesEntityRepository;

    public boolean saveMeteoInfo2DB(MeteoInfoEntity entity) {
        if (entity != null) {
            meteoInfoEntityRepository.save(entity);
            return true;
        }
        return false;
    }

    public boolean saveCodesEntity2DB(CodesEntity entity) {
        if (entity != null) {
            codesEntityRepository.save(entity);
            return true;
        }
        return false;
    }

    public Iterable<MeteoInfoEntity> getMeteoEntities() {
        return meteoInfoEntityRepository.findAll();
    }

    public Iterable<CodesEntity> getCodesInfo() {
        return codesEntityRepository.findAll();
    }
}
