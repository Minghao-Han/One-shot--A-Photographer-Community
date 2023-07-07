<template>
    <el-affix>
        <el-aside width="240px" style="margin-top: 40px; position:fixed;">

            <div class="aside-user-info-container">
                <div class="aside-user-avatar">
                    <el-avatar :src="'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + user.id + '.jpg'"
                        :size="60"></el-avatar>
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
import { computed, onBeforeUpdate, onMounted, ref } from 'vue';
const userName = ref("");
const gender = ref("");
const age = ref();
const personSignature = ref("");

const props = defineProps({
    user: Object
})

onBeforeUpdate(() => {
    userName.value = props.user.userName;
    gender.value = props.user.gender;
    age.value = props.user.age;
    personSignature.value = props.user.personalSignature;
})

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