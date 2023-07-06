<template>
  <div style="width: 60vw; margin: 5vh auto;">
    <el-input class="search-box" v-model="searchQuery" placeholder="请输入搜索内容" @mouseover="handleMouseOver"
      @mouseleave="handleMouseLeave"></el-input>
    <div class="image-results" ref="imageResults">
      <div class="image-item" v-for="(image, index) in imageResults" :key="index"
        :class="{ 'focused': index === focusedIndex }" @click="navigateToImageDetails(image.filename)">
        <img :src="image.url" alt="Image">
      </div>
    </div>
    <div><el-button @click="loadNextPage">搜索</el-button></div>
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
const imageResults = ref([]);



// // 定义组件的 props
// const props = defineProps({
//   searchQuery: {
//     type: String,

//   }
// });
const router = useRouter();

const handleMouseOver = () => {
  isHovered.value = true;
};

const handleMouseLeave = () => {
  isHovered.value = false;
};

const navigateToImageDetails = (filename) => {
  router.push({ name: 'image-details', params: { filename } });
};

onMounted(async () => {
  // Initial load of image results
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

    console.log(resolvedObj.value)
    console.log(localStorage.getItem('token'))
    const nextPageImages = response.data.images; // Modify according to your API response structure

    imageResults.value.push(...nextPageImages);
  } catch (error) {
    console.error('Error loading image results:', error);
  }
};

const observeScroll = () => {
  const imageResultsEl = document.querySelector('.image-results');
  if (imageResultsEl) {
    const observer = new IntersectionObserver((entries) => {
      if (entries[0].isIntersecting) {
        loadNextPage();
      }
    });
    observer.observe(imageResultsEl);
  }
};

observeScroll();
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
