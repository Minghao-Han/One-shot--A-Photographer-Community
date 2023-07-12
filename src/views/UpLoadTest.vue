<template>
  <div>
    <h1>请上传图片：</h1>
    <!-- <form action="/imgtest/upload" method="post" enctype="multipart/form-data">
      <input ref="fileInput1" type="file" name="file" @change="handleFileChange($event, 'fileInput1')">
      <input type="submit" value="上传">
    </form> -->

    <!-- <form action="/imgtest/upimg" method="post" enctype="multipart/form-data">
      <input ref="fileInput2" type="file" name="file" @change="handleFileChange($event, 'fileInput2')">
      <input type="submit" value="上传">
    </form> -->
    <div>
      <input type="text" v-model="title" placeholder="请输入图片的标题" />
      <!-- 假设你有一个input元素，用来输入图片的content -->
      <input type="text" v-model="content" placeholder="请输入图片的内容" />
      <div>
        <p>在下方选择标签:</p>
      </div>

      <div class="tag-container">
        <Tag v-for="tag in countArray" @add-tag="onAddTag" />
      </div>
      <input type="file" @change="handleFileChange">
      <button @click="upLoad">上传</button>
    </div>
  </div>
</template>

<script>
import Header from '../components/Header.vue';
import { reactive, onMounted, ref } from 'vue'
import { ElMenu, ElMenuItem, ElCard, ElMessage } from 'element-plus'
import request from '../utils/request'
import { resolvedObj } from '../utils/request'
import axios from 'axios';

const fileInput1 = ref(null);
const fileInput2 = ref(null);
const config = {
  headers: {
    'Content-Type': 'application/json',
    'token': localStorage.getItem('token')
  }
}



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
      file: null,
      title: "",
      content: "",
      countArray: new Array(1),
      tagArray: new Array(),

    };
  },
  components: {
    ElMenu,
    ElMenuItem,
    ElCard,
  },
  methods: {
    handleFileChange(event) {
      this.file = event.target.files[0];
    },
    onAddTag(tagContent) {
      this.countArray.push(1);
      this.tagArray.push(tagContent);
      console.log("tags:")
      console.log(this.tagArray);
    },
    uploadFile(id) {
      const formData = new FormData();
      formData.append('file', this.file);
      // formData.append('title', this.title);
      // formData.append('content', this.content);

      request.post('/img/upimgshot/' + id, formData,
        {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        })
        .then(response => {
          // 处理上传成功的逻辑
          ElMessage.success("上传成功");
        })
        .catch(error => {
          // 处理上传失败的逻辑
        });
    },
    upLoad() {
      const url = '/shot';
      const param = {
        title: this.title,
        content: this.content,
        tags: this.tagArray
      }

      const data = JSON.stringify(param);
      console.log("发送的shot")
      console.log("data")
      request.post(url, data, config)
        .then(() => {
          console.log(resolvedObj.value.data);
          this.uploadFile(resolvedObj.value.data);

        })

    }
  }
}
</script>



<style scoped>
.tag-container {
  display: flex;
  flex-direction: row;
  padding: 6px;
  padding-left: 0;
  align-items: center;
  justify-content: start;
  margin: 15px;
}
</style>