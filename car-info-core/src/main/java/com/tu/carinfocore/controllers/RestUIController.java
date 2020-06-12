package com.tu.carinfocore.controllers;

import com.tu.carinfocore.managers.MeteoInfoManager;
import com.tu.carinfocore.persistance.dto.MeteoInfoDTO;
import com.tu.carinfocore.persistance.entities.MeteoInfoEntity;
import com.tu.carinfocore.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api-ui")
public class RestUIController {

    @Autowired
    private MeteoInfoManager meteoManager;

    @RequestMapping(value = "/get-meteo-info", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<MeteoInfoDTO> getMeteoinfo() {
        List<MeteoInfoDTO> dtos = new ArrayList<>();
        Iterable<MeteoInfoEntity> entities = meteoManager.getMeteoEntities();

        if (entities != null) {
            for (MeteoInfoEntity entity : entities) {
                MeteoInfoDTO dto = Converter.convertMeteoInfoEntity2MeteoInfoDTO(entity);
                dtos.add(dto);
            }
        }
        return dtos;
    }
}
