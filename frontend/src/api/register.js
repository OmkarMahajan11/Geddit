import axios from "axios";

import { BASE_URL } from ".";

const URL = BASE_URL + "/register";

export const registerUser = async (user) => {
  try {
    const resp = await axios.get(URL, {
      data: {
        username: user.username,
        email: user.email,
        password: user.password,
      },
    });
    return resp;
  } catch (error) {
    alert(error);
  }
};
