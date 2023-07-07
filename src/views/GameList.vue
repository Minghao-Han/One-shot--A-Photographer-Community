<template>
  <div class="Header">
<Header /></div>

  <div class="container">
    <el-menu mode="horizontal" class="menu" @select="handleMenuSelect">
      <el-menu-item index="history" class="menu-item"><p style="font-weight: bold;">历史比赛</p></el-menu-item>
      <el-menu-item index="ongoing" class="menu-item"><p style="font-weight: bold;">进行中的比赛</p></el-menu-item>
    </el-menu>

    <div class="content">
      <el-card v-for="game in state.games.value" :key="game.id">
        <div style="display: flex; flex-direction: row;">
   
    <div style="flex: 1;">
        <div class="game-title">{{ game.title }}</div>
        <div class="game-content">{{ game.content }}</div>
        <div class="game-info">
          <div>起始时间: {{ formatDate(game.start_time) }}</div>
          <div>结束时间: {{ formatDate(game.end_time) }}</div>
          <div v-if="game.winner">获奖者ID: {{ game.winner }}</div>
        </div>
        </div>
         <div style="flex: 0 0 auto;">
          <div style="width:250px;height: 50px;margin-bottom: 30px;">
      <img src="src/assets/images/2.jpg" alt="fengmianphoto">
    </div>
    </div>
        </div>
      </el-card>

      <div v-if="isLoading" class="loading">加载中...</div>
      <div v-if="!hasMore" class="end">已加载全部比赛信息</div>
    </div>
  </div>

  <!-- <div>
    <uploadtest/>
    <h1>请上传图片：</h1>
    <form action="/imgtest/upload" method="post" enctype="multipart/form-data">
      <input ref="fileInput1" type="file" name="file" @change="handleFileChange($event, 'fileInput1')">
      <input type="submit" value="上传">
    </form> -->

    <!-- <form action="/imgtest/upimg" method="post" enctype="multipart/form-data">
      <input ref="fileInput2" type="file" name="file" @change="handleFileChange($event, 'fileInput2')">
      <input type="submit" value="上传">
    </form> -->
    <!-- <div>
   
    <input type="file" @change="handleFileChange">
    <button @click="uploadFile">上传</button>
  </div>
  </div> --> 
</template>

<script>
import Header from '../components/Header.Vue';
import { reactive, onMounted,ref } from 'vue'
import { ElMenu, ElMenuItem, ElCard } from 'element-plus'
import axios  from '../utils/request'
import { resolvedObj } from '../utils/request'
import uploadtest from './uploadtest.vue';

const fileInput1 = ref(null);
const fileInput2 = ref(null);

const handleFileChange = (event, refName) => {
  const inputElm = refName === 'fileInput1' ? fileInput1.value : fileInput2.value;
  
  // 处理文件选择事件的逻辑
  const file = event.target.files[0];
  if (file) {
    // 执行你的逻辑，例如上传文件等
  }
  
  // 清空文件输入框的值
  if (inputElm) {
    inputElm.value = '';
  }
}

export default {
  data() {
    return {
      file: null
    };
  },
  components: {
    ElMenu,
    ElMenuItem,
    ElCard,
  },
  methods:{
    handleFileChange(event) {
      this.file = event.target.files[0];
    },
    uploadFile() {
      const formData = new FormData();
      formData.append('file', this.file);

      axios.post('http://172.20.10.2:9090/img/upimgshot', formData,
      {
        headers:{
          'Content-Type':'multipart/form-data'
        }
      })
        .then(response => {
          // 处理上传成功的逻辑
        })
        .catch(error => {
          // 处理上传失败的逻辑
        });
    }
  },  setup() {
    const state = reactive({
      games: Array, // 存储比赛信息的数组
     
      page: 1, // 当前页数
      isLoading: false, // 是否正在加载
      hasMore: true, // 是否还有更多比赛信息
      menu: 'history', // 当前选中的菜单项，默认为历史比赛
    })
    // 格式化日期
    const formatDate = (date) => {
      return new Date(date).toLocaleString()
    }

    // const games = ref([]) // 存储比赛信息的数组

    // 获取历史比赛信息
    const getHistoryGames = (page) => {
      state.isLoading = true

      // 向后端发送GET请求获取历史比赛信息
      // 使用实际的接口地址和参数
      axios
        .get("http://localhost:9090/game/history/1",{headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }})
        .then(response => {
          state.games.value=new Array();
          
          const data = resolvedObj.value.data
          console.log("<<data")
          console.log(resolvedObj.value)
          console.log(data);
          // 将获取到的比赛信息添加到games数组中
          state.games.value.push(...data)
          state.isLoading = false
          console.log(state.games.value)

          if (data.length === 0) {
            state.hasMore = false
          }
        })
        .catch(error => {
          console.error(error)
          state.isLoading = false
        })
    }

    // 获取进行中的比赛信息
    const getOngoingGames = () => {
      // 向后端发送GET请求获取进行中的比赛信息
      // 使用实际的接口地址
      axios
        .get("http://localhost:9090/game/ongoing",{headers: {
            'Content-Type': 'application/json',
            'token': localStorage.getItem('token')
        }})
        .then(response => {
          state.games.value=new Array();
          console.log(resolvedObj.value)
          const data = resolvedObj.value.data
          console.log(data);
          console.log("<<data")
          console.log(state.games.value)
          // 将获取到的比赛信息添加到games数组中
          state.games.value.push(...data);
          console.log(state.games.value)
        })
        .catch(error => {
          console.error(error)
        })
    }

    // 处理菜单选择
    const handleMenuSelect = (index) => {
      state.menu = index
      state.page = 1
      state.games = []
      state.hasMore = true

      if (index === 'history') {
        getHistoryGames(state.page)
      } else if (index === 'ongoing') {
        getOngoingGames()
      }
    }

    // 监听滚动事件，当滚动到底部时加载下一页数据
    const handleScroll = () => {
      const windowHeight = window.innerHeight
      const documentHeight = document.documentElement.offsetHeight
      const scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop

      if (
        windowHeight + scrollTop >= documentHeight &&
        !state.isLoading &&
        state.hasMore &&
        state.menu === 'history'
      ) {
        state.page++
        getHistoryGames(state.page)
      }
    }

    onMounted(() => {
      window.addEventListener('scroll', handleScroll)
    })

    return {
      state,
      formatDate,
      handleMenuSelect,
    }
  },
}
</script>

<style>
.Header {
    position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100px; /* 设置适当的高度 */
  z-index: 999;
  /* 添加其他样式 */
}

.container {
  padding: 20px;
margin-top:80px;

}

.menu {
  display: flex;
  justify-content: center;
}

.menu-item {
  font-size: 24px;
}

.content {
  margin-top: 30px;
  width: 500px;
  margin-left: 430px;
  margin-top:30px
}

.game-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
}

.game-content {
  margin-bottom: 10px;
}

.game-info {
  color: #999;
  font-size: 12px;
}

.loading,
.end {
  text-align: center;
  margin-top: 20px;
  color: #999;
}
</style>
