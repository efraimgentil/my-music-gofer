package me.efraimgentil.mymusic.controller;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.FileStore;

/**
 * Created by efraimgentil on 08/03/17.
 */
@RestController
@RequestMapping("/get")
public class GoferController {


    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public Resource stream(@PathVariable("id") Long id ){

        return null;
    }

}
