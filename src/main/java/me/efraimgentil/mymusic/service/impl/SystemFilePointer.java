package me.efraimgentil.mymusic.service.impl;

import me.efraimgentil.mymusic.service.FilePointer;

import java.io.*;

/**
 * Created by efraimgentil on 08/03/17.
 */
public class SystemFilePointer implements FilePointer {

    private File file;

    public SystemFilePointer(File file) {
        this.file = file;
    }

    @Override
    public InputStream open()  {
        try {
            return  new BufferedInputStream( new FileInputStream( file ) );
        } catch (FileNotFoundException e) {
            throw new IllegalStateException( e );
        }
    }
}
