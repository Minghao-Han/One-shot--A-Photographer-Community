//已弃置

<template>
    <div class="container">
        <div class="shot-info">
            <div class="shot-image">
                <img src="@/assets/images/1.jpg" style="object-fit: contain;" class="image" />

            </div>

            <span class="shot-aside">
                <div class="poster-info">
                    <div class="avatar-name">
                        <el-avatar>

                        </el-avatar>
                        <h2>
                            用户名
                        </h2>
                    </div>

                    <div class="follow-button">
                        <el-button>
                            关注
                        </el-button>
                    </div>
                </div>

                <div class="thumb-and-collect">
                    <el-icon>
                        <Orange></Orange>
                    </el-icon>
                    <p>1</p>
                    <el-icon>
                        <CollectionTag>
                        </CollectionTag>
                    </el-icon>
                    <p>2</p>
                    <p class="time">&nbsp;&nbsp;2021-12-4</p>
                </div>

                <div class="comment-container">
                    <div class="post-comment">
                        <!-- 评论的输入框 -->
                        <el-input v-model="comment" type="textarea" :rows="2" class="comment-input" resize="none">
                        </el-input>
                        <!-- 评论按钮 -->
                        <el-button :icon="ChatLineSquare" style="height: 52px; font-size: 20px;">

                        </el-button>
                    </div>
                    <el-scrollbar max-height="400px">
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
</style>