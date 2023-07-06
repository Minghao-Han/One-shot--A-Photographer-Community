<template>
    <Header />

    <el-container class="main-content">
        <ShotsContainer :new-shots="shots" />
        <Aside />
    </el-container>

  



  <el-button @click="login2" style="margin-left: 200px"><p style="font-size: 20px;font-weight: bold;">发布Shot</p></el-button>


  <el-dialog v-if="showForm1" v-model="outerVisible1"  title="发布shot" width="45%" center  >
    <div style="display: inline-block;"> 
    <el-upload
        class="upload-demo"
        action="/your-upload-url"
        :show-file-list="false"
        :before-upload="beforeUpload"
      >
        <el-button  style="margin-left: 0px; width:350px;height: 300px; background-image:url(src/assets/images/scene2.jpeg)"  ><p style="font-weight: bold;
        font-size: 22px;">点击上传</p>
        </el-button>
  
      </el-upload>
    </div>

      <div style="display: inline-block; vertical-align: top;">
    <el-form label-width="100px" style="margin-top: 0px;" >
<el-form-item label="图片的主题" style="margin-left: 13px;">
</el-form-item>
    </el-form>
    <el-input v-model="form.title" autocapitalize="off" center style="margin-left: 30px;"></el-input>

<div>
    <el-form label-width="100px" style="margin-top: 13px;" >
<el-form-item label="补充文字">
</el-form-item>
    </el-form>
    <el-input v-model="form.content" autocapitalize="off" type="textarea" :rows="7" center style="margin-left: 30px;height: 200px;"></el-input>
</div>
      </div>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="outerVisible1 = false">还要想想</el-button>
        <el-button type="primary" @click="save">  
            <!-- save调用我的图片服务器函数 -->
          确认上传
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>


<script setup>

import Header from '../components/Header.Vue';
import ShotsContainer from '../components/ShotsContainer.vue';
import Aside from '../components/Aside.vue';
import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import axios from '../utils/request'
import { useRouter } from 'vue-router';
import { resolvedObj } from '../utils/request';
import { ElMessage } from 'element-plus';
const pageNum = ref(1);
const router = useRouter();

const outerVisible = ref(false)
const showForm = ref(false);

const outerVisible1 = ref(false)
const showForm1 = ref(false);

function login1()
{
    
        outerVisible.value=true;
        showForm.value = true;
   
}

function login2(){
    outerVisible1.value=true;
        showForm1.value = true;
   
}

const form = reactive({
   title:'',
   content:''

}
);

const shots = ref();

//获取最初的shot
onMounted(() => {
    shotsPage();
})

//请求一页shots
const shotsPage = () => {
    const url = "http://localhost:9090/shotBrowse/4/" + pageNum.value;
    axios.get(url, {
        headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }
    })
        .then(response => {
            if (resolvedObj.value.code === "500") {
                ElMessage("验证过期，请重新登录");
                router.replace('/login');
            }
            console.log(resolvedObj.value.data);
            shots.value = resolvedObj.value.data;
            pageNum.value++;
            console.log(shots.value[0]);
        })
}
</script>

<style scoped>
.main-content {
    display: flex;
    justify-content: center;
}
</style>