<template>
    <div class="message-container">
        <MessageCard />
        <MessageCard />
        <MessageCard />
        <MessageCard />
    </div>
</template>
<script setup>
import MessageCard from './MessageCard.vue';
</script>
<style scoped>
.message-container {
    min-width: 500px;
    min-height: 100px;
    border: 1px solid #868686;
    display: flex;
    flex-direction: column;
    padding: 25px;
    padding-bottom: 0px;
}
</style>