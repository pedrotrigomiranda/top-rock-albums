package org.pedrotrigomiranda.toprockalbums.services;

import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;

import java.util.List;

public interface AlbumService {

    List<Album> list(String artist, Integer year);

    List<Album> filter(List<Album> albums, String artist, Integer year);
}
