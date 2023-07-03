<template>
    <el-main class="el-main">
        <div class="shots-container">
            <Shot v-for="shot in shotsProps.newShots" :new-shot="shot" />
            <component></component>
        </div>
    </el-main>
</template>

<script setup>
import { VueElement, onBeforeUpdate, onMounted } from 'vue';
import Shot from './Shot.vue';

const shotsProps = defineProps({
    newShots: Array
})



</script>
    
<style scoped>
.shots-container {
    margin: 0;
    width: 620px;
}

.el-main {
    max-width: 660px;
    margin-right: 20px;
}
</style>