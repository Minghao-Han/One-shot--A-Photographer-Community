<template>
    <div class="register-container">
        <el-form ref="registerForm" :model="formInfo" :rules="registerRules" label-width="80px" class="register-form">
            <h2 class="register-title">注册账号</h2>
            <el-form-item prop="email" label="注册邮箱">
                <el-input v-model="formInfo.email"></el-input>
            </el-form-item>

            <el-form-item prop="password" label="密码">
                <el-input type="password" v-model="formInfo.password"></el-input>
            </el-form-item>

            <el-form-item prop="confirmPassword" label="确认密码">
                <el-input type="password" v-model="formInfo.confirmPassword"></el-input>
            </el-form-item>

            <el-form-item prop="userName" label="用户名">
                <el-input v-model="formInfo.userName"></el-input>
            </el-form-item>

            <el-form-item prop="age" label="年龄">
                <el-input-number v-model="formInfo.age"></el-input-number>
            </el-form-item>

            <el-form-item prop="gender" label="性别">
                <el-radio-group v-model="formInfo.gender">
                    <el-radio label="Male">男</el-radio>
                    <el-radio label="Female">女</el-radio>
                    <el-radio label="Walmart">其他</el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item prop="signature" label="个性签名">
                <el-input type="textarea" v-model="formInfo.personSignature"></el-input>
            </el-form-item>

            <div class="form-buttons">
                <el-button type="primary" @click="register">注册</el-button>
            </div>


        </el-form>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, ref } from 'vue';
import { ElMessage } from 'element-plus';
import { resolvedObj } from '../utils/request';
import { useRouter } from 'vue-router';
const router = useRouter();
import axios from "../utils/request";
const { proxy } = getCurrentInstance();
const formInfo = ref({
    email: "",
    password: "",
    confirmPassword: "",
    userName: "", // 拆分User对象
    gender: "",
    age: 1,
    personSignature: ""
})

const registerRules = ref({
    email: [
        { required: true, message: '请输入邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入有效的邮箱地址', trigger: ['blur', 'change'] }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 6, max: 20, message: '密码长度应在6到20之间', trigger: 'blur' }
    ],
    confirmPassword: [
        { required: true, message: '请再次输入密码', trigger: 'blur' },
        {
            validator: (rule, value, callback) => {
                if (value !== formInfo.value.password) {
                    callback(new Error('两次输入的密码不一致'));
                } else {
                    callback();
                }
            }, trigger: 'blur'
        }
    ],
    userName: [
        { required: true, message: '请输入用户名', trigger: 'blur' },
        { min: 2, max: 20, message: '用户名长度应在2到20之间', trigger: 'blur' }
    ],
    age: [
        { required: true, message: '请输入年龄', trigger: 'blur' },
        { type: 'number', message: '年龄必须是数字', trigger: 'blur' }
    ],
    gender: [
        { required: true, message: '请选择性别', trigger: 'change' }
    ],
    signature: [
        { max: 100, message: '个性签名不能超过100个字符', trigger: 'blur' }
    ]
})

const register = () => {
    const registerForm = proxy.$refs.registerForm;
    registerForm.validate(valid => {
        if (valid) {
            // 验证通过，执行注册逻辑
            const param = {
                email: formInfo.value.email,
                password: formInfo.value.password,
                User: {
                    userName: formInfo.value.userName,
                    gender: formInfo.value.gender,
                    age: formInfo.value.age,
                    personSignature: formInfo.value.personSignature
                }
            }


            const registerData = JSON.stringify(param);
            console.log(registerData);
            axios.post("http://localhost:8080/register", registerData, {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {

                })
            // 重置表单
            registerForm.resetFields();
            router.replace("/login");

        } else {
            // 验证不通过，不执行注册逻辑
        }
    });
}
</script>
  
<style scoped>
.register-title {
    margin-bottom: 20px;
    font-size: 32px;
    font-weight: bold;
}

.register-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.register-form {
    width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.register-form h2 {
    text-align: center;
}

.register-form label {
    margin: auto 0;
}

.register-form .el-input {
    width: 80%;
}

.form-buttons {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.form-buttons button {
    padding: 8px 15px;
}
</style>