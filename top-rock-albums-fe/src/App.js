import React from "react";
import "./App.css";
import Albums from "./components/albums";

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      selectedArtist: "",
      selectedYear: "",
      albums: [],
      artists: [],
      years: []
    };
    this.handleFilter = this.handleFilter.bind(this);
    this.selectedArtist = this.selectedArtist.bind(this);
    this.selectedYear = this.selectedYear.bind(this);
  }

  componentDidMount() {
    fetch("http://localhost:8080/albums?artists=&year=")
      .then(res => res.json())
      .then(data => {
        this.setState({
          albums: data,
          artists: data.artist,
          years: data.year
        });
      })
  }

  selectedArtist(event) {
    this.setState({
      selectedArtist: event.target.value
    });
  }

  selectedYear(event) {
    this.setState({
      selectedYear: event.target.value
    });
  }

  handleFilter() {
    fetch(
      `http://localhost:8080/arbums?artists=${this.state.selectedArtist}&year=${this.state.selectedYear}`
    ).then(res =>
      res.json().then(data => {
        this.setState({ albums: data });
      })
    )
    .then(console.log(this.state.selectedArtist));
  }

  render() {
    let albums = this.state.albums;
    let optionArtists = albums.map((album, i) => (
      <option value={album.artist} key={i}>
        {album.artist}
      </option>
    ));

    return (
      <div className="app">
        <div className="filters">
          <select className="filter-artist" onChange={this.selectedArtist}>
            <option value="">Select Artist</option>
            {optionArtists}
          </select><br></br>
          <button className="filter-button" onClick={this.handleFilter}>
            Filter
          </button>
        </div>
        <Albums albums={this.state.albums} />
      </div>
    );
  }
}

export default App;
