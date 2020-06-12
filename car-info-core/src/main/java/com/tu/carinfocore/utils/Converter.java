package com.tu.carinfocore.utils;

import com.tu.carinfocore.persistance.dto.MeteoInfoDTO;
import com.tu.carinfocore.persistance.entities.MeteoInfoEntity;

public class Converter {

    public static MeteoInfoEntity convertMeteoInfoDTO2MeteoInfoEntity(MeteoInfoDTO dto) {
        MeteoInfoEntity entity = new MeteoInfoEntity();
        entity.setTemperature(dto.getTemperature());
        entity.setHumidity(dto.getHumidity());
        entity.setEco2(dto.getEco2());
        entity.setTvoc(dto.getTvoc());
        entity.setDate(dto.getDate());
        entity.setHours(dto.getHours());
        return entity;
    }

    public static MeteoInfoDTO convertMeteoInfoEntity2MeteoInfoDTO(MeteoInfoEntity entity) {
        MeteoInfoDTO dto = new MeteoInfoDTO();
        dto.setTemperature(entity.getTemperature());
        dto.setHumidity(entity.getHumidity());
        dto.setEco2(entity.getEco2());
        dto.setTvoc(entity.getTvoc());
        dto.setDate(entity.getDate());
        dto.setHours(entity.getHours());
        return dto;
    }
}
