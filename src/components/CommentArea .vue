<template>
    <div class="container">

        <div class="inset-shadow">
            <div class="post-comment">
                <!-- 评论的输入框 -->
                <el-input v-model="comment" type="textarea" :rows="2" class="comment-input" resize="none">
                </el-input>
                <!-- 评论按钮 -->
                <el-button :icon="ChatSquare" style="height: 52px; font-size: 20px;" @click="postComment">
                </el-button>
            </div>
            <el-scrollbar max-height="600px">
                <Comment v-for="item in props.comments">
                    <template #avatar><img src="@/assets/images/1.jpg" class="avatar"></template>
                    <template #content>{{ item.content }}</template>
                    <template #date>{{ item.time }}</template>
                    <template #name>{{ item.userName }}</template>
                </Comment>
                <slot name="load"></slot>
            </el-scrollbar>
        </div>

    </div>
</template>

<script setup>
import { ChatSquare } from '@element-plus/icons-vue'
import { getCurrentInstance, ref } from "vue"
const { proxy } = getCurrentInstance()
import Comment from './Comment.vue'
import request from '../utils/request'
import { resolvedObj } from '../utils/request'
//评论的页数
const pageNum = ref(1);
const emit = defineEmits(['postComment'])
const comment = ref();

const props = defineProps({
    comments: Array,
    shotId: Number,
    posterId: Number
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

const postComment = () => {
    const commentConetent = comment.value;
    const url = 'http://localhost:8080/comment/shot';
    const param = {
        content: commentConetent,
        shot_id: props.shotId,
        parent_id: 0,
        receiver_id: props.posterId,
        userName: localStorage.getItem('username')
    }
    const data = JSON.stringify(param);
    request.post(url, data, config)
        .then(() => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            else {
                console.log(param);
                emit("postComment", param);
                comment.value = "";
            }
        })
}

// const dateTime = computed(() => {
//     const dateObject = new Date(shotObj.value.createTime);
//     //毫秒转日期
//     var year = dateObject.getFullYear(); // 年份
//     var month = dateObject.getMonth() + 1; // 月份（注意需要加1，因为月份是从0开始计数的）
//     var day = dateObject.getDate(); // 日
//     return "" + year + "-" + month + "-" + day;
// })
</script>

<style scoped>
.container {
    padding: 20px;
    padding-bottom: 0px;
    padding-top: 0px;
}

.container .inset-shadow {
    padding: 20px;
    padding-bottom: 0;
    border-top: 1px solid #7e7e7e;
}

.container .post-comment {
    display: flex;
    justify-content: center;
    margin-bottom: 20px;
}

.avatar {
    width: 32px;
    border-radius: 50%;
}
</style>