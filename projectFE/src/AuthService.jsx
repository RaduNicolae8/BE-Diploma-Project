import axios from "axios";

const API_URL = "http://localhost:8090/public/auth";

class AuthService {
    login(username, password) {
        return axios
            .post(API_URL + "/login", { username, password }, { withCredentials: true })
            .then((response) => {
                return response.data;
            });
    }

    logout() {
        return axios.post(API_URL + "/signout", {}, { withCredentials: true });
    }

    register(username, email, password) {
        return axios.post(API_URL + "/signup", { username, email, password });
    }
}

export default new AuthService();
