import React from "react";
import { Link } from "react-router-dom";

import "./Logo.css";

const Logo = () => {
  return (
    <div className="logo hoverable">
      <Link to={"/"}>
        <img src="./assets/images/reddit-logo.png" alt="" />
      </Link>
      <Link to={"/"} style={{ textDecoration: "none" }}>
        <span> reddit</span>
      </Link>
    </div>
  );
};

export default Logo;
