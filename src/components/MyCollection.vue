<template>
    <div class="my-collection-container">
        <el-scrollbar max-height="600px">
            <CollectedShot v-for="item in collecttionList" :collect-shot="item">
            </CollectedShot>
        </el-scrollbar>
    </div>
</template>

<script setup>
import { ref, onBeforeMount } from 'vue';
import { resolvedObj } from '../utils/request';
import request from '../utils/request';
import CollectedShot from './CollectedShot.vue';
const pageNum = ref(1);
const collecttionList = ref();
onBeforeMount(() => {
    getNewCollection(1);
    console.log("newCollection")
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

const getNewCollection = page => {
    if (page === 1) collecttionList.value = new Array();
    const url = 'http://localhost:8080/collect/check/shot/' + page;
    request.get(url, config)
        .then(() => {
            console.log(resolvedObj.value);
            collecttionList.value = collecttionList.value.concat(resolvedObj.value.data);
            pageNum.value++;
            console.log("pageNum:" + pageNum.value + ",")
            console.log(collecttionList.value)
        })
}
</script>

<style scoped>
.my-collection-container {
    min-width: 500px;
    min-height: 100px;
    border: 1px solid #868686;
    display: flex;
    flex-direction: column;
    padding: 25px;
    padding-bottom: 25px;
}
</style>
