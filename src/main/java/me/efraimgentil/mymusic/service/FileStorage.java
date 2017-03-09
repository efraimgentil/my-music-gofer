package me.efraimgentil.mymusic.service;

import java.util.Optional;

/**
 * Created by efraimgentil on 08/03/17.
 */
public interface FileStorage {

    Optional<FilePointer> findFile(String path);

}
