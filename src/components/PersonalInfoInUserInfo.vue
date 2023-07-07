<template>
    <div class="personal-info-container">
        <div class="basic-info-container">
            <el-avatar :size="100" :src="'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + infoObj.userId + '.jpg'">

            </el-avatar>
            <h2 style="margin: auto 10px;">{{ infoObj.userName }}</h2>
            <h3>{{ infoObj.email }}</h3>
            <el-link :icon="Edit">编辑资料</el-linK>
        </div>

        <div class="personal-signature">
            <p>{{ infoObj.personalSignature }}</p>
        </div>

        <div class="addition-info">
            <div class="addition-info-block" @click="showMyShots">
                <H2>获赞</H2>
                <h3>{{ infoObj.totalReceivedThumbs }}</h3>
            </div>
            <div class="addition-info-block" @click="showMyFans">
                <H2>粉丝</H2>
                <h3>{{ infoObj.totalFancies }}</h3>
            </div>
            <div class="addition-info-block" @click="showMyFollow">
                <H2>关注</H2>
                <h3>{{ infoObj.totalSubscriptions }}</h3>
            </div>
        </div>

        <div class="personal-info-main">
            <el-scrollbar max-height="500px">
                <component :is="personSubComponent" :List="objList" />
            </el-scrollbar>
        </div>
    </div>
</template>

<script setup>
import { Edit } from '@element-plus/icons-vue'
import { onBeforeMount, onMounted, ref } from 'vue';
import MyShots from './MyShots.vue'
import UserDivContainer from './UserDivContainer.vue';
import request from '../utils/request';
import { resolvedObj } from '../utils/request';
import { useRouter } from 'vue-router';
const router = useRouter();

const url = 'http://localhost:8080/';
const infoObj = ref({});
const fansPage = ref(1);
const objList = ref();

onBeforeMount(() => {
    getPersonalInfo();
})

const getPersonalInfo = () => {

    request.get(url + 'personPage', {
        headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }
    })
        .then(() => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            else {
                console.log(resolvedObj.value);
                infoObj.value = resolvedObj.value.data;
            }
        })
}

const personSubComponent = ref(MyShots);

const showMyShots = () => {
    personSubComponent.value = MyShots;
}

//初始化Fans界面
const showMyFans = () => {
    personSubComponent.value = UserDivContainer;
    request.get(url + 'personPage/fans/1', {
        headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }
    })
        .then(() => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            else {
                console.log(resolvedObj.value);
                objList.value = resolvedObj.value.data;
                fansPage.value = 2;
            }
        })
}

const showMyFollow = () => {
    personSubComponent.value = UserDivContainer;
    request.get(url + 'subscribe/1', {
        headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }
    })
        .then(() => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            else {
                console.log(resolvedObj.value);
                objList.value = resolvedObj.value.data;
                fansPage.value = 2;
            }
        })
}
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
    border-top: 3px solid #718b9c;

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
</style>