<template>
    <div class="game-container">
        <div style="padding-left:10vw;">
            <div class="back-info">
                <el-icon>
                    <Back />
                </el-icon>
                <span>
                    &nbsp;返回
                </span>
            </div>

        </div>
        <div class="image">
            <el-image>

            </el-image>
        </div>

        <div class="game-info">
            <h1>标题</h1>
            <p class="">我忘记所有悲剧，所见皆为奇迹</p>
        </div>

        <div class="game-items-list">

        </div>
    </div>
</template>

<script setup>
import { Back } from '@element-plus/icons-vue'
</script>

<style scoped>
.game-container .back-info {
    display: flex;
    align-items: center;
    font-size: 35px;
}
</style>