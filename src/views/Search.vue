<template>
  <div style="width:500px;margin-left: 500px;display: inline-block; ">
    <el-input class="search-box" v-model="searchQuery" placeholder="请输入搜索内容" @mouseover="handleMouseOver"
      @mouseleave="handleMouseLeave"></el-input>
  </div>

  <div style="margin-left:20px; display: inline-block;"><el-button type="primary" @click="loadNextPage"
      style="width:100px">
      <P style="font: 20px;font-weight: bold;">搜索</P>
    </el-button></div>


  <div v-for="result in searchResults" :key="result.id" class="search-result-box">

    <img :src="'https://oneshot-test.oss-cn-guangzhou.aliyuncs.com/' + result.id + '.jpg'" alt="获取的图片" style="
    width:800px;" />

    <div class="search-result">
      <p style="font-weight: bold;font-size: 20px;">{{ result.title }}</p>
      <p>{{ result.content }}</p>
      <p>{{ result.user_name }}</p>
    </div>
  </div>
</template>

<script setup>
import { defineProps, withDefaults, ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

import axios from '../utils/request'
import { resolvedObj } from '../utils/request'



const searchQuery = ref('');
const isHovered = ref(false);
const focusedIndex = ref(null);
const searchResults = ref([]); // 用于存储搜索结果


const imgSrc = ref()
const router = useRouter();

const handleMouseOver = () => {
  isHovered.value = true;
};

const handleMouseLeave = () => {
  isHovered.value = false;
};


onMounted(async () => {

  await loadNextPage();
});



const loadNextPage = async () => {
  try {
    const param = {
      searchContent: searchQuery.value
    }
    const searchData = JSON.stringify(param);
    console.log(1111, searchData)
    const response = await axios.post("http://localhost:8080/search", searchData, {
      headers: {
        'Content-Type': 'application/json',
        'token': localStorage.getItem('token')
      }
    });

    console.log(resolvedObj.value.data)
    console.log(localStorage.getItem('token'))
    searchResults.value = resolvedObj.value.data

  } catch (error) {
    console.error('Error loading image results:', error);
  }
};


</script>

<style scoped>
.search-box {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 300px;
  height: 40px;
  margin: 20px auto;
  transition: all 0.3s ease;
}

.search-box.el-input {
  width: 100%;
}

.search-box.el-input:focus,
.search-box:hover {
  transform: scale(1.05);
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}

.image-results {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  grid-gap: 20px;
  margin: 0 auto;
}

.search-results-container {
  border: 1px solid #ccc;
  padding: 10px;
  margin-top: 20px;
}

.search-result-box {
  margin-bottom: 10px;
  width: 800px;
  margin-left: 390px
}

.search-result {
  border: 1px solid #ccc;
  padding: 10px;
}

.image-item {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 200px;
  background-color: #f0f0f0;
  transition: all 0.3s ease;
}

.image-item.focused {
  transform: scale(1.05);
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}

.image-item img {
  max-width: 100%;
  max-height: 100%;
}
</style>
