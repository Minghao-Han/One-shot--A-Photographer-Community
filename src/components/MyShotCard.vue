<template>
    <div class="my-shot-image-container">
        <img :src="'https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/' + props.id + '.jpg'" class="my-shot-image" alt>
    </div>
</template>

<script setup>
import { defineProps } from 'vue';
const props = defineProps({
    id: String
})
</script>

<style scoped>
.my-shot-image-container {
    display: flex;
    justify-content: center;
    align-items: center;
    border-top: 2px solid #000000;
    border-bottom: 2px solid #000000;
    margin: 20px auto;

}


.my-shot-image-container img {
    object-fit: contain;
    width: auto;
    max-height: 400px;
}
</style>