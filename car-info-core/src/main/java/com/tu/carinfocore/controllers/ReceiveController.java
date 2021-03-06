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

@RestController
@CrossOrigin
@RequestMapping(value = "/receive")
public class ReceiveController {

    @Autowired
    private MeteoInfoManager meteoManager;

    @RequestMapping(value = "/receiveMeteoInfo", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public boolean receiveMeteoInfo(@RequestBody MeteoInfoDTO dto) {
        MeteoInfoEntity entity = Converter.convertMeteoInfoDTO2MeteoInfoEntity(dto);
        return meteoManager.saveMeteoInfo2DB(entity);
    }

    @RequestMapping(value = "/receiveMeteoInfo", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public boolean receiveCodes(@RequestBody CodesInfoDTO dto) {
        CodesEntity entity = Converter.convertCodesInfoDTO2CodesEntity(dto);
        return meteoManager.saveCodesEntity2DB(entity);
    }
}
