<template>
    <div class="personal-info-container">
        <div class="basic-info-container">
            <el-avatar :size="100" :src="'https://oneshot-person.oss-cn-guangzhou.aliyuncs.com/' + infoObj.userId + '.jpg'">

            </el-avatar>
            <h2 style="margin: auto 10px;">{{ infoObj.userName + "&nbsp&nbsp&nbsp" + genderInCn }}</h2>
            <h3>{{ infoObj.email }}</h3>
            <el-link :icon="Edit" @click="isEdit = !isEdit">编辑资料</el-linK>
        </div>

        <div class="personal-signature">
            <p style="font-size: 18px;">{{ "个人简介：" + infoObj.personalSignature }}</p>
            <p>{{ infoObj.age + "岁" }}</p>
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

        <el-dialog v-model="isEdit" title="修改个人信息" center>
            <div class="form-container">
                <el-form ref="form" :model="formData" label-width="100px" :rules="rules">
                    <!-- <el-form-item label="头像">
                        <el-upload class="avatar-uploader" action="/upload" :show-file-list="false"
                            :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
                            <img v-if="formData.avatar" :src="formData.avatar" class="avatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                    </el-form-item> -->

                    <el-form-item label="用户名" prop="userName">
                        <el-input v-model="formData.userName"></el-input>
                    </el-form-item>

                    <el-form-item label="个性签名" prop="personSignature">
                        <el-input v-model="formData.personSignature"></el-input>
                    </el-form-item>

                    <el-form-item label="年龄" prop="age">
                        <el-input-number v-model="formData.age"></el-input-number>
                    </el-form-item>

                    <el-form-item label="性别" prop="gender">
                        <el-radio-group v-model="formData.gender">
                            <el-radio label="Male">男</el-radio>
                            <el-radio label="Female">女</el-radio>
                            <el-radio label="Walmart">其他</el-radio>
                        </el-radio-group>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="submitForm">确认修改</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-dialog>
    </div>
</template>

<script setup>
import { Edit } from '@element-plus/icons-vue'
import { computed, getCurrentInstance, onBeforeMount, onMounted, ref } from 'vue';
import MyShots from './MyShots.vue'
import UserDivContainer from './UserDivContainer.vue';
import request from '../utils/request';
import { resolvedObj } from '../utils/request';
import { useRouter } from 'vue-router';
const { proxy } = getCurrentInstance();
const router = useRouter();

const infoObj = ref({});
const fansPage = ref(1);
const objList = ref();

const formData = ref({
    userName: '', // 用户名
    personSignature: '', // 个性签名
    gender: '', // 性别
    age: '' // 头像
})
// 表单验证规则对象
const rules = ref({
    userName: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    gender: [
        { required: true, message: '请选择性别', trigger: 'change' }
    ],
    age: [
        { required: true, message: '请输入年龄', trigger: 'blur' },
        { type: 'number', message: '年龄必须是数字', trigger: 'blur' }
    ],
})

//判断是否在修改个人资料中，跳出对话框
const isEdit = ref(false);
onBeforeMount(() => {
    getPersonalInfo();
})

const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

//修改个人资料
const editPersonalInfo = () => {
    console.log("修改个人信息");
    isEdit.value = true;
}

const submitForm = () => {
    const form = proxy.$refs.form;
    form.validate(valid => {
        //验证通过，执行逻辑
        if (valid) {
            const param = {
                User: formData.value
            }

            const data = JSON.stringify(param);
            console.log("修改个人信息")
            console.log(data);
            request.put("/userInfo", data, config)
                .then(() => {
                    isEdit.value = false;
                    location.reload();
                })
        }
    })
}

const genderInCn = computed(() => {
    if (infoObj.value.gender === 'Male')
        return '男';
    else if (infoObj.value.gender === 'Female')
        return '女';
    else return '沃尔玛';
})

const getPersonalInfo = () => {

    request.get('/personPage', {
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
    request.get('personPage/fans/1', {
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
    request.get('subscribe/1', {
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