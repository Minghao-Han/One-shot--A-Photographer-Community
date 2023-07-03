<template>
    <Header />

    <el-container class="main-content">
        <ShotsContainer :new-shots="shots" />
        <Aside />
    </el-container>

    <el-backtop :right="100" :bottom="100" />
</template>

<script setup>

import Header from '../components/Header.vue';
import ShotsContainer from '../components/ShotsContainer.vue';
import Aside from '../components/Aside.vue';
import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import axios from '../utils/request'
import { useRouter } from 'vue-router';
import { resolvedObj } from '../utils/request';
import { ElMessage } from 'element-plus';
const pageNum = ref(1);
const router = useRouter();


const shots = ref();

//获取最初的shot
onMounted(() => {
    shotsPage();
})

//请求一页shots
const shotsPage = () => {
    const url = "http://localhost:8080/shotBrowse/4/" + pageNum.value;
    axios.get(url, {
        headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }
    })
        .then(response => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            console.log("res.data=>")
            console.log(resolvedObj.value);
            shots.value = resolvedObj.value.data;
            pageNum.value++;
            console.log(shots.value[0]);
        })
}
</script>

<style scoped>
.main-content {
    display: flex;
    justify-content: center;
}
</style>