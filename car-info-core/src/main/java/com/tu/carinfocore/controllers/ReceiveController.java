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

@RestController
@RequestMapping(value = "/receive")
public class ReceiveController {

    @Autowired
    private MeteoInfoManager meteoManager;

    @RequestMapping(value = "/receiveMeteoInfo", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public boolean receiveMeteoInfo(@RequestBody MeteoInfoDTO dto) {
        MeteoInfoEntity entity = Converter.convertMeteoInfoDTO2MeteoInfoEntity(dto);
        return meteoManager.saveMeteoInfo2DB(entity);
    }
}
