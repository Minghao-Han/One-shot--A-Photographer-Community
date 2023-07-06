<template>
    <div class="comment-container">
        <div class="info">
            <slot name="avatar"></slot>

            <h5 style="margin-left:10px ; font-size: 18px;">
                <slot name="name">
                </slot>
            </h5>
        </div>

        <div>

            <p class="content">
                <slot name="content"></slot>
            </p>

        </div>

        <div class="end-container">
            <div>
                <p style="color: #969696;">
                    <slot name="date"></slot>
                </p>
            </div>
            <div class="thumb">
                <el-icon>
                    <ChatDotSquare></ChatDotSquare>
                </el-icon>
            </div>
        </div>
    </div>
</template>

<script setup>

import { defineProps, withDefaults } from 'vue';





import { ChatDotSquare } from '@element-plus/icons-vue'

const props = defineProps({
    time: String,
})
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
    font-size: 18px;
    margin-right: 20px;
}
</style>