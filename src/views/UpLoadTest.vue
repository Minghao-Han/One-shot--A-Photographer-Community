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
   
    <input type="file" @change="handleFileChange">
    <button @click="uploadFile">上传</button>
  </div>
  </div>
</template>

<script>
import Header from '../components/Header.Vue';
import { reactive, onMounted,ref } from 'vue'
import { ElMenu, ElMenuItem, ElCard } from 'element-plus'
import axios  from '../utils/request'
import { resolvedObj } from '../utils/request'

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
  }}
</script>

<style>

</style>