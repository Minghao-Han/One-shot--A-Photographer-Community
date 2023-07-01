<template>
    <el-affix>
        <el-aside width="240px">

            <div class="aside-user-info-container">
                <div class="aside-user-avatar">
                    <el-avatar :size="60"></el-avatar>
                    <H3>{{ userName }}</H3>
                </div>
                <div class="info-list">
                    <span>性别：</span>
                    <span>{{ genderInCn }}</span>
                </div>

                <div class="info-list">
                    <span>年龄：</span>
                    <span>{{ age }}</span>
                </div>

                <div class="info-list">
                    <span>个性签名：</span>
                    <span>{{ personSignature }}</span>
                </div>
            </div>

        </el-aside>
    </el-affix>
</template>

<script setup>
import { computed, ref } from 'vue';
const userName = ref("小芳");
const gender = ref("Male");
const age = ref(22);
const personSignature = ref("像风一样");

const genderInCn = computed(() => {
    if (gender.value === "Male")
        return "男";
    if (gender.value === "Female")
        return "女";
    return "沃尔玛";
})


</script>

<style scoped>
.aside-user-info-container {
    padding: 25px 15px;
    margin: auto;
    margin-top: 60px;
    border: 3px solid #686868;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
}

.aside-user-info-container .aside-user-avatar {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-evenly;
}
</style>