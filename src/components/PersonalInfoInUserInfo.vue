<template>
    <div class="personal-info-container">
        <div class="basic-info-container">
            <el-avatar :size="100">

            </el-avatar>
            <h2 style="margin: auto 10px;">小芳</h2>
            <h3>xiaofang@163.com</h3>
            <el-link :icon="Edit">编辑资料</el-linK>
        </div>

        <div class="personal-signature">
            <p>这个人很酷什么都没有留下</p>
        </div>

        <div class="addition-info">
            <div class="addition-info-block">
                <H2>获赞</H2>
                <h3>200</h3>
            </div>
            <div class="addition-info-block">
                <H2>粉丝</H2>
                <h3>200</h3>
            </div>
            <div class="addition-info-block">
                <H2>关注</H2>
                <h3>200</h3>
            </div>
        </div>

        <div class="personal-info-main">
            <UserDivContainer />
        </div>
    </div>
</template>

<script setup>
import { Edit } from '@element-plus/icons-vue'
import MyShots from './MyShots.vue'
import UserDivContainer from './UserDivContainer.vue';
</script>

<style scoped>
.personal-signature {
    padding: 10px 30px;
    text-indent: 2em;
    margin-bottom: 10px;
}

.personal-info-container {
    display: flex;
    flex-direction: column;
    margin-top: 0 !important;
    border: 1px solid #868686;
    width: 100%;
}

.personal-info-container .basic-info-container {
    width: 100%;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-evenly;
    padding: 30px;
    padding-bottom: 10px;
}

.personal-info-container .addition-info {
    display: flex;
    padding-left: 12%;
    padding-right: 12%;
    justify-content: space-between;

}

.personal-info-container .addition-info-block {
    display: flex;
    justify-content: center;
    align-items: end;
    margin-bottom: 10px;
}

.personal-info-container .addition-info-block:hover {
    cursor: pointer;
    box-shadow: inset 0px -2px #494949;
    background-color: #eeeeee;
}

.addition-info-block h2 {
    font-weight: 700;
}

.addition-info-block h3 {
    vertical-align: bottom;
    color: #494949;
}

.personal-info-main {}
</style>