package org.pedrotrigomiranda.toprockalbums.persistence.dao;

import java.util.List;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtist(String artist);
    List<Album> findByYear(Integer year);
    List<Album> findByArtistAndYear(String artist, Integer year);
}
