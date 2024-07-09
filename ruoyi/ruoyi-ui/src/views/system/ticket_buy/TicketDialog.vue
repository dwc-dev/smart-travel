<template>
  <el-dialog :visible.sync="visible" :title="currentScenic.name" @close="handleClose" width="400px" center>
    <el-form :model="form" label-width="80px" class="ticket-form">
      <el-form-item label="选择门票">
        <el-select v-model="form.selectedTicket" placeholder="请选择门票" style="width: 100%">
          <el-option
            v-for="ticket in currentScenic.tickets"
            :key="ticket.ticketId"
            :label="`${ticket.type === 0 ? '普通票' : 'VIP票'} - 价格: ￥${ticket.price} - 剩余: ${ticket.quantity}张`"
            :value="ticket.ticketId"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="购买数量">
        <el-input-number v-model="form.quantity" :min="1" :max="form.selectedTicket ? getSelectedTicket().quantity : 1"
                         style="width: 100%"></el-input-number>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="handleCancel">取消</el-button>
      <el-button type="primary" @click="submitOrder">确认购票</el-button>
    </div>
  </el-dialog>
</template>

<script>
import {buyTicket} from "@/api/system/ticket_buy";
export default {
  props: {
    visible: {
      type: Boolean,
      default: false
    },
    scenic: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      currentScenic: {},
      form: {
        selectedTicket: null,
        quantity: 1
      },
      orderData: {}
    };
  },
  watch: {
    visible(val) {
      if (val) {
        this.currentScenic = this.scenic;
      }
    }
  },
  methods: {
    resetForm() {
      this.form.selectedTicket = null;
      this.form.quantity = 1;
    },
    handleCancel() {
      this.$emit('close');
      this.resetForm();
    },
    handleClose() {
      this.$emit('close');
      this.resetForm();
    },
    getSelectedTicket() {
      return this.currentScenic.tickets.find(ticket => ticket.ticketId === this.form.selectedTicket);
    },
    submitOrder() {
      if (!this.form.selectedTicket) {
        this.$message.error('请选择门票');
        return;
      }
      const selectedTicket = this.getSelectedTicket();
      if (!selectedTicket) {
        this.$message.error('所选门票无效');
        return;
      }
      this.orderData = {
        scenicId: this.currentScenic.scenicId,
        ticketId: selectedTicket.ticketId,
        quantity: this.form.quantity
      };
      buyTicket(this.orderData);
      this.$message.success('购票成功');
      this.$emit('close');
      this.resetForm();
    }
  }
};
</script>

<style scoped>
.ticket-form {
  margin-top: 20px;
}

.dialog-footer {
  text-align: right;
}
</style>
