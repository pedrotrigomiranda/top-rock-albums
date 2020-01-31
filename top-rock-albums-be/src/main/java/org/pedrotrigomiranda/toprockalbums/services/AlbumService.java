package org.pedrotrigomiranda.toprockalbums.services;

import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;

import java.util.List;

public interface AlbumService {

    List<Album> list();

    List<Album> filter(List<Album> albums, Integer year, String artist);
}
