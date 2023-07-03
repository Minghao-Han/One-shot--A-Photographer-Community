<template>
    <Header />
    <div class="game-container">
        <div class="carousel">
            <el-carousel indicator-position="outside">
                <el-carousel-item v-for="item in 4" :key="item">
                    <h3 text="2xl" justify="center">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </div>
    </div>

    <div class="game-list">
        <GameCard v-for="item in 5" />
    </div>
</template>

<script setup>
import Header from '../components/Header.vue';
import GameCard from '../components/GameCard.vue';
</script>

<style scoped>
.game-container {
    margin-top: 20px auto;
    padding: 20px;
    display: flex;
    justify-content: center;
}

.game-container .carousel {
    display: flex;
    align-items: center;
}

.game-list {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: auto auto;
}
</style>