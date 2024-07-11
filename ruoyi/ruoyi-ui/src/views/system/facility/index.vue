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
      <el-form-item label="设施名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入设施名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设施类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择设施类型" clearable>
          <el-option
            v-for="dict in dict.type.travel_facility_type"
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
          v-hasPermi="['system:facility:add']"
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
          v-hasPermi="['system:facility:edit']"
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
          v-hasPermi="['system:facility:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:facility:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="facilityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="设施ID" align="center" prop="facilityId" />
      <el-table-column label="景区ID" align="center" prop="scenicId" />
      <el-table-column label="设施名称" align="center" prop="name" />
      <el-table-column label="设施类型" align="center" prop="type">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.travel_facility_type" :value="scope.row.type"/>
        </template>
      </el-table-column>
      <el-table-column label="设施描述" align="center" prop="description" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:facility:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:facility:remove']"
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

    <!-- 添加或修改景区设施，存储景区设施对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="景区ID" prop="scenicId">
          <el-input v-model="form.scenicId" placeholder="请输入景区ID" />
        </el-form-item>
        <el-form-item label="设施名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入设施名称" />
        </el-form-item>
        <el-form-item label="设施类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择设施类型">
            <el-option
              v-for="dict in dict.type.travel_facility_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="设施描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
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
import { listFacility, getFacility, delFacility, addFacility, updateFacility } from "@/api/system/facility";

export default {
  name: "Facility",
  dicts: ['travel_facility_type'],
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
      // 景区设施，存储景区设施表格数据
      facilityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        scenicId: null,
        name: null,
        type: null,
        description: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        scenicId: [
          { required: true, message: "景区ID不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "设施名称不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "设施类型不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询景区设施，存储景区设施列表 */
    getList() {
      this.loading = true;
      listFacility(this.queryParams).then(response => {
        this.facilityList = response.rows;
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
        facilityId: null,
        scenicId: null,
        name: null,
        type: null,
        description: null
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
      this.ids = selection.map(item => item.facilityId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加景区设施，存储景区设施";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const facilityId = row.facilityId || this.ids
      getFacility(facilityId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改景区设施，存储景区设施";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.facilityId != null) {
            updateFacility(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFacility(this.form).then(response => {
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
      const facilityIds = row.facilityId || this.ids;
      this.$modal.confirm('是否确认删除景区设施，存储景区设施编号为"' + facilityIds + '"的数据项？').then(function() {
        return delFacility(facilityIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/facility/export', {
        ...this.queryParams
      }, `facility_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
