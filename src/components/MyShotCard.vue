<template>
    <div class="my-shot-image-container">
        <img :src="'https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/' + props.shotObj.id + '.jpg'" class="my-shot-image"
            alt>
        <div class="overlay" @mouseover="isView = true" @mouseout="isView = false">
            <div class="content" v-if="isView" @mousemove="isView = true">
                <p class="text">标题：{{ props.shotObj.title }}</p>
                <p class="text"> {{ props.shotObj.content }}</p>
                <p class="text">收获的点赞:{{ props.shotObj.total_thumb }}</p>
            </div>
        </div>
    </div>
</template>

<script setup>

import { defineProps, ref } from 'vue';
const props = defineProps({
    shotObj: Object
})
const isView = ref(false);
</script>

<style scoped>
.my-shot-image-container {
    display: flex;
    justify-content: center;
    align-items: center;
    border-top: 2px solid #000000;
    border-bottom: 2px solid #000000;
    margin: 20px auto;
    position: relative;
}


.my-shot-image-container img {
    object-fit: contain;
    width: auto;
    max-height: 400px;
}

.overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;

}

.overlay:hover {

    background-color: rgba(0, 0, 0, .6);

}

.content {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.text {
    font-size: 34px;
    font-weight: 600;
    color: rgb(199, 200, 201)
}
</style>