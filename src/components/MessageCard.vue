<template>
    <div class="message-card-container">
        <div class="message-card-info">
            <div class="message-title">
                <h2>{{ messageTypeInCn }}</h2>
            </div>
            <div class="message-content">
                <p style="text-indent: 2em;">{{ messageObj.messageText }}</p>
            </div>
            <div class="message-time">
                <h6>{{ dateTime }}</h6>
            </div>
        </div>

    </div>
</template>

<script setup>
import { Message } from '@element-plus/icons-vue';
import { defineProps, ref, watch, computed } from 'vue';
const props = defineProps({
    message: Object
})

const messageTypeInCn = computed(() => {
    if (messageObj.value.messageType === 'comment_of_shot')
        return '评论'
    else if (messageObj.value.messageType === 'thumb_of_shot')
        return '点赞'
})

const messageObj = ref({});

watch(() => props.message, (newValue, oldValue) => {
    console.log("new>>")
    console.log(newValue);
    messageObj.value = newValue;
}, { deep: true, immediate: true })

const dateTime = computed(() => {
    const dateObject = new Date(messageObj.value.time);
    //毫秒转日期
    var year = dateObject.getFullYear(); // 年份
    var month = dateObject.getMonth() + 1; // 月份（注意需要加1，因为月份是从0开始计数的）
    var day = dateObject.getDate(); // 日
    return "" + year + "-" + month + "-" + day;
})

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