<template>
    <ElHeader>
        <div>
            <!-- 页面头部导航栏 -->
            <div class="header">
                <!-- 导航栏内容部分 -->
                <div class="header-content">
                    <!-- logo -->
                    <RouterLink to="/" class="logo">
                        <span>
                            <img src="@/assets/images/logo.png" height="60" width="216" alt="OneShot">
                        </span>
                    </RouterLink>
                    <!-- 跳转到shots、论坛和比赛页面 -->
                    <ul class="navigator">
                        <RouterLink to="">
                            <li class="navi-block">
                                <img src="@/assets/images/shots.png" alt="Shots">
                                <p class="navi-word">动态</p>
                            </li>
                        </RouterLink>
                        <RouterLink to="">
                            <li class="navi-block">
                                <img src="@/assets/images/forum.png" alt="Forum">
                                <p class="navi-word">论坛</p>
                            </li>
                        </RouterLink>
                        <RouterLink to="">
                            <li class="navi-block">
                                <img src="@/assets/images/competition.png" alt="Competition">
                                <p class="navi-word">比赛</p>
                            </li>
                        </RouterLink>
                    </ul>
                    <!-- 搜索输入框 -->
                    <div class="search-entry">
                        <el-input deep v-model="searchInfo" placeholder="你有一双发现美的眼睛" cleartable class="search-input">
                            <template #prepend>
                                <el-button :icon="Search" class="search-icon" />
                            </template>
                        </el-input>
                    </div>
                    <!-- 发布shot -->
                    <RouterLink to="/">
                        <div class="post-shot">

                            <img src="@/assets/images/add.png" alt="post shot" :style="{
                                width: '40px', height: '40px', verticalAlign: 'middle'
                            }">

                        </div>
                    </RouterLink>

                    <RouterLink to="/">
                        <div class="user-info">
                            <img src="@/assets/images/userAvator.png" alt="avator" :style="{
                                width: '48px', height: '48px', verticalAlign: 'middle'
                                , borderRadius: '50%', border: 'solid', margin: 'auto 5px'
                            }">

                        </div>
                    </RouterLink>
                </div>

            </div>
        </div>
    </ElHeader>
</template>

<script setup>
import { ref, reactive, getCurrentInstance, onMounted } from "vue";
import { useRouter, useRoute } from "vue-router";
const { proxy } = getCurrentInstance();
const router = useRouter();
const route = useRoute();
const searchInfo = ref();
import { Search } from "@element-plus/icons-vue"
import { ElHeader } from "element-plus";

const avator = ref();


</script>

<style scoped>
a {
    text-decoration: none;
    color: inherit;
}

.header {

    width: 100%;
    position: fixed;
    background-color: #ffffff;
    box-shadow: 0px 3px 3px 0px rgba(0, 0, 0, .2);

    .header-content {
        margin: 0px auto;
        align-items: center;
        height: 60px;
        width: 1200px;
        display: flex;
        justify-content: center;

        .logo {
            width: 216px;
            height: 60px;
            display: flex;
            margin-right: 10px;
        }

        .navigator {
            display: flex;
            margin: auto 20px;
            height: 100%;
        }

        .navi-block {
            display: flex;
            flex-direction: column;
            height: 48px;
            width: 35px;
            margin: 6px 24px;

            .navi-word {
                height: 16px;
                text-align: center;
                line-height: 16px;
                font-size: 16px;
                font-family: inherit;
                font-weight: 600;
            }
        }

        .search-entry {
            margin: auto 80px;
            margin-right: 10px;

            .search-input {
                height: 40px;
                font-size: 16px;
                width: 260px;


            }

            /* 用来更改ElementPlus的输入框的属性 */
            .el-input {
                --el-input-focus-border-color: #000;
            }
        }

        .post-shot {
            margin: auto 80px;
        }
    }
}
</style>

