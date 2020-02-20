import React from "react";


const DropdownArtists = ({ artists }) => {
   artists = this.props.artists 
    const optionArtists = artists.map((artist, i) => (
        <option value={artist} key={i}>
          {artist}
        </option>
      ));
    return optionArtists
}

export default DropdownArtists