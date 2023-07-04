<template>
    <div class="shot-container">
        <el-row class="shot-poster" justify="space-between" :gutter='20'>
            <el-col class="poster-info" :span="12">
                <!-- <img class="poster-avator" alt src="http://localhost:8080/images/shots/vx.jpg"> -->
                <el-avatar :src="img1" fit="fill" />
                <h3 class="poster-name">{{ props.newShot.user_name }}</h3>
            </el-col>

            <el-col class="follow-button" span="2">
                <el-button type="primary" :icon="Plus" color="#7c7c7c" plain>
                    关注
                </el-button>
            </el-col>

        </el-row>
        <div class="shot-img-container">
            <el-image :src="img4" class="shot-image" fit="contain" />
        </div>
        <div class="shot-title">
            <h2 class="title">
                {{ props.newShot.title }}
            </h2>
        </div>
        <div class="shot-content">
            <p class="content">
                {{ props.newShot.content }}
            </p>
        </div>

        <el-row :gutter="20" justify="space-between" class="icons">
            <el-col :span="12" class="shot-function-icons">
                <el-icon class="thumb icon" @click="thumb">
                    <Orange :color="orangeColor" />
                </el-icon>
                <span class="icon-number">{{ props.newShot.total_thumb }}</span>
                <el-icon class="collect icon" @click="collect">
                    <CollectionTag :color="redColor" />
                </el-icon>
                <span class="icon-number">{{ props.newShot.total_collect }}</span>
                <span class="icon-number"> 浏览量{{ props.newShot.pageView }}</span>
            </el-col>

            <el-col :span="3">
                <span class="icon-number"> {{ props.newShot.createTime }} </span>
            </el-col>

            <el-col :span="4" class="shot-comment">
                <el-icon class="icon" @click="comment">
                    <ChatLineSquare />
                </el-icon>
            </el-col>
        </el-row>

        <CommentArea v-if="showComment" :comments="myComments"></CommentArea>
    </div>
</template>
<script setup>
import { computed, getCurrentInstance, onBeforeUpdate, onMounted, onUpdated, reactive, ref } from 'vue';
import { Plus, Orange, View, CollectionTag, ChatLineSquare } from '@element-plus/icons-vue'
import { resolvedObj } from '../utils/request';
import { useRouter } from 'vue-router';
const { proxy } = getCurrentInstance();
const router = useRouter();
import CommentArea from './CommentArea .vue';
import request from '../utils/request';
import img1 from '@/assets/images/1.jpg';
import img2 from '@/assets/images/2.jpg';
import img3 from '@/assets/images/pic.jpg';
import img4 from '@/assets/images/4.jpg';

const pageNum = ref(1);

const myComments = ref();

const shotObj = ref({
})

const props = defineProps({
    newShot: Object
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

onUpdated(() => {
    console.log("shot");
    console.log(props.newShot);
    shotObj.value = props.newShot;
    console.log(shotObj.value);
})


const posterName = ref("小芳");
const shotTitle = ref("你好，世界");
const shotContent = ref("Hello, OneShot!");
//判断是否点赞或收藏
const isThumbed = ref(false);
const isCollected = ref(false);
//判断是否打开评论区
const showComment = ref(false);
//计算属性用来改变颜色
const orangeColor = computed(() => {
    return isThumbed.value === true ? "orange" : "";
})
const redColor = computed(() => {
    return isCollected.value === true ? "red" : "";
})
// 點贊
const thumb = () => {
    isThumbed.value = !isThumbed.value;
    if (isThumbed.value) {
        const param = {
            shot_id: shotObj.value.id
        }

        const data = JSON.stringify(param);
        request.post("http://localhost:8080/thumb/shot", data, config)
            .then(() => {
                if (resolvedObj.value.code === "500") {
                    ElMessage("验证过期，请重新登录");
                    router.replace('/login');
                }
                else {
                    shotObj.value.total_thumb++;
                    console.log(resolvedObj.value);
                }
            })
    }
    else {

        const param = {
            shot_id: shotObj.value.id
        }

        const data = JSON.stringify(param);
        request.delete("http://localhost:8080/thumb/shot", {
            headers: {
                'Content-Type': 'application/json',
                'token': localStorage.getItem('token')
            },
            data: data
        })
            .then(() => {
                if (resolvedObj.value.code === "500") {
                    ElMessage("验证过期，请重新登录");
                    router.replace('/login');
                }
                else {
                    shotObj.value.total_thumb--;
                    console.log(resolvedObj.value);
                }
            })
    }

}
//收藏
const collect = () => {
    isCollected.value = !isCollected.value;
    if (isCollected.value)
        shotObj.value.total_collect++;
    else shotObj.value.total_collect--;
}

//评论
const comment = () => {
    showComment.value = !showComment.value;
    if (showComment.value) {
        const url = 'http://localhost:8080/comment/shot/' + props.newShot.id + "/" + pageNum.value;
        request.get(url, config)
            .then(() => {
                console.log(resolvedObj.value);
                myComments.value = resolvedObj.value.data;
                console.log(myComments.value)
                pageNum.value++;
            })
    }
}

//发表评论
const postComment = () => {

}

const addZero = function (num) {
    if (parseInt(num) < 10) {
        num = "0" + num
    }
    return num
}

//毫秒转日期
function getMyDate(str) {
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth() + 1,
        oDay = oDate.getDate(),
        oTime = oYear + '-' + (oMonth) + '-' + (oDay);
    return oTime;
}


</script>

<style scoped>
.shot-container {
    margin: 20px auto;
    background-color: white;
    box-shadow: 0 0 5px 1px #a2a2a2;
    /* border-radius: 5px; */
}

.shot-container .icon-number {
    margin-right: 5px;
    margin-left: 3px;
    color: #7b7b7b
}

.shot-container .shot-poster {
    padding: 12px 12px;
}

.shot-container .poster-info {
    display: flex;
    align-items: center;
    margin-left: 10px;
}

.shot-container .shot-img-container {
    display: flex;
    justify-content: center;

}

.shot-container .shot-image {
    margin: 10px auto;
    max-height: 600px;

}

/* .shot-container .el-image__inner {
    max-height: 600px;
}

.el-image__inner {
    max-height: 600px;
} */


.shot-container .poster-name {
    margin-left: 10px;
}

.shot-container .shot-function-icons {
    margin-left: 10px;
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.shot-container .icon {
    font-size: 24px;

    transition: transform 0.2s;
}

.shot-container .icon:hover {
    cursor: pointer;
    transform: translateY(-6px);
}


.shot-container .shot-comment {
    display: flex;
    justify-content: flex-end;
    margin-right: 10px;
}

.shot-container .title {
    margin-left: 10px;
}

.shot-container .content {
    margin-left: 15px;
    text-indent: 2em;
    margin-bottom: 8px;
}

.shot-container .follow-button {
    margin-right: 6px;
}

/* .shot-container .icons {
    display: flex;
    flex-direction: row;
    align-items: center;
} */
</style>