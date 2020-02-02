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

  selectArtist(event) {
    this.setState({
      selectedArtist: event.target.value
    });
    console.log(this.state.selectedArtist)
  }

  selectYear(event) {
    this.setState({
      selectedYear: event.target.value
    });
    console.log(this.state.selectedYear)
  }

  handleFilter() {
    fetch(
      `http://localhost:8080/albums?artists=${this.state.selectedArtist}&year=${this.state.selectedYear}`
    ).then(res =>
      res.json().then(data => {
        this.setState({
          albums: data,
         });
      })
      )
  }

  render() {
    let albums = this.state.albums;

    let optionArtists = albums.map((album, i) => (
      <option value={album.artist} key={i}>
        {album.artist}
      </option>
    ));

    let optionYears = albums.map((album, i) =>(
      <option value ={album.year} key={i}>
        {album.year}
      </option>
    ))

    return (
      <div className="app">
        <div className="filters">
          <select className="filter-artist" onChange={this.selectArtist}>
            <option value="">Select Artist</option>
            {optionArtists}
          </select><br></br>
          <select className="filter-year" onChange={this.selectYear}>
            <option value="">Select Year</option>
            {optionYears}
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
