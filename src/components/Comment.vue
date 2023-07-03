<template>
    <div class="comment-container">
        <div class="info">
            <el-avatar>
            </el-avatar>
            <h5 style="margin-left:10px ; font-size: 18px;">名字</h5>
        </div>

        <div>
            <p class="content">
                这是你见过最聪明的评论
            </p>
        </div>

        <div class="end-container">
            <div>
                <p style="color: #969696;">2021-3-21</p>
            </div>
            <div class="thumb">
                <el-icon>
                    <CaretTop></CaretTop>
                </el-icon>
            </div>
        </div>
    </div>
</template>

<script setup>
import { CaretTop } from '@element-plus/icons-vue'
</script>

<style scoped>
.comment-container {
    padding: 20px;
    padding-top: 0;
}

.comment-container .info {
    display: flex;
    align-items: center;
    margin-bottom: 6px;
}

.comment-container .content {
    text-indent: 2em;
}

.comment-container .end-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.comment-container .thumb {
    font-size: 28px;
}
</style>