import axios from "../utils/request";
import path from "./path"

const api = {
    login(email, password) {

        const param = {
            email: "3508627758@qq.com",
            password: "hmh123456"
        }


        const loginD = JSON.stringify(param);
        console.log(loginD);
        axios.post("http://localhost:8080/login", loginD, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }
}

export default api;