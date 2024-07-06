<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="景区名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入景区名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区" prop="district">
        <el-input
          v-model="queryParams.district"
          placeholder="请输入区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-table v-loading="loading" :data="ticket_buyList">
      <el-table-column label="景区ID" align="center" prop="scenicId"/>
      <el-table-column label="景区名称" align="center" prop="name"/>
      <el-table-column label="省" align="center" prop="province"/>
      <el-table-column label="市" align="center" prop="city"/>
      <el-table-column label="区" align="center" prop="district"/>
      <el-table-column label="景区图片" align="center" prop="imageUrl">
        <template slot-scope="scope">
          <img :src="scope.row.imageUrl" alt="景区图片" style="width: 100px; height: auto;"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" icon="el-icon-shopping-cart-2"
                     @click="openDialog(ticketInformation.find(scenic => scenic.scenicId === scope.row.scenicId))">
            购票
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />


    <TicketDialog
      :visible.sync="dialogVisible"
      :scenic="selectedScenic"
      @close="handleClose"
    ></TicketDialog>

  </div>
</template>

<script>
import {listTicket_buy, getTicketInformation} from "@/api/system/ticket_buy";
import TicketDialog from "@/views/system/ticket_buy/TicketDialog.vue";

export default {
  name: "Ticket_buy",
  components: {TicketDialog},
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 购票表格数据
      ticket_buyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        province: null,
        city: null,
        district: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},

      dialogVisible: false,
      selectedScenic: {},
      ticketInformation: [],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 获取门票信息 */
    getList() {
      listTicket_buy(this.queryParams).then(ticketBuyResponse => {
        this.ticket_buyList = ticketBuyResponse.rows;
        this.total = ticketBuyResponse.total;
        return getTicketInformation(); // 返回第二个 Promise
      }).then(ticketInformationResponse => {
        this.ticketInformation = ticketInformationResponse;
        console.log(ticketInformationResponse);
        this.loading = false;
      }).catch(error => {
        console.error("An error occurred:", error);
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        scenicId: null,
        name: null,
        province: null,
        city: null,
        district: null,
        description: null,
        imageUrl: null,
        createTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    openDialog(scenic) {
      this.selectedScenic = scenic;
      this.dialogVisible = true;
    },
    handleClose() {
      this.dialogVisible = false;
    }
  }
};
</script>

