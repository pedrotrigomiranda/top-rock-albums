package org.pedrotrigomiranda.toprockalbums.services;

import lombok.Getter;
import org.pedrotrigomiranda.toprockalbums.persistence.dao.AlbumDao;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Getter
    private AlbumDao albumDao;

    @Autowired
    public void setAlbumDao(AlbumDao albumDao) {
        this.albumDao = albumDao;
    }

    @Override
    public List<Album> list() {
        return albumDao.findAll();
    }

    @Override
    public List<Album> filter(List<Album> albums, Integer year, String artist) {

        return albums.stream()
                .filter(album -> year == null || album.getYear() == year)
                .filter(album -> artist == null || album.getArtist() == artist)
                .collect(Collectors.toList());
    }
}
