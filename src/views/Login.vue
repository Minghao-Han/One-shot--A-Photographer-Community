<template>
    <div class="login-container">
        <el-form ref="loginForm" :model="loginData" :rules="loginRules" label-width="80px" class="login-form">
            <h2 class="login-title">用户登录</h2>
            <el-form-item prop="username">
                <el-input v-model="loginData.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" v-model="loginData.password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, onMounted, ref } from 'vue';
const { proxy } = getCurrentInstance();
import axios from 'axios';
import api from '../api/index';

//token
const token = ref();
const loginData = ref({
    username: '',
    password: ''
});
const loginRules = ref({
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
    ]
});
const errorMessage = ref('');

function submitForm() {
    const loginForm = proxy.$refs.loginForm;
    console.log('loginForm>>' + loginForm);

    if (loginForm) {
        loginForm.validate(valid => {
            if (valid) {
                console.log(loginData.value);
                // 登录表单验证通过，可以在这里进行登录操作
                api.login(loginData.value.username, loginData.value.password);
                // const param = {
                //     email: loginData.value.username,
                //     password: loginData.value.password
                // }

                // const loginJson = JSON.stringify(param);
                // axios.post("http://localhost:8080/login", loginJson, {
                //     headers: {
                //         'Content-Type': 'application/json'
                //     }
                // })
                //     .then(response => {
                //         console.log(response);
                //     })
            } else {
                console.log('表单验证失败');
                return false;
            }
        });
    }
}
</script>
  
<style scoped>
.login-container {
    max-width: 400px;
    margin: 0 auto;
    padding: 40px 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.login-title {
    text-align: center;
    margin-bottom: 20px;
}

.login-form {
    display: flex;
    flex-direction: column;
}
</style>