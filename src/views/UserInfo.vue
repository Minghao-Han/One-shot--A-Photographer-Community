<template>
    <Header />
    <div class="container">
        <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="1"
            text-color="#fff" @open="handleOpen" @close="handleClose" @select="handleSelect">
            <el-menu-item index="1" class="el-menu-vertical-item">
                <el-icon :size="50">
                    <User />
                </el-icon>
                <span>个人信息</span>
            </el-menu-item>
            <el-menu-item index="2" class="el-menu-vertical-item">
                <el-icon>
                    <Star />
                </el-icon>
                <span>我的收藏</span>
            </el-menu-item>

            <!-- <el-menu-item index="3" class="el-menu-vertical-item">
                <el-icon>
                    <View />
                </el-icon>
                <span>我的关注</span>
            </el-menu-item>
            <el-menu-item index="4">
                <el-icon>
                    <Picture />
                </el-icon>
                <span>
                    我发布的Shot
                </span>
            </el-menu-item>  -->

            <el-menu-item index="3" class="el-menu-vertical-item">
                <el-icon>
                    <Clock />
                </el-icon>
                <span>
                    历史消息
                </span>
            </el-menu-item>
        </el-menu>
        <div class="aside-container">
            <component :is="subComponent" />
        </div>
    </div>
</template>

<script setup>
import Header from '../components/Header.vue';
import { ref } from 'vue';
import { User, Star, View, Picture, Clock, Trophy } from '@element-plus/icons-vue'
import MyCollection from '../components/MyCollection.vue';
import PersonalInfoInUserInfo from '../components/PersonalInfoInUserInfo.vue';
import HistoryMessage from '../components/HistoryMessage.vue';

const subComponent = ref(PersonalInfoInUserInfo);

const handleSelect = index => {
    console.log("has selected>" + index);
    console.log(typeof (index));
    switch (index) {
        case '1':
            subComponent.value = PersonalInfoInUserInfo;
            break;
        case '2':
            subComponent.value = MyCollection;
            break;
        case '3':
            subComponent.value = HistoryMessage;
            break;
        default:
            break;
    }
}
</script>

<style scoped>
.container {
    margin-top: 100px;
    display: flex;
    flex-direction: row;
}

.container .el-menu-vertical-demo {
    width: auto;
    height: 100%;
    margin-left: 24vw;
}

.aside-container {
    display: flex;
    flex-direction: column;
    align-items: start;
    margin-left: 50px;
    width: 620px;
    margin-bottom: 10vh;
}

/* 用来设置高度 */
.container .el-menu-vertical-item {
    height: 75px;
    font-size: 20px;
}
</style>