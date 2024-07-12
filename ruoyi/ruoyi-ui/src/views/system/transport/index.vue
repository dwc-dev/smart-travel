<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="景区ID" prop="scenicId">
        <el-input
          v-model="queryParams.scenicId"
          placeholder="请输入景区ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交通类型" prop="transportType">
        <el-select v-model="queryParams.transportType" placeholder="请选择交通类型" clearable>
          <el-option
            v-for="dict in dict.type.travel_transport_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:transport:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:transport:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:transport:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:transport:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="transportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="交通ID" align="center" prop="transportId" />
      <el-table-column label="景区ID" align="center" prop="scenicId" />
      <el-table-column label="交通类型" align="center" prop="transportType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.travel_transport_type" :value="scope.row.transportType"/>
        </template>
      </el-table-column>
      <el-table-column label="交通信息描述" align="center" prop="routeDescription" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:transport:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:transport:remove']"
          >删除</el-button>
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

    <!-- 添加或修改景区交通信息，存储景区周边交通信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="景区ID" prop="scenicId">
          <el-input v-model="form.scenicId" placeholder="请输入景区ID" />
        </el-form-item>
        <el-form-item label="交通类型" prop="transportType">
          <el-select v-model="form.transportType" placeholder="请选择交通类型">
            <el-option
              v-for="dict in dict.type.travel_transport_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="交通信息描述" prop="routeDescription">
          <el-input v-model="form.routeDescription" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTransport, getTransport, delTransport, addTransport, updateTransport } from "@/api/system/transport";

export default {
  name: "Transport",
  dicts: ['travel_transport_type'],
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
      // 景区交通信息，存储景区周边交通信息表格数据
      transportList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        scenicId: null,
        transportType: null,
        routeDescription: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        scenicId: [
          { required: true, message: "景区ID不能为空", trigger: "blur" }
        ],
        transportType: [
          { required: true, message: "交通类型不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询景区交通信息，存储景区周边交通信息列表 */
    getList() {
      this.loading = true;
      listTransport(this.queryParams).then(response => {
        this.transportList = response.rows;
        this.total = response.total;
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
        transportId: null,
        scenicId: null,
        transportType: null,
        routeDescription: null
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.transportId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加景区交通信息，存储景区周边交通信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const transportId = row.transportId || this.ids
      getTransport(transportId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改景区交通信息，存储景区周边交通信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.transportId != null) {
            updateTransport(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTransport(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const transportIds = row.transportId || this.ids;
      this.$modal.confirm('是否确认删除景区交通信息，存储景区周边交通信息编号为"' + transportIds + '"的数据项？').then(function() {
        return delTransport(transportIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/transport/export', {
        ...this.queryParams
      }, `transport_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
