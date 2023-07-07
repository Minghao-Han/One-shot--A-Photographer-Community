<template>
    <div class="image-container">
        <img class="custom-icon" src="../assets/images/logo.png" alt="图标">
        <h style="margin-left:120px; font-weight: bold;font-size: 50px;">镜头下的诗意世界，让每个瞬间永恒流转</h>
        <div class="login-container" style="margin-top:-60px">
            <el-form ref="loginForm" :model="formInfo" :rules="loginRules" label-width="50px" class="login-form">
                <h2 class="login-title" style="margin-bottom: 5px;">登录OneShot社区</h2>
                <p style="margin-bottom: 50px;">特约供稿人 & 共同开发者的用户无需注册，可直接登录</p>
                <el-form-item prop="email" label="邮箱" :message="errorMessage">
                    <el-input v-model="formInfo.email"></el-input>
                </el-form-item>

                <el-form-item style="margin-top: 30px;margin-bottom: 30px;" prop="password" label="密码">
                    <el-input type="password" v-model="formInfo.password"></el-input>
                    <router-link to="/forget-password">
                        <p style="margin-left: 4px;">忘记密码</p>
                    </router-link>
                </el-form-item>

                <div class="form-buttons">
                    <div>
                        <el-button type="primary" @click="login" style="margin-left:53px;width:255px;height:40px
                    margin-top:30px">
                            <p style="font-weight: bold;font-size: 20px;">登录</p>
                        </el-button>
                        <p style="font-size: 12px;margin-left: 83px;margin-top: 20px;">
                            登录即代表同意服务协议和隐私政策
                        </p>
                    </div>

                </div>
                <div>
                    <router-link to="/register">
                        <p style="font-size: 12px;margin-top: 50px;margin-left:121px">还没有账号？点击注册</p>
                    </router-link>
                </div>
            </el-form>
        </div>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, onMounted, onUnmounted, ref } from 'vue';
const { proxy } = getCurrentInstance();

import { useRouter } from 'vue-router';
const router = useRouter();

import { ElMessage, localeContextKey } from 'element-plus';

import axios from '../utils/request';
import { resolvedObj } from '../utils/request';

const formInfo = ref({
    email: "",
    password: ""
})


const errorMessage = ref("");

const loginRules = ref({
    email: [
        { required: true, message: '请输入邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入有效的邮箱地址', trigger: ['blur', 'change'] }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
    ]
})

const login = () => {
    const loginForm = proxy.$refs.loginForm;
    loginForm.validate(valid => {
        if (valid) {
            // 验证通过，执行登录逻辑
            const param = {
                email: formInfo.value.email,
                password: formInfo.value.password
            }
            const loginData = JSON.stringify(param);
            console.log(loginData);
            axios.post("http://localhost:8080/login", loginData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    console.log(resolvedObj.value);
                    const token = resolvedObj.value.data;
                    console.log(token);
                    //如果token存在，说明登录成功，则跳转入shots网页，否则
                    if (token !== undefined) {
                        localStorage.removeItem('token');
                        if (localStorage.getItem('id') !== null)
                            localStorage.removeItem('id')
                        if (localStorage.getItem('username') !== null)
                            localStorage.removeItem('username');
                        localStorage.setItem('token', token);
                        console.log("陈工");
                        console.log(token);
                        ElMessage.success("登录成功");
                        router.replace({
                            path: '/shots'
                        })
                    }
                    //token不存在
                    else {
                        ElMessage.error("登录失败：邮箱或密码错误");
                    }
                    console.log(token.value);
                })
            // 重置表单
            loginForm.resetFields();
        } else {
            // 验证不通过，不执行登录逻辑
        }
    });
}
</script>
  
  
<style scoped>
.login-title {
    margin-bottom: 20px;
    font-size: 32px;
    font-weight: bold;
}

.image-container {
    background-image: url(../assets/images/pink.png);
    /* background-size:cover; */
    background-color: transparent;
}

.custom-icon {
    width: 140px;
    height: 40px;
    margin-left: 30px;

}

.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    /* background-image: url(../assets/images/1.jpg); */
    /* background-size:cover;  */
    /* opacity: 0.5;*/

}

.login-form {
    width: 420px;
    height: 550px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    align-items: center;
    background-color: rgba(255, 255, 255, 0.4);
    /* 设置不透明度 */
}

.login-form h2 {
    text-align: center;
}

.login-form label {
    margin: auto 0;
    display: block;
}

.login-form .el-input {
    width: 80%;
    padding: 5px;
    margin: auto 0px;
    border-radius: 3px;
}

.form-buttons {
    margin-top: 20px;
    display: flex;
    justify-content: space-between;
}

.form-buttons button {
    padding: 8px 15px;
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
}

.form-buttons button:hover {
    background-color: #0056b3;
}
</style>
  