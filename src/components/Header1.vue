<template>
    <div class="header-content">

        <el-header class="header" style="background-color: white;" height="74px">
            <el-row :gutter="30" class="header-row" justify="center">
                <el-col class="grid-content" :span="3">
                    <el-button class="grid-content navi-block" style="border:none;" @click="gotoGame">
                        <img src="@/assets/images/logo.png" alt="OneShot" class="icon"></el-button>
                </el-col>

                <el-col :offset="0" :span="1" class="grid-content navi-block" style="margin-left: 10px;">
                    <el-button class="grid-content navi-block" style="border:none;" @click="gotoShots">
                        <img src="@/assets/images/equipment.png" alt="Shots" class="icon"></el-button>
                    <p class="navi-word">动态</p>
                </el-col>
                <!-- 
                <el-col :span="1" class="grid-content navi-block" style="margin-left: 10px;">
                    <img src="@/assets/images/forum.png" alt="Forum" class="icon">
                    <p class="navi-word">论坛</p>
                </el-col> -->

                <el-col :span="1" class="grid-content navi-block" style="margin-left: 10px;">
                    <el-button class="grid-content navi-block" style="border:none;" @click="gotoGame">
                        <img src="@/assets/images/competition.png" alt="Competition" class="icon"></el-button>
                    <p class="navi-word">比赛</p>
                </el-col>

                <el-col :span="1" class="grid-content navi-block" style="margin-left: 10px;">
                    <el-button class="grid-content navi-block" style="border:none;" @click="goToEquipment">
                        <img src="@/assets/images/shots.png" alt="qicai" class="icon"> </el-button>
                    <p class="navi-word">器材</p>
                </el-col>


                <el-col :offset="9" :span="1" class="grid-content">
                    <el-button style="border: none;" @click="tologin">
                        <p style="font-weight: bold;font-size: 18px;">登录</p>
                    </el-button>
                </el-col>


                <!-- <el-col :offset="0" :span="1" class="grid-content">
                    <img src="@/assets/images/add.png" alt="post shot" class="icon">
                </el-col> -->

                <el-col :offset="0.9" :span="1" class="grid-content" style="margin-left:20px">
                    <el-button style="border-radius: 20px; padding: 0 35px;border:2px solid black;" @click="toregister">
                        <p style="font-weight: bold;font-size: 18px;">注册</p>
                    </el-button>
                </el-col>
            </el-row>
        </el-header>
    </div>
</template>

<script>
import { Search } from "@element-plus/icons-vue"
import { ElButton, ElCol, ElHeader, ElInput, ElRow } from 'element-plus'
export default {
    components: {
        ElButton,
        ElCol,
        ElHeader,
        ElInput,
        ElRow,
        Search
    },
    data() {
        return {
            searchInfo: ''
        }
    },
    methods: {
        goToEquipment() {
            this.$router.push('/equipment')
        },
        gotoGame() {
            this.$router.push('/game')
        },
        tologin() {
            this.$router.push('/login')
        },
        toregister() {
            this.$router.push('/register')
        },
        gotoShots() {
            this.$router.push('/shots')
        }
    }
}
</script>


<style scoped>
.header-content .header {
    display: flex;
    flex-direction: column;

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