package org.pedrotrigomiranda.toprockalbums.converter;

import org.pedrotrigomiranda.toprockalbums.command.AlbumDto;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import org.springframework.stereotype.Component;

@Component
public class AlbumToAlbumDto extends AbstractConverter<Album, AlbumDto> {

    @Override
    public AlbumDto convert(Album album){

        AlbumDto albumDto = new AlbumDto();

        albumDto.setId(album.getId());
        albumDto.setAlbum(album.getAlbum());
        albumDto.setArtist(album.getArtist());
        albumDto.setYear(album.getYear());

        return albumDto;
    }
}
