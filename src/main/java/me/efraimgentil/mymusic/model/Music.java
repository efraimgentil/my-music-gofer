package me.efraimgentil.mymusic.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by efraimgentil on 07/02/17.
 */
@Entity
@Table(name = "music")
public class Music implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pathToFile;

    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

}
