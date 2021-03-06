package com.tu.carinfocore.controllers;

import com.tu.carinfocore.managers.MeteoInfoManager;
import com.tu.carinfocore.persistance.dto.CodesInfoDTO;
import com.tu.carinfocore.persistance.dto.MeteoInfoDTO;
import com.tu.carinfocore.persistance.entities.CodesEntity;
import com.tu.carinfocore.persistance.entities.MeteoInfoEntity;
import com.tu.carinfocore.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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

    @RequestMapping(value = "/get-codes-info", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<CodesInfoDTO> getCodesEntities() {
        List<CodesInfoDTO> dtos = new ArrayList<>();
        Iterable<CodesEntity> entities = meteoManager.getCodesInfo();

        if (entities != null) {
            for (CodesEntity entity : entities) {
                CodesInfoDTO dto = Converter.convertCodesEntities2CodesDTO(entity);
                dtos.add(dto);
            }
        }
        return dtos;
    }
}
