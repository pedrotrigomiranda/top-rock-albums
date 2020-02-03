package org.pedrotrigomiranda.toprockalbums;

import com.github.javafaker.Faker;
import org.pedrotrigomiranda.toprockalbums.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {

    @Autowired
    protected AlbumService albumService;

    protected final Faker faker = new Faker();
}
