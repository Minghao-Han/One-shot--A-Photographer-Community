<template>
    <div class="message-container">
        <el-scrollbar max-height="600px">
            <MessageCard v-for="message in messageList" :message="message"></MessageCard>
        </el-scrollbar>
    </div>
</template>
<script setup>
import MessageCard from './MessageCard.vue';
import { resolvedObj } from '../utils/request';
import request from '../utils/request';
import { onBeforeMount, ref } from 'vue';

const messageList = ref();
messageList.value = new Array();
const pageNum = ref(1);

onBeforeMount(() => {
    getHistoryMessage(1);
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}


const getHistoryMessage = () => {
    messageList.value = new Array();
    const url = 'message/history/5';
    request.get(url, config)
        .then(() => {
            console.log(resolvedObj.value);
            messageList.value = messageList.value.concat(resolvedObj.value.data);
            console.log("messageList>>" + messageList.value);
        })
}

</script>
<style scoped>
.message-container {
    min-width: 600px;
    min-height: 100px;
    border: 1px solid #868686;
    display: flex;
    flex-direction: column;
    padding: 25px;
    padding-bottom: 0px;
    margin-bottom: 10vh;
}
</style>