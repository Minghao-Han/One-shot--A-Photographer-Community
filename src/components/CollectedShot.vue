<template>
    <div class="collected-shot-container">
        <div class="collected-shot-image">
            <img :src="'https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/' + props.collectShot.id + '.jpg'"
                style="width: 160px;height: 120px; object-fit: contain;" alt>
        </div>
        <div class="collected-shotinfo">
            <div class="title">
                <h1>{{ props.collectShot.title }}</h1>
            </div>
            <div class="conten">
                <h3>{{ props.collectShot.content }}</h3>
            </div>
        </div>
    </div>
</template>
<script setup>
import { ref } from 'vue';
const imgSrc = ref();
const props = defineProps({
    collectShot: Object
})
</script>
<style scoped>
.collected-shot-container {
    display: flex;
    align-items: center;
    height: 144px;
}

.collected-shot-container:hover {
    background-color: rgb(181, 180, 179);
    cursor: pointer;
}

.collected-shot-shotinfo {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
}
</style>