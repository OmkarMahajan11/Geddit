import React from "react";

import "./Actions.css";

import Button from "../../button/Button";

import PersonIcon from "@material-ui/icons/Person";
import ArrowDropDownIcon from "@material-ui/icons/ArrowDropDown";

const Actions = () => {
  return (
    <div className="actions">
      <Button color="secondary" label="LOG IN" />
      <Button color="primary" label="SIGN UP" />
      <div className="profile">
        <PersonIcon className="hoverable" />
        <ArrowDropDownIcon className="hoverable" />
      </div>
    </div>
  );
};

export default Actions;
