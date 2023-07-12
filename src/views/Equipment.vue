<script setup>
import Header from '../components/Header.vue';

import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import axios from '../utils/request'
import { useRouter } from 'vue-router';
import { resolvedObj } from '../utils/request';
import { ElMessage } from 'element-plus';
import { Search } from '@element-plus/icons-vue'

const outerVisible = ref(false)
const outerVisible1 = ref(false)

const form = reactive({
    format: '',
    type: '',
    size: '',
    pixel: '',
    imgformat: ''

}
);
const config = {
    headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
    }
}

const targetArray = ref()


const showForm = ref(false);

const showForm1 = ref(false);// 控制表单的显示与隐藏

function conHou() {
    axios.get("/camera/get?name=" + camera1.value.name, config).then(res => {
        console.log(resolvedObj.value)

        targetArray.value = resolvedObj.value;
        console.log(targetArray.value[0].sensor_format)
        form.format = targetArray.value[0].sensor_format;
        form.type = targetArray.value[0].sensor_type;
        form.size = targetArray.value[0].sensor_size;
        form.pixel = targetArray.value[0].total_pixels;
        form.imgformat = targetArray.value[0].image_format;

        outerVisible.value = true;
        showForm.value = true;
    }).catch(err => {
        console.error(err);
    });
}

function pailideshow() {
    axios.get("/get?name=" + pailide2.value.name, config).then(res => {
        console.log(resolvedObj.value)

        targetArray.value = resolvedObj.value;
        console.log(targetArray.value[0].sensor_format)
        form.format = targetArray.value[0].sensor_format;
        form.type = targetArray.value[0].sensor_type;
        form.size = targetArray.value[0].sensor_size;
        form.pixel = targetArray.value[0].total_pixels;
        form.imgformat = targetArray.value[0].image_format;

        outerVisible1.value = true;
        showForm1.value = true;
    }).catch(err => {
        console.error(err);
    });
}

const showcamera1 = () => {

    alert('了解详情维护中')
}

function toggleForm() {
    // console.log('Toggle Form');
    outerVisible.value = true;
    showForm.value = true; // 切换表单的显示与隐藏
}

const camera1 = ref({
    name: 'FUJIFILM GFX 50SII'
})

const camera2 = ref({
    name: 'FUJIFILM  GFX 100X'
})

const camera3 = ref({
    name: 'FUJIFILM GFX100 IR Ver.'
})

const camera4 = ref({
    name: 'FUJIFILM GFX 50S'
})

const camera5 = ref({
    name: 'FUJIFILM GFX 50R'
})

const camera6 = ref({
    name: 'FUJIFILM GFX 100S'
})

const lens1 = ref({
    name: 'GF23mmF4 R LM WR'
})

const lens2 = ref({
    name: 'GF30mmF3.5 R WR'
})

const lens3 = ref({
    name: 'GF45mmF2.8 R WR'
})

const lens4 = ref({
    name: 'GF50mmF3.5 R LM WR'
})

const blens1 = ref({
    name: 'GF20-35mmF4 R WR'
})

const blens2 = ref({
    name: 'GF35-70mmF4.5-5.6 WR'
})

const blens3 = ref({
    name: 'GF32-64mmF4 R LM WR'
})

const blens4 = ref({
    name: 'GF45-100mmF4 R LM OIS WR'
})

const LongMirror = ref({
    name: 'TELECONVERTER GF1.4X TC WR'
})

const pailide1 = ref({
    name: 'instax mini 7+ '
})

const pailide2 = ref({
    name: 'instax mini 90 '
})
</script>



<template>
    <div class="Header">
        <Header />
    </div>
    <div class="container" style="margin-top: 10px;width:750px;display: inline-block; position: relative;" ref="container">
        <div class="title1container" style="margin-left: 150px;margin-top:100px;font-size: 28px;font-weight:bold;">
            <p>
                高性能器材，获得如OneShot一般的极致表现
            </p>
        </div>
        <div class="title1container1" style="margin-left: 150px;margin-top:50px;font-size: 18px;">
            <p>
                从中画幅、大画幅胶卷相机到电视、电影等镜头，无不应用了备受专业图片及影像工作者追捧的FUJINON镜头的光学技术。
            </p>
        </div>
        <div class="title1container2" style="margin-left: 150px;margin-top:50px;font-size: 18px;">
            <p>
                能够实现大型传感器潜力的高精度、高分辨率镜头现已上线。摄影师们追求的高画质、色彩重现及规格已经成为现实，为专业摄影师的作品创作，文化遗产的保存传承等摄影场景提供专业支持。
            </p>
        </div>
    </div>

    <div class="imgcontainer" style="margin-left:30px;margin-top: 50px;width:500px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/fuji1.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 数码相机模块 -->
    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
            <div style="display:flex">
                <div style="width:400px;color:dark; font-weight: bold;padding-left: 20px;font-size: 24px;
font-family:微软雅黑">
                    <div class="container" style="display: flex;">
                        <p style="margin-left:0px;font-size: 28px;">
                            GFX无反数码相机
                        </p>
                        <p style="font-size: 12px;">（*了解详情维护中）</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gfx50sii.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>


    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/fujigfx100.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gfx100ir.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gfx50x.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:160px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ camera1.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:220px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ camera2.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:170px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ camera3.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:150px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ camera4.name }}
        </p>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 160px;margin-top:30px;display: inline-block;">
        <el-button @click="conHou" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 110px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>


    <!-- 第二行 -->
    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gfx50r.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gfx100s.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:160px;font-size: 22px;font-weight: bold;display: block;">
        <div style="display: inline-block;">
            <p>
                {{ camera5.name }}
            </p>
        </div>
        <div style="display: inline-block; margin-left:220px">
            <p>
                {{ camera6.name }}
            </p>
        </div>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 160px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>



    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
            <div style="display:flex">
                <div style="width:400px;color:dark; font-weight: bold;padding-left: 20px;font-size: 24px;
font-family:微软雅黑">
                    <div class="container" style="display: flex;">
                        <p style="margin-left:0px;font-size: 28px;">
                            G卡口定焦镜头
                        </p>
                        <p style="font-size: 12px;">（*了解详情维护中）</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/Gf23mm.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>


    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gf30mm.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gf40.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:50px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/gf50.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:160px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ lens1.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:200px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ lens2.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:170px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ lens3.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:150px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ lens4.name }}
        </p>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 160px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 110px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
            <div style="display:flex">
                <div style="width:400px;color:dark; font-weight: bold;padding-left: 20px;font-size: 24px;
font-family:微软雅黑">
                    <div class="container" style="display: flex;">
                        <p style="margin-left:0px;font-size: 28px;">
                            G卡口变焦镜头
                        </p>
                        <p style="font-size: 12px;">（*了解详情维护中）</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/20-35.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>


    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/32-64.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:70px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/35-70.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:50px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/45-100.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:170px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ blens1.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:150px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ blens2.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:130px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ blens3.name }}
        </p>
    </div>

    <div style="margin-top:80px;margin-left:110px;font-size: 22px;font-weight: bold;display: inline-block;">
        <p>
            {{ blens4.name }}
        </p>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 160px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 120px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-left: 110px;margin-top:30px;display: inline-block;">
        <el-button @click="showcamera1" style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>

    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
            <div style="display:flex">
                <div style="width:400px;color:dark; font-weight: bold;padding-left: 20px;font-size: 24px;
font-family:微软雅黑">
                    <div class="container" style="display: flex;">
                        <p style="margin-left:0px;font-size: 28px;">
                            远摄增距镜
                        </p>
                        <p style="font-size: 12px;">（*了解详情维护中）</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/yuanshezengju.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:150px;font-size: 22px;font-weight: bold;">
        <p>
            {{ LongMirror.name }}
        </p>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 150px;margin-top:30px;">
        <el-button style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>


    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
            <div style="display:flex">
                <div style="width:400px;color:dark; font-weight: bold;padding-left: 20px;font-size: 24px;
font-family:微软雅黑">
                    <div class="container" style="display: flex;">
                        <p style="margin-left:0px;font-size: 28px;">
                            instax mini
                        </p>
                        <p style="font-size: 12px;">（*了解详情维护中）</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 图片 -->
    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/mini7+_.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <div class="imgcontainer" style="margin-left:80px;margin-top: 10px;width:300px;display: inline-block;"
        ref="imgcontainer">
        <img src="src/assets/images/mini90.jpg" alt="fuji1"
            style="position: relative;top:70px;margin-left:50px;width: 100%; height: auto;">
    </div>

    <!-- 名字 -->
    <div style="margin-top:80px;margin-left:190px;font-size: 22px;font-weight: bold;">
        <p style="display: inline-block;">
            {{ pailide1.name }}
        </p>

        <p style="display: inline-block; margin-left:260px">
            {{ pailide2.name }}
        </p>
    </div>

    <!-- 按钮 -->
    <div style="margin-left: 150px;margin-top:30px;">
        <el-button style="width: 250px;height:60px; background-color: RGB(235, 235, 235);">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>

        <el-button @click="pailideshow"
            style="width: 250px;height:60px; background-color: RGB(235, 235, 235);margin-left: 130px;">
            <p style="font-size: 19px;font-weight: bold;">了解详情</p>
            <el-icon style="position: relative;left:50px;font-size: 20px;">
                <Search />
            </el-icon>
        </el-button>
    </div>



    <div style="margin-top:100px;margin-left: 130px;margin-right: 100px;">
        <div style="height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
        </div>
    </div>

    <div class="additional-text" style="margin-top: 50px;margin-left:580px">
        <p style="font-size: 30px;
    font-weight: bold;">联系我们:武汉大学OneShot团队
            <br>联系方式:1907821839@qq.com
        </p>
    </div>

    <div class="laboltext" style="margin-left:730px">
        <p style="font-size: 30px;
    ;">
            @Relaxism
        </p>
    </div>


    <el-dialog v-if="showForm" v-model="outerVisible" width="40%" center>
        <template #header>
            <div style="text-align: center; font-size: 24px; font-weight: bold;">数码相机参数</div>
        </template>
        <el-image src="src/assets/images/gfx50sii.jpg" fit="contain"></el-image>
        <div style="text-align: center; font-size: 18px; margin-top: 20px;">
            <p style="font-weight: bold;font-size: 20px;">
                {{ camera1.name }}
            </p>
        </div>
        <el-form label-width="120px">
            <el-form-item label="影像传感器格式:" style="margin-top:30px;">
                <el-input disabled v-model="form.format" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="影像传感器类型:" style="margin-top:30px">
                <el-input disabled v-model="form.type" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="影像传感器尺寸:" style="margin-top:30px">
                <el-input disabled v-model="form.size" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="总像素数:" style="margin-top:30px">
                <el-input disabled v-model="form.pixel" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="图像格式:" style="margin-top:30px">
                <el-input disabled v-model="form.imgformat" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
    </el-dialog>



    <el-dialog v-if="showForm1" v-model="outerVisible1" width="40%" center>
        <template #header>
            <div style="text-align: center; font-size: 24px; font-weight: bold;">拍立得相机参数</div>
        </template>
        <el-image src="src/assets/images/mini90.jpg" fit="contain"></el-image>
        <div style="text-align: center; font-size: 18px; margin-top: 20px;">
            <p style="font-weight: bold;font-size: 20px;">
                {{ pailide2.name }}
            </p>
        </div>
        <el-form label-width="120px">
            <el-form-item label="影像传感器格式:" style="margin-top:30px;">
                <el-input disabled v-model="form.format" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="影像传感器类型:" style="margin-top:30px">
                <el-input disabled v-model="form.type" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="影像传感器尺寸:" style="margin-top:30px">
                <el-input disabled v-model="form.size" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="总像素数:" style="margin-top:30px">
                <el-input disabled v-model="form.pixel" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
        <el-form label-width="120px">
            <el-form-item label="图像格式:" style="margin-top:30px">
                <el-input disabled v-model="form.imgformat" autocapitalize="off" center></el-input>
            </el-form-item>
        </el-form>
    </el-dialog>

    <!-- 提示框 -->
    <el-alert title="" type="success" :closable="false" style="background-color: white" />
</template>




<style>
.container {
    display: inline-block;
}

.Header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100px;
    /* 设置适当的高度 */
    z-index: 999;
    /* 添加其他样式 */
}
</style>