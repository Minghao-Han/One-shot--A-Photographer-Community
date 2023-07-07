<template>
    <div class="shot-container">
        <el-row class="shot-poster" justify="space-between" :gutter='20'>
            <el-col class="poster-info" :span="12">
                <!-- <img class="poster-avator" alt src="http://localhost:8080/images/shots/vx.jpg"> -->
                <el-avatar :src="'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + shotObj.user_id + '.jpg'"
                    fit="fill" />
                <h3 class="poster-name">{{ shotObj.user_name }}</h3>
            </el-col>

            <el-col class="follow-button" span="2">
                <!-- <el-button type="primary" :icon="Plus" color="#7c7c7c" plain v-if="followed">
                    关注
                </el-button> -->
            </el-col>
        </el-row>
        <div class="shot-img-container" @mouseover="addView">
            <el-image :src="imgSrc" class="shot-image" fit="contain" />
        </div>
        <div class="shot-title">
            <h2 class="title">
                {{ shotObj.title }}
            </h2>
        </div>
        <div class="shot-content">
            <p class="content">
                {{ shotObj.content }}
            </p>
        </div>

        <el-row :gutter="20" justify="space-between" class="icons">
            <el-col :span="9" class="shot-function-icons">
                <el-icon class="thumb icon" @click="thumb">
                    <Orange :color="orangeColor" />
                </el-icon>
                <span class="icon-number">{{ shotObj.total_thumb }}</span>
                <el-icon class="collect icon" @click="collect">
                    <CollectionTag :color="redColor" />
                </el-icon>
                <span class="icon-number">{{ shotObj.total_collect }}</span>
                <span class="icon-number"> 浏览量{{ shotObj.pageView }}</span>
            </el-col>

            <el-col :span="3">
                <span class="icon-number"> {{ dateTime }} </span>
            </el-col>

            <el-col :span="4" class="shot-comment">
                <el-icon class="icon" @click="comment">
                    <ChatLineSquare />
                </el-icon>
            </el-col>
        </el-row>

        <CommentArea v-if="showComment" :comments="myComments" :shotId="props.newShot.id" :posterId="props.newShot.user_id"
            @postComment="loadNewComment">
            <template #load>
                <div class="load-more" v-if="isOver" @mouseenter="loadComment">
                    <p>显示更多评论</p>
                </div>
                <div class="load-more" v-if="!isOver">
                    <p>已经加载所有评论</p>
                </div>
            </template>
        </CommentArea>
    </div>
</template>
<script setup>
import { computed, getCurrentInstance, onBeforeUpdate, onMounted, onUpdated, reactive, ref, watch } from 'vue';
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

const myComments = ref(new Array());

const shotObj = ref({})

const props = defineProps({
    newShot: Object
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

watch(() => props.newShot, (newValue, oldValue) => {
    console.log("new>>")
    console.log(newValue);
    shotObj.value = newValue;
}, { deep: true, immediate: true })

const imgSrc = computed(() => {
    return "https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/" + shotObj.value.id + ".jpg";
})


onUpdated(() => {
    console.log("shot");
    console.log(props.newShot);
    shotObj.value = props.newShot;
    console.log(shotObj.value);
})

onMounted(() => {
    isThumbed.value = props.newShot.thumbed;
    isCollected.value = props.newShot.collected;
})


const isVisited = ref(false);

const isOver = ref(true)
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
const param = {
    shot_id: props.newShot.id
}

const data = JSON.stringify(param);
//增加浏览量
const addView = () => {
    if (!isVisited.value) {
        isVisited.value = true;
        request.post('http://localhost:8080/shotBrowse/pageView', data, config)
            .then(() => {
                shotObj.value.pageView++;
            })
    }
}
// 點贊
const thumb = () => {
    isThumbed.value = !isThumbed.value;
    if (isThumbed.value) {
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
            shot_id: props.newShot.id
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
    if (isCollected.value) {
        const param = {
            shot_id: props.newShot.id
        }

        const data = JSON.stringify(param);
        request.post("http://localhost:8080/collect/shot", data, config)
            .then(() => {
                if (resolvedObj.value.code === "500") {
                    ElMessage("验证过期，请重新登录");
                    router.replace('/login');
                }
                else {
                    shotObj.value.total_collect++;
                    console.log(resolvedObj.value);
                }
            })
    }

    else {
        const param = {
            shot_id: props.newShot.id
        }

        const data = JSON.stringify(param);
        request.delete("http://localhost:8080/collect/shot", {
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
                    shotObj.value.total_collect--;
                    console.log(resolvedObj.value);
                }
            })
    }
}

const loadNewComment = (newComment) => {
    if (myComments.value === undefined)
        myComments.value = [];
    myComments.value.unshift(newComment);
}

//读取新的评论
const loadComment = () => {
    console.log("get")
    isOver.value = false;
    const url = 'http://localhost:8080/comment/shot/' + props.newShot.id + "/" + pageNum.value;
    request.get(url, config)
        .then(() => {
            console.log(resolvedObj.value);
            if (resolvedObj.value.data !== undefined)
                myComments.value = myComments.value.concat(resolvedObj.value.data);
            console.log(myComments.value)
            if (resolvedObj.value.status === 400) {
                isOver.value = false;
                return;
            }
            isOver.value = true;
            pageNum.value++;
        })
}

//初始化评论
const getNewComment = () => {
    console.log("getNewComment")
    const url = 'http://localhost:8080/comment/shot/' + props.newShot.id + "/1";
    request.get(url, config)
        .then(() => {
            console.log(resolvedObj.value);
            myComments.value = resolvedObj.value.data;
            console.log(myComments.value)
            if (resolvedObj.value.status === 400) {
                isOver.value = false;
                return;
            }
            pageNum.value = 2;
        })
}

//评论
const comment = () => {
    showComment.value = !showComment.value;
    if (showComment.value) {
        getNewComment();
    }
}



const dateTime = computed(() => {
    const dateObject = new Date(shotObj.value.createTime);
    //毫秒转日期
    var year = dateObject.getFullYear(); // 年份
    var month = dateObject.getMonth() + 1; // 月份（注意需要加1，因为月份是从0开始计数的）
    var day = dateObject.getDate(); // 日
    return "" + year + "-" + month + "-" + day;
})





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

.load-more {
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 16px;
    padding: 10px;
}

/* .shot-container .icons {
    display: flex;
    flex-direction: row;
    align-items: center;
} */
</style>