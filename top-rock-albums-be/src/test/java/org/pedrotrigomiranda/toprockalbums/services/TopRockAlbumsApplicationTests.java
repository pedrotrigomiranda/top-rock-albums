package org.pedrotrigomiranda.toprockalbums.services;

import org.junit.jupiter.api.Test;
import org.pedrotrigomiranda.toprockalbums.BaseTest;
import org.pedrotrigomiranda.toprockalbums.persistence.model.Album;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TopRockAlbumsApplicationTests extends BaseTest {

	@Test
	void testFilter_withNullFilter_returnsSameList() {
		List<Album> albums = new ArrayList<>();

		for(int i = 0; i <= 5; i++){
			albums.add(Album.builder()
					.id(i)
					.album("Baleia Baleia Baleia")
					.artist("Baleia Baleia Baleia")
					.year(2019)
					.build());
		}

		List<Album> filteredAlbums = albumService.filter(albums, null, null);

		assertThat(filteredAlbums).isEqualTo(albums);
	}

	@Test
	void testFilter_withEmptyString_returnsSameList() {
		List<Album> albums = new ArrayList<>();

		for(int i = 0; i <= 5; i++){
			albums.add(Album.builder()
					.id(i)
					.album("Baleia Baleia Baleia")
					.artist("Baleia Baleia Baleia")
					.year(2019)
					.build());
		}

		List<Album> filteredAlbums = albumService.filter(albums, "", null);

		assertThat(filteredAlbums).isEqualTo(albums);
	}

	@Test
	void testFilter_withArtist_returnsFilteredList(){
		List<Album> expectedList = new ArrayList<>();
		List<Album> albums = new ArrayList<>();


		for (int i = 0; i <= 5; i++) {
			expectedList.add(Album.builder()
					.id(i)
					.album("Revolver")
					.artist("The Beatles")
					.year(1966)
					.build());

			albums.add(Album.builder()
					.id(i)
					.album(faker.name().firstName())
					.artist(faker.name().lastName())
					.year(2020)
					.build());
		}

		albums.addAll(expectedList);

		List<Album> filteredAlbums = albumService.filter(albums, "The Beatles", null);
		assertThat(filteredAlbums).isEqualTo(expectedList);
	}

	@Test
	void testFilter_withYear_returnsFilteredList(){
		List<Album> expectedList = new ArrayList<>();
		List<Album> albums = new ArrayList<>();


		for (int i = 0; i <= 5; i++) {
			expectedList.add(Album.builder()
					.id(i)
					.album("Revolver")
					.artist("The Beatles")
					.year(1966)
					.build());

			albums.add(Album.builder()
					.id(i)
					.album(faker.name().firstName())
					.artist(faker.name().lastName())
					.year(2020)
					.build());
		}

		albums.addAll(expectedList);

		List<Album> filteredAlbums = albumService.filter(albums, null, 1966);
		assertThat(filteredAlbums).isEqualTo(expectedList);
	}

	@Test
	void testFilter_withArtistAndYear_returnsFilteredList(){
		List<Album> expectedList = new ArrayList<>();
		List<Album> albums = new ArrayList<>();


		for (int i = 0; i <= 5; i++) {
			expectedList.add(Album.builder()
					.id(i)
					.album("Revolver")
					.artist("The Beatles")
					.year(1966)
					.build());

			albums.add(Album.builder()
					.id(i)
					.album(faker.name().firstName())
					.artist(faker.name().lastName())
					.year(2020)
					.build());
		}

		albums.addAll(expectedList);

		List<Album> filteredAlbums = albumService.filter(albums, "The Beatles", 1966);
		assertThat(filteredAlbums).isEqualTo(expectedList);
	}

	@Test
	void testFilter_withEmptyCustomerList_returnsEmptyList() {
		List<Album> filteredCustomers = albumService.filter(new ArrayList<>(), "Nirvana", 1991);

		assertThat(filteredCustomers).isEmpty();
	}

}
