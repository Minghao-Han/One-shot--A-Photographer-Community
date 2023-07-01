<template>
    <div class="reset-container">
        <el-form ref="resetForm" :model="formInfo" :rules="resetRules" label-width="80px" class="reset-form">
            <h2 class="reset-title">找回密码</h2>
            <el-form-item prop="email" label="注册邮箱">
                <el-input v-model="formInfo.email"></el-input>
            </el-form-item>

            <el-form-item prop="code" label="验证码">
                <el-input v-model="formInfo.code"></el-input>
                <el-button type="primary" @click="sendCode">发送验证码</el-button>
            </el-form-item>

            <el-form-item prop="newPassword" label="新密码">
                <el-input type="password" v-model="formInfo.newPassword"></el-input>
            </el-form-item>

            <div class="form-buttons">
                <el-button type="primary" @click="resetPassword">重置密码</el-button>
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
    code: "",
    newPassword: ""
})

const resetRules = ref({
    email: [
        { required: true, message: '请输入邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入有效的邮箱地址', trigger: ['blur', 'change'] }
    ],
    code: [
        { required: true, message: '请输入验证码', trigger: 'blur' }
    ],
    newPassword: [
        { required: true, message: '请输入新密码', trigger: 'blur' },
        { min: 6, max: 20, message: '密码长度应在6到20之间', trigger: 'blur' }
    ]
})

const sendCode = () => {
    // 发送验证码的逻辑
    api.sendCode(formInfo.value.email);
}

const resetPassword = () => {
    const resetForm = proxy.$refs.resetForm;
    resetForm.validate(valid => {
        if (valid) {
            // 验证通过，执行重置密码的逻辑
            api.resetPassword(formInfo.value.email, formInfo.value.code, formInfo.value.newPassword);
            // 重置表单
            resetForm.resetFields();
        } else {
            // 验证不通过，不执行重置密码的逻辑
        }
    });
}
</script>
  
<style scoped>
.reset-title {
    margin-bottom: 20px;
    font-size: 32px;
    font-weight: bold;
}

.reset-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.reset-form {
    width: 400px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.reset-form h2 {
    text-align: center;
}

.reset-form label {
    margin: auto 0;
}

.reset-form .el-input {
    width: 80%;
}

.form-buttons {
    margin-top: 20px;
}

.form-buttons button {
    padding: 8px 15px;
}
</style>
  