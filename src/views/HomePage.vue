<script setup>
import Header from '../components/Header1.vue';

import { onBeforeMount, onMounted, reactive, ref } from 'vue';
import axios from '../utils/request'
import { useRouter } from 'vue-router';
import { resolvedObj } from '../utils/request';
import { ElMessage } from 'element-plus';
import { Search } from '@element-plus/icons-vue'

function manager() {
  var path = 'http://127.0.0.1:5173/'; // 例如：'/about.html'

  // 使用 window.location.href 进行跳转
  window.location.href = path;
}


</script>
<script>
export default {

  methods: {
    goToEquipment() {
      this.$router.push('/equipment')
    },
    gotoGame() {
      this.$router.push('/game')
    },
    tologin() {
      this.$router.push('/login')
    },
    toregister() {
      this.$router.push('/register')
    },
    toshot() {
      this.$router.push('/shots')
    }
  }
}
</script>

<template>
  <div class="Header">
    <Header />
  </div>

  <div class="wave-image">
    <div class="image-container">
      <img src="src/assets/images/3.jpeg" alt="fengmianphoto" style="width: 1600px; height: auto;">
      <div class="text-overlay">
        <h2>让美好触手可及！</h2>
        <div class="button-container">
          <el-button @click="toregister" style="border-radius: 20px; padding: 0 35px;border:2px solid black;">
            <p style="font-weight: bold;
        font-size: 25px;">加入OneShot</p>
          </el-button>
        </div>
      </div>
      <svg class="wave-overlay" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1400 200" preserveAspectRatio="none">
        <path fill="#ffffff"
          d="M0,100 C100,90 300,170 500,190 S800,30 1000,110 S1200,0, 1400,130 S1600,70 1800,90 L1800,200 L0,200Z"></path>
      </svg>
    </div>
  </div>

  <div class="laboltext1" style="margin-left:480px">
    <p>
      是什么让我们与众不同
    </p>
  </div>

  <div class="image-text-wrapper">
    <div class="left-image" style="margin-left: 30px;">
      <img src="src/assets/images/camera.jpg" alt="左边图片">
      <p>展现你自己<br>建立自己的品牌</p>
    </div>

    <div class="center-image">
      <img src="src/assets/images/chat.jpg" alt="中间图片">
      <p>在摄影社区互动<br>与全球摄影师建立联系<br>提升审美与摄影技巧</p>
    </div>

    <div class="right-image">
      <img src="src/assets/images/linggan.jpeg" alt="右边图片">
      <p>发现美图价值灵感<br>让作品产生价值<br>比赛赚收益</p>
    </div>
  </div>

  <div class="image-container" style="margin-top: 130px;">
    <img src="src/assets/images/lion.jpeg" alt="fengmianphoto" style="width: 1600px; height: auto;">
    <div class="text-overlay1">
      <!-- <img src="src/assets/images/shot.png" alt="icon" class="icon1"> -->
      <h2 style="margin-top: 30px;"> Shot推荐</h2>
    </div>
  </div>

  <div class="textall" style="text-align: center;">
    <p style="margin-top: 23px;font-weight: bold;font-size: 27px;margin-left:auto;margin-right: auto;">没灵感？ 来看Shot推荐啊！</p>
    <p style="font-size: 18px;margin-top: 10px;">查看编辑精选图片，获取创作灵感</p>
    <el-button @click="toshot" style="border-radius: 20px; padding: 0 35px;border:2px solid black;
    margin-top:30px;background-color: black;width: 180px;height: 50px;">
      <p style="color: white;font-size: 18px;">浏览Shot推荐</p>
    </el-button>
  </div>

  <div class="image-container1" style="margin-top: 30px;">
    <img src="src/assets/images/scene1.jpg" style="margin-left: 150px; width:300px ;" />
    <img src="src/assets/images/scene2.jpeg" style="margin-left: 10px; height:450px;width:650px" />
    <img src="src/assets/images/scene3.jpeg" style="margin-left: 10px; width:350px;height: 450px ;" />
  </div>

  <div class="image-container" style="margin-top: 130px;">
    <img src="src/assets/images/lion1.jpeg" alt="fengmianphoto" style="width: 1600px; height: auto;">
    <div class="text-overlay1"><img src="src/assets/images/game.png" alt="icon" class="icon2">
      <h2 style="margin-top: 30px;">比赛</h2>
    </div>
  </div>

  <div class="textall" style="text-align: center;">
    <p style="margin-top: 23px;font-weight: bold;font-size: 27px;margin-left:auto;margin-right: auto;">
      众多比赛就差你了</p>
    <p style="font-size: 18px;margin-top: 10px;">
      投稿摄影比赛活动，获得OneShot的专属流量推荐以及丰富奖品</p>
    <el-button @click="gotoGame" style="border-radius: 20px; padding: 0 35px;border:2px solid black;
    margin-top:30px;background-color: black;width: 180px;height: 50px;">
      <p style="color: white;font-size: 18px;">更多比赛</p>
    </el-button>
  </div>

  <div class="image-container1" style="margin-top: 30px;">
    <img src="src/assets/images/game1.jpg" style="margin-left: 120px; width:450px ;position: relative;" />
    <div class="image-caption1">
      <p>2023武汉大学影像大赛</p>
      <p1>武汉大学</p1>
    </div>
    <img src="src/assets/images/game2.jpg" style="margin-left: 10px; width:450px ;position: relative;" />
    <div class="image-caption2">
      <p>2023华中科技大学影像大赛</p>
      <p1>华中科技大学</p1>
    </div>
    <img src="src/assets/images/game3.jpeg" style="margin-left: 10px; width:450px ;position: relative;" />
    <div class="image-caption3">
      <p>2023小米影像大赛</p>
      <p1>小米终端有限公司</p1>
    </div>
  </div>

  <div class="image-container" style="margin-top: 100px;">
    <img src="src/assets/images/xueshan.jpg" style="width: 1600px; height: auto;">
    <div class="text-overlay1"><img src="src/assets/images/luntan.png" alt="icon" class="icon2">
      <h2 style="margin-top: 30px;">器材</h2>
    </div>
  </div>

  <div class="textall" style="text-align: center;">
    <p style="margin-top: 23px;font-weight: bold;font-size: 27px;margin-left:auto;margin-right: auto;">
      浏览器材，找到宝藏</p>
    <p style="font-size: 18px;margin-top: 10px;">

      查看器材，找到适合自己的装备。浏览参数，发现性价比之王。
    </p>
    <el-button @click="goToEquipment" style="border-radius: 20px; padding: 0 35px;border:2px solid black;
    margin-top:30px;background-color: black;width: 180px;height: 50px;">
      <p style="color: white;font-size: 18px;">更多器材</p>
    </el-button>
    <!-- <p style="margin-top: 20px;">(论坛功能仍在开发中......OneShoter加班ing)</p> -->
  </div>

  <div class="image-container" style="margin-top: 130px;">
    <img src="src/assets/images/dianlan.jpeg" style="width: 1600px; height: auto;">
    <div class="text-overlay1">
      <h2 style="margin-top: 30px;">加入我们</h2>
      <p style="margin-bottom: 30px;">Everything is possible!</p>
      <div class="button-container1">
        <el-button @click="toregister" style="border-radius: 20px; padding: 0 35px;border:2px solid black;">
          <p style="font-weight: bold;
        font-size: 25px;color: black;margin-bottom: 10px;">注册</p>
        </el-button>
      </div>
    </div>
  </div>

  <div style="margin-top:60px;height:60px; line-height: 60px; border-bottom: 1px solid #ccc; background-color: white;">
  </div>
  <div style="display: inline;">
    <p style="font-size: 18px;margin-left: 650px;margin-top: 30px;display: inline-block;">©武汉OneShot网络科技有限公司出品</p>
    <el-button @click="manager" style="display: inline-block;margin-left:400px;margin-bottom: 10px;">
      <p style="font-size: 18px;
      font-weight: bold;">管理员走这边</p>
    </el-button>
  </div>
</template>

<style>
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

.image-container1 {
  display: flex;
  position: relative;
}

.image-container1 img {
  width: 33%;
  object-fit: cover;
}

.image-caption1 {
  position: absolute;
  top: 50%;
  left: 21%;
  transform: translate(-50%, -50%);
}

.image-caption1 p {
  color: #ffffff;
  font-size: 30px;
  text-align: center;
  font-weight: bold;
}

.image-caption1 p1 {
  color: #ffffff;
  font-size: 19px;
  text-align: center;
  margin-left: 120px;
  margin-top: 20px;
}


.image-caption2 {
  position: absolute;
  top: 50%;
  left: 51%;
  transform: translate(-50%, -50%);
}

.image-caption2 p {
  color: #ffffff;
  font-size: 30px;
  text-align: center;
  font-weight: bold;
}

.image-caption2 p1 {
  color: #ffffff;
  font-size: 19px;
  text-align: center;
  margin-left: 120px;
  margin-top: 20px;
}

.image-caption3 {
  position: absolute;
  top: 50%;
  left: 80%;
  transform: translate(-50%, -50%);
}

.image-caption3 p {
  color: #ffffff;
  font-size: 30px;
  text-align: center;
  font-weight: bold;
}

.image-caption3 p1 {
  color: #ffffff;
  font-size: 19px;
  text-align: center;
  margin-left: 50px;
  margin-top: 20px;
}

.icon1 {
  width: 110px;
  height: 110px;
  vertical-align: middle;
  margin-right: 8px;
  margin-left: 45px;
  margin-top: 40px;
}

.icon2 {
  width: 130px;
  height: 130px;
  vertical-align: middle;
  margin-right: 8px;
  margin-left: 0px;
  margin-top: 80px;
}

.button-container {
  margin-top: 30px;
  /* 调整按钮与文字的间距 */
  /* text-align: center; 居中按钮 */
  margin-left: 0px
}

.button-container button {
  padding: 10px 20px;
  /* 调整按钮的内边距 */
  background-color: #ffffff;
  color: #000000;
  font-size: 16px;
  height: 60px;
  width: 230px;
  /* 添加其他样式以满足你的需求 */
}

.button-container1 {
  margin-top: 10px;
  /* 调整按钮与文字的间距 */
  /* text-align: center; 居中按钮 */
  margin-left: 0px
}

.button-container1 button {
  padding: 10px 20px;
  /* 调整按钮的内边距 */
  background-color: #ffffff;
  color: #000000;
  font-size: 16px;
  height: 70px;
  width: 330px;
  /* 添加其他样式以满足你的需求 */
}

.image-container {
  position: relative;
  overflow: hidden;
  width: 1600px;
  height: auto;
}

.image {
  display: block;
  width: 100%;
  height: auto;
}

.text-overlay {
  position: absolute;
  top: 65%;
  left: 20%;
  transform: translate(-50%, -50%);
}

.text-overlay h2 {
  color: #ffffff;
  font-size: 53px;
  text-align: center;
  font-weight: bold;
  /* 添加其他样式以满足你的需求 */
}

.text-overlay1 p {
  margin-top: 10px;
  color: #ffffff;
  font-size: 20px;
  text-align: center;

}

.text-overlay1 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.text-overlay1 h2 {
  color: #ffffff;
  font-size: 53px;
  text-align: center;
  font-weight: bold;
  /* 添加其他样式以满足你的需求 */
}

.wave-image {
  position: relative;
  overflow: hidden;
  width: 1596px;
  height: auto;
}

.wave-image img {
  display: block;
  width: 100%;
  height: auto;
}

.wave-overlay {
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100px;

}

.image-text-wrapper {
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
}

.left-image,
.center-image,
.right-image {
  text-align: center;
  width: 33.33%;
}

.left-image img,
.center-image img,
.right-image img {
  max-width: 50%;
}

.left-image p,
.center-image p,
.right-image p {
  margin-top: 10px;
  font-size: 24px;
  font-weight: bold;
}

/* .laboltext1 p, */
.laboltext p,
.additional-text p {
  margin-top: 10px;
  font-size: 20px;
  font-weight: bold;
}

.laboltext1 p {
  margin-top: 60px;
  font-size: 40px;
  font-weight: bold;
  margin-left: 110px;
}

.body {
  background-color: azure;
}

.container {
  display: flex;
  flex-direction: column;
  padding: 10px;
}

.breadcrumb {
  margin-bottom: 30px;
}

.profile {
  display: flex;
  align-items: center;
  margin-bottom: 30px;
}

.avatar {
  margin-right: 20px;
}

.carousel-wrapper {
  flex: 1;
}
</style>