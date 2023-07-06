<template>
    <div class="user-div">
        <div class="avatar">
            <img src="@/assets/images/1.jpg" alt>
        </div>
        <div class="other-info">
            <div class="name-gender">
                <h3 style="text-indent: 1em;">{{ props.fans.userName }}</h3>
                <div style="font-size: 12px; display: flex; align-items: center;">
                    <el-icon>
                        <Female v-if="!gender" />
                        <Male v-if="gender" />
                    </el-icon>
                </div>
            </div>
            <div>
                <p style="text-indent: 2em; font-size: 10px;">{{ props.fans.personalSignature }}</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { Female, Male } from '@element-plus/icons-vue'
import { computed, defineProps, ref } from 'vue';
const props = defineProps({
    fans: Object
})

// const fansObj = ref({});
// fansObj.value = props.fans;
const gender = computed(() => {
    if (props.fans.gender === "Male")
        return true;
    else return false;
})
</script>

<style scoped>
.user-div {
    border-top: 1px solid #c6c6c6;
    padding: 10px;
    display: flex;
    align-items: center;
}

.avatar {
    width: 32px;
    display: flex;
    align-items: center;
}

.avatar img {
    width: 100%;
    border-radius: 50%;
}

.other-info {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.other-info .name-gender {
    display: flex;
    font-size: 12px;
}
</style>