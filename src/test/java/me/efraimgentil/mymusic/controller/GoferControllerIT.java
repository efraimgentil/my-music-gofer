package me.efraimgentil.mymusic.controller;

import me.efraimgentil.mymusic.GoferApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.applet.AudioClip;
import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by efraimgentil on 13/03/17.
 */
@RunWith(SpringRunner.class )
@SpringBootTest(classes = GoferApplication.class
        , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:test.properties")
public class GoferControllerIT {



        @Autowired
        GoferController controller;

        @Test
        @Sql(value = "/sampledata/music.sql" , executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
        @Sql(value = "/sampledata/remove_music.sql" , executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
        public void returnDeMusicResource() throws IOException {
                ResponseEntity<Resource> stream = controller.stream(1L);

                assertThat( stream ).isNotNull();



                try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                                stream.getBody().getInputStream());
                        clip.open(inputStream);
                        clip.start();
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
        }

}
