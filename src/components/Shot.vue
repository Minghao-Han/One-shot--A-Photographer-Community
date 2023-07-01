<template>
    <div class="shot-container">
        <el-row class="shot-poster" justify="space-between" :gutter='20'>
            <el-col class="poster-info" :span="12">
                <!-- <img class="poster-avator" alt src="http://localhost:8080/images/shots/vx.jpg"> -->
                <el-avatar :src="img1" fit="fill" />
                <h3 class="poster-name">{{ shotObj.user_name }}</h3>
            </el-col>

            <el-col class="follow-button" span="2">
                <el-button type="primary" :icon="Plus" color="#7c7c7c" plain>
                    关注
                </el-button>
            </el-col>

        </el-row>
        <div class="shot-img-container">
            <el-image :src="img3" class="shot-image" fit="contain" />
        </div>
        <div class="shot-title">
            <h2 class="title">
                {{ shotObj.title }}
            </h2>
        </div>
        <div class="shot-content">
            <p class="content">
                {{ shotObj.content }}
            </p>
        </div>

        <el-row :gutter="20" justify="space-between">
            <el-col :span="12" class="shot-function-icons">
                <el-icon class="thumb icon" @click="thumb">
                    <Orange :color="orangeColor" />
                </el-icon>
                <span>{{ shotObj.total_thumb }}</span>
                <el-icon class="collect icon" @click="collect">
                    <CollectionTag :color="redColor" />
                </el-icon>
                <span>{{ shotObj.total_collect }}</span>
                <!-- <el-icon class="view icon">
                    <View />
                </el-icon> -->
            </el-col>


            <el-col :span="4" class="shot-comment">
                <el-icon class="icon">
                    <ChatLineSquare />
                </el-icon>
            </el-col>
        </el-row>
    </div>
</template>
<script setup>
import { computed, onBeforeUpdate, onMounted, onUpdated, reactive, ref } from 'vue';
import { Plus, Orange, View, CollectionTag, ChatLineSquare } from '@element-plus/icons-vue'
import img1 from '@/assets/images/1.jpg';
import img2 from '@/assets/images/2.jpg';
import img3 from '@/assets/images/vx.jpg';
const shotObj = ref({
})

const props = defineProps({
    newShot: Object
})

onMounted(() => {
    console.log("shot");
    console.log(props.newShot);
    shotObj.value = props.newShot;
    console.log(shotObj.value);
})

const posterName = ref("小芳");
const shotTitle = ref("你好，世界");
const shotContent = ref("Hello, OneShot!");
//判断是否点赞或收藏
const isThumbed = ref(false);
const isCollected = ref(false);
//计算属性用来改变颜色
const orangeColor = computed(() => {
    return isThumbed.value === true ? "orange" : "";
})
const redColor = computed(() => {
    return isCollected.value === true ? "red" : "";
})
// 點贊
const thumb = () => {
    isThumbed.value = !isThumbed.value;
    if (isThumbed.value)
        shotObj.value.total_thumb++;
    else shotObj.value.total_thumb--;
}
//收藏
const collect = () => {
    isCollected.value = !isCollected.value;
    if (isCollected.value)
        shotObj.value.total_collect++;
    else shotObj.value.total_collect--;
}

//评论
const comment = () => {

}


</script>

<style scoped>
.shot-container {
    margin: 20px auto;
    background-color: white;
    box-shadow: 0 0 5px 1px #a2a2a2;
    /* border-radius: 5px; */
}

.shot-container .shot-poster {
    padding: 12px 12px;
}

.shot-container .poster-info {
    display: flex;
    align-items: center;
    margin-left: 10px;
}

.shot-container .shot-img-container {
    display: flex;
    justify-content: center;

}

.shot-container .shot-image {
    margin: 10px auto;
    max-height: 640px;

}

.shot-container .el-image__inner {
    max-height: 600px;
}

.el-image__inner {
    max-height: 600px;
}


.shot-container .poster-name {
    margin-left: 10px;
}

.shot-container .shot-function-icons {
    margin-left: 10px;
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.shot-container .icon {
    font-size: 24px;
    margin-right: 6px;
    transition: transform 0.3s;
}

.shot-container .icon:hover {
    cursor: pointer;
    transform: translateY(-10px);
}


.shot-container .shot-comment {
    display: flex;
    justify-content: flex-end;
    margin-right: 10px;
}

.shot-container .title {
    margin-left: 10px;
}

.shot-container .content {
    margin-left: 15px;
    text-indent: 2em;
    margin-bottom: 8px;
}

.shot-container .follow-button {
    margin-right: 6px;
}
</style>