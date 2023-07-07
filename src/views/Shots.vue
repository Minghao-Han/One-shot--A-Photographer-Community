<template>
    <Header style="position: fixed;top: 0;width: 100vw;background-color: rgb(255, 255, 255); z-index: 1 ;" />


    <el-container class="main-content" style="margin-top: 60px;">
        <ShotsContainer :new-shots="shots">
            <template #bottom>
                <div class="load-more" v-if="isOver" @mouseenter="loadShots">
                    <p>显示更多shot</p>
                </div>
                <div class="load-more" v-if="!isOver">
                    <p>已经加载完成所有的shot</p>
                </div>
            </template>
        </ShotsContainer>
        <Aside :user="userInfo" />
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
const pageNum = ref(2);
const router = useRouter();
const isOver = ref(true);


const shots = ref(new Array());
const userInfo = ref({

});

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

//获取最初的shot
onMounted(() => {
    console.log("1");
    shotsPage();
    //更新侧边栏
    initAside();
})


const loadShots = () => {
    isOver.value = false;
    shotsPage();
}

//请求一页shots
const shotsPage = () => {
    const url = "http://localhost:8080/shotBrowse/" + pageNum.value;
    axios.get(url, config)
        .then(response => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            else {
                console.log("res.data=>")
                console.log(resolvedObj.value);
                if (resolvedObj.value.status === 400) {
                    isOver.value = false;
                    return;
                }
                shots.value = shots.value.concat(resolvedObj.value.data);
                pageNum.value++;
                isOver.value = true;
                console.log("page:" + pageNum.value);
                console.log(shots.value);
            }
        })
}

const initAside = () => {
    const url = "http://localhost:8080/userInfo";
    axios.get(url, config)
        .then(response => {
            console.log(resolvedObj.value);
            userInfo.value = resolvedObj.value.data;
            localStorage.setItem('username', userInfo.value.userName);
            localStorage.setItem('id', userInfo.value.id);
        })
}
</script>

<style scoped>
.main-content {
    display: flex;
    justify-content: center;
}

.load-more {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 16px;
}
</style>