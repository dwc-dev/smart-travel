<template>
  <div>
    <el-table :data="orders" style="width: 100%">
      <el-table-column prop="orderId" label="订单号" align="center"></el-table-column>
      <el-table-column prop="scenicName" label="景区名称" align="center"></el-table-column>
      <el-table-column prop="quantity" label="购票数量" align="center"></el-table-column>
      <el-table-column label="类型" align="center">
        <template slot-scope="scope">
          {{ ticketType(scope.row.type) }}
        </template>
      </el-table-column>
      <el-table-column label="总价" align="center">
        <template slot-scope="scope">
          {{ '￥' + scope.row.totalPrice }}
        </template>
      </el-table-column>
      <el-table-column label="下单时间" align="center">
        <template slot-scope="scope">
          {{ formatDate(scope.row.orderTime) }}
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getOrders"
    />
  </div>
</template>

<script>
import {getOrderInformation} from "@/api/system/customer_ticket_order";

export default {
  data() {
    return {
      total: 0,
      orders: [],
      queryParams: {
        pageNum: 1,
        pageSize: 10,
      },
    };
  },
  methods: {
    getOrders() {
      getOrderInformation(this.queryParams).then(response => {
        this.orders = response.rows;
        this.total = response.total;
      })
    },
    ticketType(type) {
      return type === 0 ? '普通票' : 'VIP票';
    },
    formatDate(timestamp) {
      const date = new Date(timestamp);
      const Y = date.getFullYear() + '-';
      const M = (date.getMonth() + 1).toString().padStart(2, '0') + '-';
      const D = date.getDate().toString().padStart(2, '0') + ' ';
      const h = date.getHours().toString().padStart(2, '0') + ':';
      const m = date.getMinutes().toString().padStart(2, '0') + ':';
      const s = date.getSeconds().toString().padStart(2, '0');
      return Y + M + D + h + m + s;
    }
  },
  created() {
    this.getOrders();
  }
};
</script>
