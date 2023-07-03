<template>
    <Header />
    <div class="container">
        <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="1"
            text-color="#fff" @open="handleOpen" @close="handleClose">
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
            <el-menu-item index="4" class="el-menu-vertical-item">
                <el-icon>
                    <Trophy />
                </el-icon>
                <span>
                    我参加的比赛
                </span>
            </el-menu-item>
        </el-menu>
        <div class="aside-container">
            <HistoryMessage></HistoryMessage>
        </div>
    </div>
</template>

<script setup>
import Header from '../components/Header.vue';
import { User, Star, View, Picture, Clock, Trophy } from '@element-plus/icons-vue'
import PersonalInfoInUserInfo from '../components/PersonalInfoInUserInfo.vue';
import HistoryMessage from '../components/HistoryMessage.vue';
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
}

/* 用来设置高度 */
.container .el-menu-vertical-item {
    height: 75px;
    font-size: 20px;
}
</style>