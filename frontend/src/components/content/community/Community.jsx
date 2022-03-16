import React from "react";

import "./Community.css";

import ArrowDropUp from "@material-ui/icons/ArrowDropUp";
import Button from "../../button/Button";

export default function Community() {
  const communities = [];
  return (
    <div className="community-section">
      <div className="title">
        <span className="hoverable">Today's Top Growing Communities</span>
      </div>
      <div className="communities-wrapper">
        {communities.map((community, index) => (
          <div className="community hoverable">
            <span>{index + 1}</span>
            <ArrowDropUp />
            <img src={community.image_src} />
            <span className="name">r/{community.name}</span>
          </div>
        ))}
      </div>
      <div className="action-buttons">
        <Button color="primary" label="VIEW ALL" />
        <div className="secondary-buttons">
          <Button color="tertiary" label="Sports" />
          <Button color="tertiary" label="News" />
          <Button color="tertiary" label="Gaming" />
          <Button color="tertiary" label="Aww" />
        </div>
      </div>
    </div>
  );
}
