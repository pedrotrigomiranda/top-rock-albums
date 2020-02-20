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
                <td className="table-column">{album.id}</td>
                <td className="table-column">{album.album}</td>
                <td className="table-column">{album.artist}</td>
                <td className="table-column">{album.year}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Albums;
