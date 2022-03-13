import React from "react";

import "./Button.css";

const Button = ({ color, label }) => {
  switch (color) {
    case "primary":
      return <div className="button primary-button">{label}</div>;
    case "secondary":
      return <div className="button secondary-button">{label}</div>;
    case "tertiary":
      return <div className="button tertiary-button">{label}</div>;
    default:
      return <div className="button">{label}</div>;
  }
};

export default Button;
