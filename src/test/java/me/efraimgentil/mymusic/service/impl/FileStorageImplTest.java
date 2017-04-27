package me.efraimgentil.mymusic.service.impl;

import me.efraimgentil.mymusic.service.FilePointer;
import me.efraimgentil.mymusic.service.FileStorage;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.File;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by efraimgentil on 08/03/17.
 */
public class FileStorageImplTest {

    FileStorageImpl fs;

    @Before
    public void setUp(){
        fs = new FileStorageImpl();
        fs.baseFolderPath = this.getClass().getResource("/files/").getPath();
    }


    @Test
    public void getFileIfExist(){
        Optional<File> file = fs.getFile("teste.txt");

        assertThat( file.get() ).isNotNull();
        assertThat( file.get().exists() ).isTrue();
    }

    @Test
    public void getFileIfExisst(){
        Optional<File> file = fs.getFile( "testesss.txt" );

        assertThat(file.isPresent() ).isFalse();
    }

    @Test
    public void returnASystemFileWhenFileIsFound(){
        fs = spy( fs );
        when( fs.getFile( anyString() ) ).thenReturn(Optional.<File>of( new File("anyfile.txt") ) );

        FilePointer fp = fs.findFile("randomNameWhatever");

        assertThat( fp ).isNotNull();
        assertThat( fp ).isInstanceOf( SystemFilePointer.class );
    }

    @Test(expected = IllegalArgumentException.class )
    public void throwsIllegalArgumentExceptionWhenDoesntFindTheFile(){
        fs = spy( fs );
        when( fs.getFile( anyString() ) ).thenReturn(Optional.<File>empty() );

        FilePointer fp = fs.findFile("randomNameWhatever");
    }


}
