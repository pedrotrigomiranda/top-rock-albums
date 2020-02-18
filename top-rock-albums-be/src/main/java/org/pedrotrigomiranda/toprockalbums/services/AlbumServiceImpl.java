package org.pedrotrigomiranda.toprockalbums.services;

import org.apache.logging.log4j.util.Strings;
import org.pedrotrigomiranda.toprockalbums.persistence.dao.AlbumRepository;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;



    @Override
    public List<Album> list(String artist, Integer year) {
        if (!StringUtils.isEmpty(artist) && year != null) {
            return albumRepository.findByArtistAndYear(artist, year);
        }

        if (!StringUtils.isEmpty(artist)) {
            return albumRepository.findByArtist(artist);
        }

        if (year != null) {
            return albumRepository.findByYear(year);
        }

        return albumRepository.findAll();
    }

    @Override
    public List<Album> filter(List<Album> albums, String artist, Integer year) {

        return albums.stream()
                .filter(album -> Strings.isEmpty(artist) || album.getArtist().equals(artist))
                .filter(album -> year == null || album.getYear().equals(year))
                .collect(Collectors.toList());
    }
}
