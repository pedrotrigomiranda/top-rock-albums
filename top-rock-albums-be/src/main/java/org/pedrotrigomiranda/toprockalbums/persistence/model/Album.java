package org.pedrotrigomiranda.toprockalbums.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="top_albums")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Model {

    @Id
    private Integer id;

    private String album;

    private String artist;

    private Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String filterArtist(){
        return artist;
    }

    public Integer filterYear(){
        return year;
    }
}
