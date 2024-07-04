<template>
  <div class="travel-home">
    <div class="intro">
      <h1>智慧文旅平台</h1>
      <h2>带你探索全新的文化和旅游体验</h2>
    </div>
    <el-carousel trigger="hover" height="700px">
      <el-carousel-item v-for="(img, index) in images" :key="index">
        <img :src="require(`@/assets/travel/${img}`)" class="carousel-img"/>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'TravelHome',
  data() {
    return {
      images: ['img1.jpg', 'img2.jpg', 'img3.jpg', 'img4.jpg', 'img5.jpg']
    };
  }
};
</script>

<style scoped>
.travel-home {
  text-align: center;
}

.carousel-img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.intro {
  margin-top: 20px;
}

.intro h1 {
  font-size: 36px;
  margin-bottom: 10px;
}

.intro h2 {
  font-size: 24px;
  color: #888;
}
</style>
