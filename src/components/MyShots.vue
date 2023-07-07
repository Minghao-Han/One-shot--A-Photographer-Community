<template>
    <div class="my-shots-container">
        <MyShotCard v-for="shot in myShotList" :id="shot.id" />
        <div class="footer" @mouseover="getMyShot(pageNum)" v-if="visiable">
            <p>获取更多我的Shot
            </p>
        </div>
    </div>
</template>

<script setup>
import MyShotCard from './MyShotCard.vue';
import { defineProps, onMounted, ref } from 'vue';
import { resolvedObj } from '../utils/request';
import request from '../utils/request'
const visiable = ref(false);

onMounted(() => {
    getMyShot(1);
})
const myShotList = ref(new Array());
const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}
const pageNum = ref(1);
const getMyShot = (page) => {
    const url = 'http://localhost:8080/personPage/shot/' + page;
    request.get(url, config)
        .then(() => {
            visiable.value = false;
            if (page === 1) {
                myShotList.value = new Array()
            }
            console.log("oldList>>")
            console.log(myShotList.value)
            console.log("newlist>>")
            console.log(resolvedObj.value.data);
            if (resolvedObj.value.data === null) {
                visiable.value = false;
                return;
            }
            myShotList.value = myShotList.value.concat(resolvedObj.value.data)
            console.log("myshotlist>>")
            console.log(myShotList.value)
            pageNum.value = page + 1;
            console.log("paga>>")
            console.log(pageNum.value)
            // visiable.value = true;
        })
}
</script>

<style scoped>
.footer {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 6px auto;
}
</style>