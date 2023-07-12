<template>
    <div class="user-div" @click="openOtherInfo">
        <div class="avatar">
            <img :src="avatarSrc" alt>
        </div>
        <div class="other-info">
            <div class="name-gender">
                <h3 style="text-indent: 1em;">{{ props.fans.userName }}</h3>
                <div style="font-size: 20px; display: flex; align-items: center;">
                    <el-icon>
                        <Female v-if="!gender" />
                        <Male v-if="gender" />
                    </el-icon>
                </div>
            </div>
            <div>
                <p style="text-indent: 2em; font-size: 15px;">{{ props.fans.personalSignature }}</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { Female, Male } from '@element-plus/icons-vue'
import { computed, defineProps, onMounted, ref } from 'vue';

const emit = defineEmits(['getOtherId'])

//打开他人的信息界面
const openOtherInfo = () => {
    console.log("传递事件")
    const id = props.fans.id;
    emit('getOtherId', id);
}

const props = defineProps({
    fans: Object
})

const avatarSrc = ref('');
onMounted(() => {
    avatarSrc.value = 'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + props.fans.id + '.jpg';
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

.user-div:hover {
    cursor: pointer;
    background-color: #c6c6c6;
}

.avatar {
    width: 48px;
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
    font-size: 20px;
}
</style>