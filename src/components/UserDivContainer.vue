<template>
    <div class="user-div-container">
        <UserDiv v-for="item in props.List" :fans="item" @get-other-id="showOtherInfo" />
    </div>
    <el-dialog v-model="centerDialogVisible" width="30%" align-center>
        <span>
            <div class="other-info-container">
                <div class="avatar">
                    <el-avatar :src="avatar"></el-avatar>
                </div>
                <div class="name">
                    <H2>{{ otherInfo.userName }}</H2>
                </div>
                <div class="gender-age">
                    <div>{{ genderInCn + "&nbsp&nbsp" + otherInfo.age + "岁" }}</div>
                </div>

                <div class="signature">
                    <P>{{ otherInfo.personalSignature }}</P>
                </div>
            </div>
        </span>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="centerDialogVisible = false">Cancel</el-button>
                <el-button type="primary" @click="centerDialogVisible = false">
                    Confirm
                </el-button>
            </span>
        </template>
    </el-dialog>
</template>
<script setup>
import UserDiv from './UserDiv.vue';
import { computed, defineProps, onBeforeUpdate, ref } from 'vue';
import { resolvedObj } from '../utils/request';
import request from '../utils/request';
const props = defineProps({
    List: Array
})

const avatar = ref();
const otherInfo = ref({

})

const centerDialogVisible = ref(false);

onBeforeUpdate(() => {
    console.log("list>>")
    console.log(props.List)
})
const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

const genderInCn = computed(() => {
    if (otherInfo.value.gender === 'Male')
        return '男';
    else if (otherInfo.value.gender === 'Female')
        return '女';
    else return '沃尔玛';
})

const showOtherInfo = (id) => {
    request.get('/userInfo', config)
        .then(() => {
            avatar.value = "https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/" + id + ".jpg"
            console.log("获取他人信息成功");
            console.log(resolvedObj.value);
            otherInfo.value = resolvedObj.value.data;
            centerDialogVisible.value = true;
        })
        .catch(error => {
            console.log(error);
        })
}

</script>

<style scoped></style>