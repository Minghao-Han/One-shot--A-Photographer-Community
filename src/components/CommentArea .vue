<template>
    <div class="container">

        <div class="inset-shadow">
            <div class="post-comment">
                <!-- 评论的输入框 -->
                <el-input v-model="comment" type="textarea" :rows="2" class="comment-input" resize="none">
                </el-input>
                <!-- 评论按钮 -->
                <el-button :icon="ChatSquare" style="height: 52px; font-size: 20px;">
                </el-button>
            </div>
            <el-scrollbar max-height="400px">
                <Comment></Comment>
                <Comment />
                <Comment />
                <Comment />
                <Comment />
                <Comment />
                <Comment />
                <Comment />
            </el-scrollbar>
        </div>

    </div>
</template>

<script setup>
import { ChatSquare } from '@element-plus/icons-vue'
import { ref } from "vue"
import Comment from './Comment.vue'

const comment = ref();
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
</style>