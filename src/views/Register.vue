<template>
    <!-- <div class="Header">
<Header /></div> -->
    <div class="image-container">
        <h style="margin-left:320px; font-weight: bold;font-size: 50px;">我忘掉所有悲剧，只愿留下最美的瞬间</h>
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
                        <el-radio style="margin-right: 20px;" label="Male">男</el-radio>
                        <el-radio style="margin-right: 20px;" label="Female">女</el-radio>
                        <el-radio label="Walmart">其他</el-radio>
                    </el-radio-group>
                </el-form-item>

                <el-form-item prop="signature" label="个性签名">
                    <el-input type="textarea" v-model="formInfo.personSignature"></el-input>
                </el-form-item>

                <div class="form-buttons">
                    <el-button type="primary" @click="register">
                        <p style="font-weight: bold;">注册</p>
                    </el-button>
                </div>
                <p style="font-size: 10px;margin-left: 50px;margin-top: 15px;">
                    注册即表示您已同意我们的服务协议和隐私政策
                </p>


            </el-form>
        </div>
    </div>
</template>
  
<script setup>
import Header from '../components/Header.Vue';
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
.Header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100px;
    /* 设置适当的高度 */
    z-index: 999;
    /* 添加其他样式 */
}

.image-container {
    background-image: url(../assets/images/注册.png);
    /* background-size:cover; */
    background-color: transparent;
    background-color: rgba(255, 255, 255, 0.4);
}

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
    margin-top: -65px;
}

.register-form {
    width: 400px;
    height: 550px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: rgba(255, 255, 255, 0.4);
    /* 设置不透明度 */
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
}</style>