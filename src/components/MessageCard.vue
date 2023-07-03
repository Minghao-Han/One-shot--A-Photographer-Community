<template>
    <div class="message-card-container">
        <div class="message-card-info">
            <div class="message-title">
                <h2>标题</h2>
            </div>
            <div class="message-content">
                <p style="text-indent: 2em;">发酒疯嘎嘎垃圾啊的两个空间打开拉萨</p>
            </div>
            <div class="message-time">
                <h6>2021-12-4</h6>
            </div>
        </div>
        <div class="view-button">
            <el-button :icon="Message" class="button">

            </el-button>
        </div>
    </div>
</template>

<script setup>
import { Message } from '@element-plus/icons-vue';
</script>
<style scoped>
.message-card-container {
    display: flex;
    align-items: center;
    justify-content: space-between;
    border-left: 5px solid black;
    margin-bottom: 25px;
}

.message-card-container:hover {
    background-color: rgb(218, 218, 218);
}

.view-button {
    padding: 10px;
}

.view-button .button {
    height: 48px;
    font-size: 18px;
}

.message-card-info {
    width: 80%;
    padding: 10px;
    display: flex;
    flex-direction: column;
}
</style>