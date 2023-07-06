<template>
    <div class="tag">
        <el-input v-model="tagContent" :prefix-icon="Discount" @keydown.enter="handleEnterDown"></el-input>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { Discount } from '@element-plus/icons-vue'
const tagContent = ref();
const emit = defineEmits(['addTag'])

const handleEnterDown = () => {
    if (tagContent.value !== null) {
        console.log(tagContent.value)
        emit('addTag', tagContent.value);
    }
}
</script>

<style scoped>
.tag {
    width: 80px;
    height: 16px;
}
</style>