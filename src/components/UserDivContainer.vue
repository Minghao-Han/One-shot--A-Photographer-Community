<template>
    <div class="user-div-container">
        <UserDiv v-for="item in props.List" :fans="item" />
    </div>
</template>
<script setup>
import UserDiv from './UserDiv.vue';
import { defineProps, onBeforeUpdate } from 'vue';
const props = defineProps({
    List: Array
})

onBeforeUpdate(() => {
    console.log("list>>")
    console.log(props.List)
})
</script>

<style scoped></style>