<template>
  <div v-loading="loading">
    <div style="display: flex;justify-content: center;">
      <el-button @click="filterTickets('normal')">查看普通票</el-button>
      <el-button @click="filterTickets('vip')">查看VIP票</el-button>
      <el-button @click="filterTickets('all')">查看全部票</el-button>
    </div>
    <div ref="chart" style="width: 100%; height: 650px;"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import {getTicketInformation} from "@/api/system/ticket_buy";

export default {
  name: 'ScenicChart',
  data() {
    return {
      scenicData: [],
      filteredData: [],
      filterType: 'all',
      chartInstance: null,
      loading: false,
    };
  },
  mounted() {
    this.$nextTick(() => {
      this.loading = true;
      getTicketInformation().then(res => {
        // 创建一个浅拷贝数组来存储景区数据
        const scenicArray = res.slice();
        // 对新数组进行排序
        scenicArray.sort((a, b) => a.scenicId - b.scenicId);
        console.table(scenicArray);
        this.scenicData = scenicArray;
        this.filteredData = this.scenicData;
        this.renderChart();
      }).finally(() => {
        this.loading = false; // 数据加载完成
      });
    });
  },
  methods: {
    filterTickets(type) {
      this.filterType = type;
      if (type === 'normal') {
        this.filteredData = this.scenicData.map(scenic => ({
          ...scenic,
          tickets: scenic.tickets.filter(ticket => ticket.type === 0)
        })).filter(scenic => scenic.tickets.length > 0)
          .sort((a, b) => b.tickets[0].price - a.tickets[0].price);
      } else if (type === 'vip') {
        this.filteredData = this.scenicData.map(scenic => ({
          ...scenic,
          tickets: scenic.tickets.filter(ticket => ticket.type === 1)
        })).filter(scenic => scenic.tickets.length > 0)
          .sort((a, b) => b.tickets[0].price - a.tickets[0].price);
      } else {
        this.filteredData = this.scenicData;
      }
      this.renderChart();
    },
    renderChart() {
      if (this.chartInstance) {
        this.chartInstance.dispose();
      }
      this.chartInstance = echarts.init(this.$refs.chart);
      const option = {
        title: {
          text: '景区门票数据分析',
          left: 'center',
          top: '5%'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['普通票数量', 'VIP票数量', '普通票价格', 'VIP票价格'],
          top: '10%'
        },
        grid: {
          top: '20%',
          bottom: '15%'
        },
        xAxis: {
          type: 'category',
          data: this.filteredData.map(scenic => scenic.name),
          axisLabel: {
            interval: 0,
            rotate: 45
          }
        },
        yAxis: {
          type: 'value'
        },
        series: this.getSeriesData()
      };
      this.chartInstance.setOption(option);
    },
    getSeriesData() {
      const seriesData = [];
      if (this.filterType === 'normal' || this.filterType === 'all') {
        seriesData.push({
          name: '普通票数量',
          type: 'bar',
          data: this.filteredData.map(scenic => {
            const normalTicket = scenic.tickets.find(ticket => ticket.type === 0);
            return normalTicket ? normalTicket.quantity : 0;
          })
        });
        seriesData.push({
          name: '普通票价格',
          type: 'line',
          data: this.filteredData.map(scenic => {
            const normalTicket = scenic.tickets.find(ticket => ticket.type === 0);
            return normalTicket ? normalTicket.price : 0;
          })
        });
      }
      if (this.filterType === 'vip' || this.filterType === 'all') {
        seriesData.push({
          name: 'VIP票数量',
          type: 'bar',
          data: this.filteredData.map(scenic => {
            const vipTicket = scenic.tickets.find(ticket => ticket.type === 1);
            return vipTicket ? vipTicket.quantity : 0;
          })
        });
        seriesData.push({
          name: 'VIP票价格',
          type: 'line',
          data: this.filteredData.map(scenic => {
            const vipTicket = scenic.tickets.find(ticket => ticket.type === 1);
            return vipTicket ? vipTicket.price : 0;
          })
        });
      }
      return seriesData;
    }
  }
};
</script>

<style scoped>
button {
  margin: 5px;
}
</style>
