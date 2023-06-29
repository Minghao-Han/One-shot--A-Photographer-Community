<template>
    <div class="login-container">
        <el-form ref="loginForm" :model="formInfo" :rules="loginRules" label-width="80px" class="login-form">
            <h2>登录</h2>
            <el-form-item prop="email" label="邮箱">
                <el-input v-model="formInfo.email"></el-input>
            </el-form-item>

            <el-form-item prop="password" label="密码">
                <el-input type="password" v-model="formInfo.password"></el-input>
            </el-form-item>

            <div class="form-buttons">
                <el-button type="primary" @click="login">登录</el-button>
                <router-link to="/forgot-password">忘记密码</router-link>
                <router-link to="/register">注册</router-link>
            </div>
        </el-form>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, ref } from 'vue';
const { proxy } = getCurrentInstance();
import api from '../api/index';
const formInfo = ref({
    email: "",
    password: ""
})

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
            api.login(formInfo.value.email, formInfo.value.password);
            // 重置表单
            loginForm.resetFields();
        } else {
            // 验证不通过，不执行登录逻辑
        }
    });
}
</script>
  
  
<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-form {
    width: 300px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.login-form h2 {
    text-align: center;
}

.login-form label {
    margin-top: 10px;
    display: block;
}

.login-form input {
    width: 100%;
    padding: 5px;
    margin-top: 5px;
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
  