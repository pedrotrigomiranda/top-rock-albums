import React from "react";
import Header from "./header";

const Albums = ({ albums }) => {
  return (
    <div className="albumsContainer">
      <table className="table">
        <tbody className="table-body">
          <Header />
          {albums.map(function(album, i) {
            return (
              <tr className="table-row" key={i}>
                <td>{album.id}</td>
                <td>{album.album}</td>
                <td>{album.artist}</td>
                <td>{album.year}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Albums;
