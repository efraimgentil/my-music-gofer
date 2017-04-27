package me.efraimgentil.mymusic.service.impl;

import me.efraimgentil.mymusic.service.FilePointer;
import me.efraimgentil.mymusic.service.FileStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by efraimgentil on 08/03/17.
 */
@Service
public class FileStorageImpl implements FileStorage {

    @Value("${baseFolder}")
    protected String baseFolderPath;

    @Override
    public FilePointer findFile(final String path) {
        String finalPath =  baseFolderPath + "/" + path;
        return getFile(finalPath)
                .map( f -> new SystemFilePointer(f)  )
                .orElseThrow( () -> new IllegalArgumentException("File not found at '" + finalPath + "'") );
    }

    protected Optional<File> getFile(String path){
        File file = Paths.get( path ).toFile();
        return file.exists() ? Optional.of( file ) : Optional.empty();
    }

}
