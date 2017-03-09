package me.efraimgentil.mymusic.repository;

import me.efraimgentil.mymusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by efraimgentil on 08/03/17.
 */
public interface MusicRepository extends JpaRepository<Music, Long>{
}
