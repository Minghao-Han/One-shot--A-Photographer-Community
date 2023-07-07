//已弃置

<template>
    <div class="container">
        <div class="shot-info">
            <div class="shot-image">
                <img src="https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/17.jpg" style="object-fit: contain;"
                    class="image" />

            </div>

            <span class="shot-aside" style="margin-top: 30px;">
                <div class="poster-info">
                    <div class="avatar-name">
                        <el-avatar style="width:50px;height: 50px;">

                        </el-avatar>
                        <h2 style="margin-left: 10px;">
                            用户名
                        </h2>
                    </div>

                    <div class="follow-button">
                        <el-button style="margin-top:10px">
                            关注
                        </el-button>
                    </div>
                </div>

                <div class="thumb-and-collect" style="margin-top:14px">
                    <el-icon>
                        <Orange></Orange>
                    </el-icon>
                    <p>1</p>
                    <el-icon style="margin-left:10px ;">
                        <CollectionTag>
                        </CollectionTag>
                    </el-icon>
                    <p>2</p>
                    <p class="time">&nbsp;&nbsp;2021-12-4</p>
                </div>

                <div class="comment-container">
                    <div class="post-comment" style="margin-top:10px">
                        <!-- 评论的输入框 -->
                        <el-input v-model="comment" type="textarea" :rows="2" class="comment-input" resize="none">
                        </el-input>
                        <!-- 评论按钮 -->
                        <el-button :icon="ChatLineSquare" style="height: 52px; font-size: 20px;margin-left: 10px;">

                        </el-button>
                    </div>
                    <el-scrollbar max-height="400px" style="margin-top: 15px;margin-left: 20px;">
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                        <Comment></Comment>
                    </el-scrollbar>
                </div>
            </span>

        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { Orange, CollectionTag, ChatLineSquare } from '@element-plus/icons-vue'
import img1 from '@/assets/images/pic.jpg'
import img2 from '@/assets/images/2.jpg'
import Comment from '../components/Comment.vue';

const comment = ref();
</script>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container .shot-info {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: start;
}

.container .shot-image {
    padding: 30px 0;
    height: 640px;
    width: 600px;
}

.container .image {
    max-height: 100%;
}

.container .shot-aside {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
}

.container .poster-info {
    display: flex;
    justify-content: space-between;
}

.container .avatar-name {
    display: flex;
}

.container .thumb-and-collect {
    display: flex;
}

.container .comment-container {
    display: flex;
    flex-direction: column;
}

.container .post-comment {
    display: flex;
}

.el-image {
    max-height: 640px;

}

.shot-image {
    flex: 0 0 auto;
    /* 图片宽度自适应，不伸缩 */
    margin-right: 10px;
    /* 图片与文字之间的间距 */
}

.image {
    width: 95%;
    /* 图片宽度填满容器 */
    height: 85%;
    /* 图片高度自适应 */
}

.shot-aside {
    flex: 1;
    /* 文字部分占满剩余空间 */
}</style>