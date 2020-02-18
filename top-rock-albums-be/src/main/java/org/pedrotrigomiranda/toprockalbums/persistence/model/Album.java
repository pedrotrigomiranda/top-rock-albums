package org.pedrotrigomiranda.toprockalbums.persistence.model;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private String artist;

    @NotNull
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
}
