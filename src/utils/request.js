import axios from "axios";
import { ref } from "vue";
import querystring from 'querystring';

//获取response的信息
export const resolvedObj = ref();

const errorHandle = (status, info) => {
    switch (status) {
        case 400:
            console.log("语义有误");
            break;
        case 401:
            console.log("服务器认证失败");
            break;
        case 403:
            console.log("服务器拒绝访问");
            break;
        case 404:
            console.log("地址错误");
            break;
        case 500:
            console.log("服务器遇到意外");
            break;
        case 502:
            console.log("服务器无响应");
            break;
        default:
            console.log(info);
            break;
    }
}

// 网络公共配置
const instance = axios.create({
    timeout: 5000,
    headers: {
        'Content-Type': 'application/json'
    }
})

// 拦截器
// 发送数据之前
instance.interceptors.request.use(
    // config包含了网络请求的所有信息
    config => {
        if (config.method === "post") {
            // config.data = querystring.stringify(config.data);
        }
        console.log('config:');
        console.log(config);
        return config;
    },
    error => {
        return Promise.reject(error);
    }
)
// 接收数据之前
instance.interceptors.response.use(
    response => {
        response.status === 200 ? Promise.resolve(response).then(resolvedObj.value = response.data) : Promise.reject(response)
    },
    error => {
        console.log("error.response:");
        console.log(error.response);
        const { response } = error;
        console.log('response.data:');
        console.log(response.data);
        errorHandle(response.status, response.info);
    }
)


export default instance;


