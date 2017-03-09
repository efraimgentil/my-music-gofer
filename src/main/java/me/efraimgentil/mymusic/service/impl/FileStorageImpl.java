package me.efraimgentil.mymusic.service.impl;

import me.efraimgentil.mymusic.service.FilePointer;
import me.efraimgentil.mymusic.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by efraimgentil on 08/03/17.
 */
@Service
public class FileStorageImpl implements FileStorage {

    @Autowired @Qualifier("baseFolder") String baseFolderPath;

    @Override
    public Optional<FilePointer> findFile(String path) {
        return getFile(path)
                .map( f -> new SystemFilePointer(f)  );
    }

    public Optional<File> getFile(String path){
        File file = Paths.get(baseFolderPath + "/" + path).toFile();
        if( !file.exists() )file = null;
        return Optional.of(file );
    }

}
