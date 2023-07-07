<template>
    <div class="header-content">

        <el-header class="header">
            <el-row :gutter="30" class="header-row" justify="center">
                <el-col class="grid-content" :span="4">
                    <img src="@/assets/images/logo.png" alt="OneShot" class="icon">
                </el-col>

                <el-col :offset="0" :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/shots.png" alt="Shots" class="icon" @click="goToShots">
                    <p class="navi-word">动态</p>
                </el-col>

                <el-col :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/forum.png" alt="Forum" class="icon" @click="goToGame">
                    <p class="navi-word">比赛</p>
                </el-col>
                <el-col :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/competition.png" alt="Competition" class="icon" @click="goToEquip">
                    <p class="navi-word">器材</p>
                </el-col>

                <el-col :offset="2" :span="5" class="grid-content">
                    <el-input deep v-model="searchInfo" placeholder="你有一双发现美的眼睛" cleartable class="search-input">
                        <template #prepend>
                            <el-button :icon="Search" class="search-icon" @click="search" />
                        </template>
                    </el-input>
                </el-col>

                <el-col :offset="0" :span="1" class="grid-content">
                    <img src="@/assets/images/add.png" alt="post shot" class="icon" @click="postShot">
                </el-col>

                <el-col :offset="1" :span="1" class="grid-content">
                    <img :src="'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + id + '.jpg'" alt="avator"
                        class="icon avator" @click="goToUserInfo">
                </el-col>
            </el-row>
        </el-header>

        <!-- 弹出对话框，判断是否发布shot -->
        <el-dialog v-model="centerDialogVisible" title="发布我的Shot" width="30%" align-center>
            <UpLoadTest />
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="centerDialogVisible = false">取消</el-button>
                    <el-button type="primary" @click="centerDialogVisible = false">
                        确定
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>
<script setup>
import { Search } from "@element-plus/icons-vue"
import { useRouter } from "vue-router";
import { ref, reactive, defineProps, onMounted, watch } from "vue";
import UpLoadTest from "../views/UpLoadTest.vue";
import Tag from "./Tag.vue";
import request from '../utils/request'
import { resolvedObj } from "../utils/request";
const router = useRouter();
const centerDialogVisible = ref(false)

//用来计数，动态添加tag
const countArray = ref(new Array(1));

const searchInfo = ref("");

const id = ref(1);

watch(() => localStorage.getItem('id'), (newValue, oldValue) => {
    id.value = newValue;
    console.log("id>>" + id.value);
}, {
    deep: true,
    immediate: true
})

//用来记录tag的数组
const tagArray = ref(new Array());

const onAddTag = (tagContent) => {
    countArray.value.push(1);
    tagArray.value.push(tagContent);
    console.log("tags:")
    console.log(tagArray.value);
}

const form = reactive({
    title: '',
    content: ''

})

const goToGame = () => {
    router.push('/game')
}

const goToShots = () => {
    router.push('/shots')
}

const goToEquip = () => {
    router.push('/equipment')
}

const search = () => {
    router.push('/search')
}

const goToUserInfo = () => {
    router.push('/user-info')
}

const postShot = () => {
    centerDialogVisible.value = true;
}

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}
const save = () => {
    console.log(form)
    const url = 'http://localhost:8080/shot';
    const param = {
        content: form.content,
        title: form.title,
        tags: tagArray.value
    }
    const data = JSON.stringify(param);
    console.log("postdata:")
    console.log(data)
    request.post(url, data, config)
        .then(() => {
            console.log(resolvedObj.value);
            uploadImageToServer(resolvedObj.value.data);
        })
}
// 上传图片到服务器，id从后端返回的response中获取
const uploadImageToServer = id => {
    const url = "http://localhost:8080/shot"
    const param = {
        shotid: id
    }
}

</script>
<style scoped>
.header-content .header {
    display: flex;
    flex-direction: column;
    height: 75px;
}

.header .header-row {
    margin: auto 0;
    border-bottom: 1px solid #a6a6a6;
}

.header .navi-block {
    display: flex;
    flex-direction: column;
    align-items: center;
    vertical-align: center;
    padding: 0 !important;
}

.header .navi-block:hover {
    cursor: pointer;
}

.header .navi-block img {
    margin-top: 1vh;
}

.header .navi-word {
    padding: 0;
}


.grid-content {
    min-height: 48px;
    vertical-align: center;
    display: flex;
    align-items: center;
}

.grid-content:hover {
    cursor: pointer;
}

.header .icon {
    height: 40px;
}

.header .avator {
    border-radius: 50%;
    border: solid;
    height: 48px;
}

.grid-content .el-input {
    box-shadow: black;
    height: 60%;
    font-size: 110%;
    --el-input-focus-border-color: #000;
}
</style>