<template>
  <div v-loading="loading">
    <div ref="scenicMap" class="map-container"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import {getProvinceTicketCount} from "@/api/system/dataView";

export default {
  name: 'ScenicMap',
  data() {
    return {
      ticketData: [],
      loading: false,
    };
  },
  mounted() {
    this.loading = true;
    window.addEventListener('resize', this.resizeChart);
    getProvinceTicketCount().then(response => {
      this.ticketData = response;
      return this.fetchGeoJson();
    }).then(() => {
      this.loading = false;
    })
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.resizeChart);
  },
  methods: {
    async fetchGeoJson() {
      try {
        const response = await fetch('https://geojson.cn/api/data/china.json');
        const geoJson = await response.json();
        echarts.registerMap('china', geoJson);
        this.initChart();
      } catch (error) {
        throw new Error("获取GeoJson失败");
      }
    },
    initChart() {
      const chart = echarts.init(this.$refs.scenicMap);

      console.log(this.ticketData);

      const option = {
        title: {
          text: '各省景区售票数',
          left: 'center',
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}: {c}',
        },
        visualMap: {
          min: 0,
          max: 100,
          left: 'left',
          top: 'bottom',
          text: ['高', '低'],
          inRange: {
            color: ['#fff5f0', '#fee0d2', '#fcbba1', '#fc9272', '#fb6a4a', '#ef3b2c', '#cb181d', '#a50f15', '#67000d']
          },
          calculable: true,
        },
        series: [
          {
            name: '售票数',
            type: 'map',
            map: 'china',
            roam: true,
            zoom: 1.2, // 初始放大
            label: {
              show: true,
            },
            data: this.ticketData.slice(),
          },
        ],
      };

      chart.setOption(option);
      this.chart = chart;
    },
    resizeChart() {
      if (this.chart) {
        this.chart.resize();
      }
    },
  },
};
</script>

<style scoped>
.map-container {
  width: 100%;
  height: 100vh;
}
</style>


