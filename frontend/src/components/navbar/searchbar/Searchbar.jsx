import React from "react";

import "./Searchbar.css";

import SearchIcon from "@material-ui/icons/Search";

const Searchbar = () => {
  return (
    <div className="searchbar">
      <label htmlFor="searchbar">
        <SearchIcon />
      </label>
      <input id="searchbar" placeholder="Search" />
    </div>
  );
};

export default Searchbar;
