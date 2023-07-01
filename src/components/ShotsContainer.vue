<template>
    <el-main class="el-main">
        <div class="shots-container">
            <Shot v-for="shot in shotsProps.newShots" :new-shot="shot" />
        </div>
    </el-main>
</template>

<script setup>
import { onBeforeUpdate, onMounted } from 'vue';
import Shot from './Shot.vue';

const shotsProps = defineProps({
    newShots: Array
})


</script>
    
<style scoped>
.shots-container {
    margin: 0;
    width: 580px;
}

.el-main {
    max-width: 620px;
    margin-right: 20px;
}
</style>