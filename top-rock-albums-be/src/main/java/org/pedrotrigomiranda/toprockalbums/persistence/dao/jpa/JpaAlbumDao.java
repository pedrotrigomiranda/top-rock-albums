package org.pedrotrigomiranda.toprockalbums.persistence.dao.jpa;

import org.pedrotrigomiranda.toprockalbums.persistence.dao.AlbumDao;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;

public class JpaAlbumDao extends GenericJpaDao<Album> implements AlbumDao {
    public JpaAlbumDao() {
        super(Album.class);
    }

}
