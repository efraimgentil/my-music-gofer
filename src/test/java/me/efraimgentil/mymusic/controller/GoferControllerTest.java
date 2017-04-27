package me.efraimgentil.mymusic.controller;

import me.efraimgentil.mymusic.service.FilePointer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * Created by efraimgentil on 13/03/17.
 */
public class GoferControllerTest {

    GoferController controller;

    @Before
    public void setUp(){
        controller = new GoferController();
    }


    @Test
    public void returnTheInputStreamResourceForTheFilePointerStream(){
        FilePointer fpMock = mock(FilePointer.class);
        InputStream is = this.getClass().getResourceAsStream("/files/texte.txt");
        when(fpMock.open()).thenReturn( new BufferedInputStream( is  ) );

        Resource resource = controller.responseStream(fpMock);

        assertThat(resource ).isNotNull();
        assertThat( resource ).isInstanceOf(InputStreamResource.class );
    }


}
