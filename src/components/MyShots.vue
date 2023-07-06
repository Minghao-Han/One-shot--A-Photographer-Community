<template>
    <div class="my-shots-container">
        <MyShotCard />
        <MyShotCard />
        <MyShotCard />
        <MyShotCard />

    </div>
</template>

<script setup>
import MyShotCard from './MyShotCard.vue';
import { defineProps } from 'vue';
const props = defineProps({
    List: Array
})
</script>

<style scoped></style>