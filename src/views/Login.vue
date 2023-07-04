<template>
    <div class="login-container">
        <el-form ref="loginForm" :model="formInfo" :rules="loginRules" label-width="50px" class="login-form">
            <h2 class="login-title">欢迎来到OneShot</h2>
            <el-form-item prop="email" label="邮箱" :message="errorMessage">
                <el-input v-model="formInfo.email"></el-input>
            </el-form-item>

            <el-form-item prop="password" label="密码">
                <el-input type="password" v-model="formInfo.password"></el-input>
                <router-link to="/forget-password">忘记密码</router-link>
            </el-form-item>

            <div class="form-buttons">
                <div>
                    <el-button type="primary" @click="login">登录</el-button>
                </div>
                <div>
                    <router-link to="/register">注册</router-link>
                </div>
            </div>
        </el-form>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, onMounted, onUnmounted, ref } from 'vue';
const { proxy } = getCurrentInstance();

import { useRouter } from 'vue-router';
const router = useRouter();

import { ElMessage } from 'element-plus';

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

.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-form {
    width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    align-items: center;
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
  