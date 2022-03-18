import React from "react";
import "./Navbar.css";

import Logo from "./logo/Logo";
import Actions from "./actions/Actions";
import Searchbar from "./searchbar/Searchbar";

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
