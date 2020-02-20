import React from "react";
import "./App.css";
import Albums from "./components/albums";

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      albums: [],
      artists: [],
      years: [],
      selectedArtist: "",
      selectedYear: ""
    };
    this.handleFilter = this.handleFilter.bind(this);
    this.selectArtist = this.selectArtist.bind(this);
    this.selectYear = this.selectYear.bind(this);
  }

  componentDidMount() {
    fetch("http://localhost:8080/albums?artist=&year=")
      .then(res => res.json())
      .then(data => {
        this.setState({
          albums: data
        });
      })

      .then(() => {
        for (let i = 0; i < this.state.albums.length; i++) {
          this.state.artists.push(this.state.albums[i].artist);
          this.state.years.push(this.state.albums[i].year);
        }
      });

      
    fetch(
      `http://localhost:8080/albums?artist=${this.state.selectedArtist}&year=${this.state.selectedYear}`
    ).then(res =>
      res.json().then(data => {
        this.setState({
          albums: data
        });
      })
    );
  }

  selectArtist(event) {
    this.setState({ selectedArtist: event.target.value });
  }

  selectYear(event) {
    this.setState({ selectedYear: event.target.value });
  }

  handleFilter() {
    fetch(
      `http://localhost:8080/albums?artist=${this.state.selectedArtist}&year=${this.state.selectedYear}`
    ).then(res =>
      res.json().then(data => {
        this.setState({
          albums: data
        });
      })
    );
  }

  render() {
    const artists = [...new Set(this.state.artists)].sort();
    const years = [...new Set(this.state.years)].sort();

    const optionArtists = artists.map((artist, i) => (
      <option value={artist} key={i}>
        {artist}
      </option>
    ));

    const optionYears = years.map((year, i) => (
      <option value={year} key={i}>
        {year}
      </option>
    ));

    return (
      <div className="app">
        <div className="filters">
          <select className="filter-artist" onChange={this.selectArtist}>
            <option value="">Select Artist</option>
            {optionArtists}
          </select>
          <br></br>
          <select className="filter-year" onChange={this.selectYear}>
            <option value="">Select Year</option>
            {optionYears}
          </select>
          <br></br>
          <br></br>
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
