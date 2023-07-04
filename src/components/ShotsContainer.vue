<template>
    <el-main class="el-main">
        <div class="shots-container">
            <Shot v-for="shot in shotsProps.newShots" :newShot="shot" />
            <component></component>
        </div>
    </el-main>
</template>

<script setup>
import { VueElement, onBeforeUpdate, onMounted, onUpdated } from 'vue';
import Shot from './Shot.vue';

const shotsProps = defineProps({
    newShots: Array
})

onUpdated(() => {
    console.log(shotsProps.newShots)
})

</script>
    
<style scoped>
.shots-container {
    margin: 0;
    width: 800px;
}

.el-main {
    max-width: 840px;
    margin-right: 20px;
}
</style>