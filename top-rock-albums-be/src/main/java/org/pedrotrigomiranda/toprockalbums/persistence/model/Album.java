package org.pedrotrigomiranda.toprockalbums.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="top_albums")
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Model {

    @Id
    private Integer id;

    @Getter
    @Setter
    private String album;

    @Getter
    @Setter
    private String artist;

    @Getter
    @Setter
    private Integer year;



}
