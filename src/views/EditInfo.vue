<script>

function open() {
  outerVisible.value = true;
  showForm.value = true;
}

const showForm = ref(false);


import { ref, reactive } from 'vue';
import request from '../utils/request';
const outerVisible = ref(false)
import { EditPen } from '@element-plus/icons-vue';




export default {
  data() {
    return {
      username: 'Lewis',
      userId: '77',
      gender: '男',
      bio: 'This is why we play',
      age: 19,
      avatar: 'https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/3.jpeg',
      dream: '拥有超能力',
      status: '总裁',
      outerVisible: false,
      multipleSelection: [],
      form: {},
      bubbles: [],
    };
  },
  methods: {
    save() {
      request.post("http://localhost:9090/admin/personinfo/addorupdate", this.form).then(res => {
        console.log(res);
        this.managerinfo1.username = res.username
        this.managerinfo1.gender = res.gender
        this.managerinfo1.personal_signature = res.personal_signature
        this.managerinfo1.age = res.age
        if (res) {
          this.$message.success("保存成功")
          this.outerVisible = false
        }
        else {
          this.$message.error("保存失败")
        }
      })

    },
  },
  setup() {
    const managerinfo1 = {
      username: 'Lewis',
      userId: 77,
      gender: '男',
      personal_signature: '感觉至上',
      age: '19',
      dream: '拥有超能力',
      status: '总裁',

    };
    const homepage = () => {
      var path = 'http://127.0.0.1:1206/homepage'; // 例如：'/about.html'

      // 使用 window.location.href 进行跳转
      window.location.href = path;
    }
    const open = () => {
      outerVisible.value = true;
      showForm.value = true;

    };
    const outerVisible = ref(false)
    const showForm = ref(false);
    return {
      managerinfo1,
      open,
      showForm,
      outerVisible,
      homepage
    }

  },
  components: {
    EditPen,
  },
  homepage() {
    var path = 'http://127.0.0.1:1206/homepage'; // 例如：'/about.html'

    // 使用 window.location.href 进行跳转
    window.location.href = path;
  },
  handleSelectionChange(val) {
    this.multipleSelection = val
  },
  handleEdit(row) {
    this.form = Object.assign({}, row)
    this.outerVisible = true
  },
  mounted() {
    this.$nextTick(() => {
      const numBubbles = 30; // 气泡数量
      const bubbleContainer = this.$refs.container.querySelector('.bubble-container');
      const bubbles = [];

      for (let i = 0; i < numBubbles; i++) {
        const x = Math.random();
        const y = Math.random();
        bubbles.push(`calc(100% * ${x}) calc(100% * ${y})`);
      }

      this.bubbles = bubbles.join(', ');
    });
  },
};
</script>

<template>
  <div style="margin-bottom:30px; margin-top: 10px; margin-left: 10px;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">
        首页
      </el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/' }">
        管理员个人信息
      </el-breadcrumb-item>

    </el-breadcrumb>
  </div>
  <div class="container1">
    <el-button @click="open" type="primary" style="margin-left: 260px; margin-top:70px">
      <el-icon style="vertical-align:middle">
        <EditPen />
      </el-icon> <span style="vertical-align:middle">
        编辑</span></el-button>
  </div>

  <div class="container" style="margin-top: 10px;" ref="container">
    <div class="profile-content">
      <div class="profile-avatar" style="margin-right: 100px;">
        <img :src="avatar" alt="头像" class="avatar-img">
      </div>
      <div class="profile-info">
        <div class="info-row" style="margin-top: 50px;">
          <span class="title">用户名:</span>
          <span>{{ managerinfo1.username }}</span>
        </div>
        <div class="info-row">
          <span class="title">ID:</span>
          <span>{{ managerinfo1.userId }}</span>
        </div>
        <div class="info-row">
          <span class="title">性别:</span>
          <span>{{ managerinfo1.gender }}</span>
        </div>
        <div class="info-row">
          <span class="title">个性签名:</span>
          <span>{{ managerinfo1.personal_signature }}</span>
        </div>
        <div class="info-row">
          <span class="title">年龄:</span>
          <span>{{ managerinfo1.age }}</span>
        </div>
        <div class="info-row">
          <span class="title">梦想:</span>
          <span>{{ managerinfo1.dream }}</span>
        </div>
        <div class="info-row">
          <span class="title">职位:</span>
          <span>{{ managerinfo1.status }}</span>
        </div>
      </div>





    </div>
    <div class="bubble-container" :style="{ '--bubbles': bubbles }"></div>
    <div class="social-icons">
      <a href="#"><i class="fab fa-facebook-f"></i></a>
      <a href="#"><i class="fab fa-twitter"></i></a>
      <a href="#"><i class="fab fa-instagram"></i></a>
    </div>
  </div>

  <el-dialog v-if="showForm" v-model="outerVisible" width="40%" center>
    <template #header>
      <div style="text-align: center; font-size: 24px; font-weight: bold;">编辑个人信息</div>
    </template>
    <el-image src="https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/3.jpeg" fit="contain"></el-image>
    <!-- <div style="text-align: center; font-size: 18px; margin-top: 20px;"><p style="font-weight: bold;font-size: 20px;">
    {{ pailide2.name }}
</p></div> -->
    <el-form label-width="120px">
      <el-form-item label="用户名:" style="margin-top:30px;">
        <el-input v-model="form.username" autocapitalize="off" center></el-input>
      </el-form-item>
    </el-form>
    <el-form label-width="120px">
      <el-form-item label="ID:" style="margin-top:30px">
        <el-input v-model="form.userId" autocapitalize="off" center></el-input>
      </el-form-item>
    </el-form>
    <el-form label-width="120px">
      <el-form-item label="性别:" style="margin-top:30px">
        <el-input v-model="form.gender" autocapitalize="off" center></el-input>
      </el-form-item>
    </el-form>
    <el-form label-width="120px">
      <el-form-item label="个性签名:" style="margin-top:30px">
        <el-input v-model="form.personal_signature" autocapitalize="off" center></el-input>
      </el-form-item>
    </el-form>
    <el-form label-width="120px">
      <el-form-item label="年龄:" style="margin-top:30px">
        <el-input v-model="form.age" autocapitalize="off" center></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="outerVisible = false">取消</el-button>
        <el-button type="primary" @click="save">
          确认
        </el-button>
      </div>
    </template>
  </el-dialog>
</template>



<style scoped>
.container {
  max-width: 850px;
  margin: 50px auto;
  background-color: #ffffff;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  padding: 20px;
}

.profile-content {
  display: flex;
  justify-content: center;
}

.profile-avatar {
  margin-right: 20px;
  text-align: center;
}

.profile-avatar .avatar-img {
  width: 400px;
  height: 400px;
  border-radius: 50%;
  object-fit: cover;
}

.profile-info {
  display: flex;
  flex-direction: column;
  font-family: Comic Sans MS;
  font-weight: bold;
  font-size: 20px;
}

.info-row {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.title {
  font-weight: bold;
  margin-right: 5px;
}

.social-icons {
  text-align: center;
}

.social-icons a {
  color: #888888;
  margin: 0 10px;
  font-size: 20px;
}

.bubble-container {
  position: relative;
  width: 100%;
  /* 调整容器宽度以适应气泡位置 */
  height: 100%;
  /* 调整容器高度以适应气泡位置 */
}

.bubble {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 20px;
  height: 20px;
  background-color: rgba(255, 255, 255, 0.5);
  border-radius: 50%;
  animation: float 5s infinite;

  --x: calc(Math.random() * 100);
  --y: calc(Math.random() * 100);
  top: var(--bubbles);
  left: var(--bubbles);
}

@keyframes float {
  0% {
    transform: translate(-50%, -50%);
  }

  50% {
    transform: translate(-50%, -60%);
  }

  100% {
    transform: translate(-50%, -50%);
  }
}</style>

