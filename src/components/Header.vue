<template>
    <div class="header-content">

        <el-header class="header">
            <el-row :gutter="30" class="header-row" justify="center">
                <el-col class="grid-content" :span="4">
                    <img src="@/assets/images/logo.png" alt="OneShot" class="icon">
                </el-col>

                <el-col :offset="0" :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/shots.png" alt="Shots" class="icon">
                    <p class="navi-word">动态</p>
                </el-col>

                <el-col :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/forum.png" alt="Forum" class="icon">
                    <p class="navi-word">论坛</p>
                </el-col>

                <el-col :span="1" class="grid-content navi-block">
                    <img src="@/assets/images/competition.png" alt="Competition" class="icon">
                    <p class="navi-word">比赛</p>
                </el-col>

                <el-col :offset="2" :span="5" class="grid-content">
                    <el-input deep v-model="searchInfo" placeholder="你有一双发现美的眼睛" cleartable class="search-input">
                        <template #prepend>
                            <el-button :icon="Search" class="search-icon" />
                        </template>
                    </el-input>
                </el-col>

                <el-col :offset="0" :span="1" class="grid-content">
                    <img src="@/assets/images/add.png" alt="post shot" class="icon">
                </el-col>

                <el-col :offset="1" :span="1" class="grid-content">
                    <img src="@/assets/images/userAvator.png" alt="avator" class="icon avator">
                </el-col>
            </el-row>
        </el-header>
    </div>
</template>
<script setup>
import { Search } from "@element-plus/icons-vue"
</script>
<style scoped>
.header-content .header {
    display: flex;
    flex-direction: column;
    height: 75px;
}

.header .header-row {
    margin: auto 0;
    border-bottom: 1px solid #a6a6a6;
}

.header .navi-block {
    display: flex;
    flex-direction: column;
    align-items: center;
    vertical-align: center;
    padding: 0 !important;
}

.header .navi-block img {
    margin-top: 1vh;
}

.header .navi-word {
    padding: 0;
}


.grid-content {
    min-height: 48px;
    vertical-align: center;
    display: flex;
    align-items: center;
}

.header .icon {
    height: 40px;
}

.header .avator {
    border-radius: 50%;
    border: solid;
    height: 48px;
}

.grid-content .el-input {
    box-shadow: black;
    height: 60%;
    font-size: 110%;
    --el-input-focus-border-color: #000;
}
</style>