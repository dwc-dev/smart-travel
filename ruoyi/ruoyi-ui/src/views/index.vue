<template>
  <div class="travel-home">
    <div class="intro">
      <h1>智慧文旅平台</h1>
      <h2>带你探索全新的文化和旅游体验</h2>
    </div>
    <el-carousel trigger="hover" height="90vh" indicator-position="none">
      <el-carousel-item v-for="(item, index) in bannerItems" :key="index">
        <div class="carousel-content">
          <div class="carousel-item">
            <img :src="require(`@/assets/travel/${item.image}`)" class="carousel-img"/>
            <div class="banner-text">
              <h1>{{ item.title }}</h1>
              <p>{{ item.description }}</p>
            </div>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'TravelHome',
  data() {
    return {
      bannerItems: [
        {
          image: 'img1.jpg',
          title: '探索有故事价值的旅行时刻',
          description: '体验充满故事的中国历史文化'
        },
        {
          image: 'img2.jpg',
          title: '探索有故事价值的旅行时刻',
          description: '走遍中国大江南北'
        },
        {
          image: 'img3.jpg',
          title: '探索有故事价值的旅行时刻',
          description: '游览美丽的中国山水'
        },
        {
          image: 'img4.jpg',
          title: '探索有故事价值的旅行时刻',
          description: '体验中国风土人情'
        },
        {
          image: 'img5.jpg',
          title: '练习时长两年半',
          description: '鸡你太美~~baby~~'
        }
      ]
    };
  }
};
</script>

<style scoped>
.travel-home {
  text-align: center;
}

.carousel-content {
  display: flex;
  flex-direction: column;
  height: 90vh;
}

.carousel-item {
  position: relative;
  flex: 1;
}

.carousel-img {
  width: 100%;
  height: 90vh;
  object-fit: cover;
}

.intro {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
  z-index: 10;
}

.intro h1 {
  font-size: 36px;
  margin-bottom: 10px;
  font-family: "Microsoft YaHei";
}

.intro h2 {
  font-size: 24px;
  color: white;
  font-family: "Microsoft YaHei";
}

.banner-text {
  position: absolute;
  bottom: 20px;
  left: 20px;
  right: 20px;
  background-color: rgba(0, 0, 0, 0.5);
  color: #fff;
  padding: 20px;
  border-radius: 10px;
}

.banner-text h1 {
  font-size: 24px;
  margin-bottom: 10px;
}

.banner-text p {
  font-size: 16px;
}
</style>
