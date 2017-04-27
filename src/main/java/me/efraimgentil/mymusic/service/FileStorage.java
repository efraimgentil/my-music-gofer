package me.efraimgentil.mymusic.service;

import java.util.Optional;

/**
 * Created by efraimgentil on 08/03/17.
 */
public interface FileStorage {

    FilePointer findFile(String path);

}
