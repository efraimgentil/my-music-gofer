package me.efraimgentil.mymusic.controller;

import me.efraimgentil.mymusic.model.Music;
import me.efraimgentil.mymusic.repository.MusicRepository;
import me.efraimgentil.mymusic.service.FilePointer;
import me.efraimgentil.mymusic.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.nio.file.FileStore;
import java.util.Optional;

/**
 * Created by efraimgentil on 08/03/17.
 */
@RestController
@RequestMapping("/get")
public class GoferController {


    @Autowired
    FileStorage fileStorage;
    @Autowired
    MusicRepository musicRepository;

    @RequestMapping(method = RequestMethod.GET , value = "/{id}")
    public ResponseEntity<Resource> stream(@PathVariable("id") Long id ){
        Music one = musicRepository.findOne(id);
        Resource resource = responseStream(fileStorage.findFile(one.getPathToFile()));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(resource);
              /*  .eTag(filePointer.getEtag())
                .contentLength(filePointer.getSize())
                .lastModified(filePointer.getLastModified().toEpochMilli());
        filePointer
                .getMediaType()
                .map(this::toMediaType)
        return Optional.<Music>of( musicRepository.findOne(id) )
                .map(m -> responseStream( fileStorage.findFile( m.getPathToFile() ) ) )
                .orElseGet( () -> { throw new RuntimeException("Ha not found"); } );*/
    }

    protected Resource responseStream(FilePointer filePointer) {
        return new InputStreamResource( filePointer.open() );
    }

}
