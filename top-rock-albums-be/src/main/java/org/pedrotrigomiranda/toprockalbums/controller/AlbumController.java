package org.pedrotrigomiranda.toprockalbums.controller;

import org.pedrotrigomiranda.toprockalbums.command.AlbumDto;
import org.pedrotrigomiranda.toprockalbums.converter.AlbumToAlbumDto;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import org.pedrotrigomiranda.toprockalbums.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumService albumService;
    private AlbumToAlbumDto albumToAlbumDto;

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Autowired
    public void setAlbumToAlbumDto(AlbumToAlbumDto albumToAlbumDto) {
        this.albumToAlbumDto = albumToAlbumDto;
    }

    @GetMapping
    public ResponseEntity<List<AlbumDto>> listAlbums(@RequestParam(required = false) String artist,
                                                     @RequestParam(required = false) Integer year){


        List<AlbumDto> albumDtos = new ArrayList<>();

        List<Album> albums = albumService.list();

        for(Album album : albumService.filter(albums, year, artist)){
            albumDtos.add(albumToAlbumDto.convert(album));
        };

        return new ResponseEntity<>(albumDtos, HttpStatus.OK);
    }
}
