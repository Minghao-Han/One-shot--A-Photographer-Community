<template>
    <div class="user-div">
        <div class="avatar">
            <img src="@/assets/images/1.jpg" alt>
        </div>
        <div class="other-info">
            <div class="name-gender">
                <h3 style="text-indent: 1em;">小芳</h3>
                <div style="font-size: 12px; display: flex; align-items: center;">
                    <el-icon>
                        <Female />
                    </el-icon>
                </div>
            </div>
            <div>
                <p style="text-indent: 2em; font-size: 10px;">这是一个很酷很酷的男孩</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { Female, Male } from '@element-plus/icons-vue'
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