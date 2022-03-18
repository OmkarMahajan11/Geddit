import React, { useState } from "react";
import { registerUser } from "../../api/register";

import "./Register.css";

const Register = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confPassword, setConfPassword] = useState("");

  const handleSubmit = (e) => {
    if (password !== confPassword) {
      alert("password does Not Match");
    } else {
      const resp = registerUser({
        username: username,
        password: password,
        email: email,
      });
      alert(resp);
    }
    e.preventDefault();
  };

  return (
    <>
      <form onSubmit={(e) => handleSubmit(e)} className="form">
        <h3>Sign-up Form</h3>
        <div
          style={{
            border: "1px solid red",
          }}
        >
          <label
            htmlFor="username"
            style={{
              color: "black",
              fontSize: 18,
              marginTop: 6,
            }}
          >
            Username:
            <input
              type="text"
              id="username"
              required
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              style={{
                padding: 7,
                width: "20%",
                borderRadius: 4,
                border: "1px solid gray",
                marginLeft: "2%",
                marginTop: 6,
              }}
            />
          </label>
        </div>

        <div>
          <label htmlFor="email">
            Email:
            <input
              type="email"
              id="email"
              required
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </label>
        </div>

        <div>
          <label htmlFor="password">
            Password:
            <input
              type="password"
              id="password"
              required
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </label>
        </div>

        <div>
          <label htmlFor="confpassword">
            Confirm Password:
            <input
              type="password"
              id="confpassword"
              required
              value={confPassword}
              onChange={(e) => setConfPassword(e.target.value)}
            />
          </label>
        </div>

        <div>
          <input type="submit" value="Submit" />
        </div>
      </form>
    </>
  );
};

export default Register;
