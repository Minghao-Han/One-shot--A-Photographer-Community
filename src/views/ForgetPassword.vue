<template>
    <div class="background">
        <div class="welcome">
            <div style="margin-left: 12vw;">
                Remember Me
            </div>
            <div style="margin-left: 43vw;">
                Next Time~
            </div>
        </div>
        <div class="reset-container">
            <el-form ref="resetForm" :model="formInfo" :rules="resetRules" label-width="130px" class="reset-form">
                <div class="title">
                    <h2 class="reset-title">找回密码</h2>
                </div>
                <el-form-item prop="email" label="你的邮箱">
                    <el-input v-model="formInfo.email"></el-input>
                </el-form-item>
                <div class="flex-center">
                    <el-button type="primary" @click="sendCode" style="margin-bottom: 18px;width: auto;" color="#0e909f"
                        plain>发送验证码</el-button>
                </div>
                <el-form-item prop="code" label="输入验证码">
                    <el-input v-model="formInfo.code"></el-input>
                </el-form-item>
                <div class="flex-center">
                    <el-button type="primary" @click="confirmCode" color="#0e909f" plain>确认验证码</el-button>
                </div>
                <el-form-item v-if="show" prop="newPassword" label="新密码">
                    <el-input type="password" v-model="formInfo.newPassword"></el-input>
                </el-form-item>

                <div class="form-buttons flex-center">
                    <el-button type="primary" @click="resetPassword" style="margin-bottom: 8px;" v-if="show" color="#0e909f"
                        plain>重置密码</el-button>
                </div>
            </el-form>
        </div>
    </div>
</template>
  
<script setup>
import { getCurrentInstance, ref } from 'vue';

import { reactive, onMounted } from 'vue'
import { ElMenu, ElMenuItem, ElCard } from 'element-plus'
import axios from '../utils/request'
import { resolvedObj } from '../utils/request'

const { proxy } = getCurrentInstance();
const formInfo = ref({
    email: "",
    code: "",
    newPassword: ""
})

const show = ref(false)

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




//formInfo.value.email,
const urlHead = 'http://localhost:8080/';
// 发送验证码
const sendCode = () => {
    axios.get(urlHead + "password/reset?email=" + formInfo.value.email, {
        headers: {
            'Content-Type': 'application/json'

        }
    })
    // api.sendCode(formInfo.value.email);
    console.log(formInfo.value.email)
}

const confirmCode = () => {
    const param = {
        email: formInfo.value.email,
        captcha: formInfo.value.code
    }
    const confirmData = JSON.stringify(param);
    axios.post(urlHead + "password/reset", confirmData,
        {
            headers: {
                'Content-Type': 'application/json'

            }
        }).then(response => {
            console.log(resolvedObj.value);
            if (resolvedObj.value.status === 200) {
                show.value = true
            }
            else {
                show.value = false
            }
        })
}

const resetPassword = () => {
    const data = {
        email: formInfo.value.email,
        newPassword: formInfo.value.newPassword
    };
    axios.put(urlHead + "password/reset", data, {
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => {
        console.log(resolvedObj.value)
    });
}
</script>
  
<style scoped>
.flex-center {
    display: flex;
    justify-content: center;
}

.welcome {
    padding: 1vh 5vw;
    padding-bottom: 0;
    height: 20vh;
}

.welcome div {
    margin-top: 6vh;
    font-size: 90px;
    font-weight: 900;
    line-height: 60px;
    color: #0e909f79;
    font-family: sans-serif;

}

.background {
    width: 100%;
    height: 100%;
    background-image: url(@/assets/images/green.png);
}

.title h2 {
    color: rgba(102, 16, 16, 0.63)
}


.reset-title {
    margin-bottom: 20px;
    font-size: 32px;
    font-weight: bold;


}

.reset-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 80vh;

}

.reset-form {
    width: 400px;
    padding: 10px;
    /* border: 1px solid #ccc; */
    border-radius: 15px;
    background-color: rgba(255, 255, 255, .5);

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
  