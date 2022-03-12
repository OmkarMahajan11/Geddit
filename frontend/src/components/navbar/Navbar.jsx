import React from "react";

import Searchbar from "./searchbar/Searchbar";
import Logo from "./logo/Logo";
import Actions from "./actions/Actions";

import "./Navbar.css";

const Navbar = () => {
  return (
    <div className="navbar">
      <Logo />
      <Searchbar />
      <Actions />
    </div>
  );
};

export default Navbar;
