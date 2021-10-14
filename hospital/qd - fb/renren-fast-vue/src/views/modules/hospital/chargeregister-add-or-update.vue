<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="病人外键" prop="rno">
      <el-input v-model="dataForm.rno" placeholder="病人外键"></el-input>
    </el-form-item>
    <el-form-item label="收费项目表外键" prop="cid">
      <el-input v-model="dataForm.cid" placeholder="收费项目表外键"></el-input>
    </el-form-item>
    <el-form-item label="" prop="chargePrice">
      <el-input v-model="dataForm.chargePrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="chargeDate">
      <el-input v-model="dataForm.chargeDate" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          crId: 0,
          rno: '',
          cid: '',
          chargePrice: '',
          chargeDate: ''
        },
        dataRule: {
          rno: [
            { required: true, message: '病人外键不能为空', trigger: 'blur' }
          ],
          cid: [
            { required: true, message: '收费项目表外键不能为空', trigger: 'blur' }
          ],
          chargePrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          chargeDate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.crId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.crId) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/chargeregister/info/${this.dataForm.crId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.rno = data.chargeRegister.rno
                this.dataForm.cid = data.chargeRegister.cid
                this.dataForm.chargePrice = data.chargeRegister.chargePrice
                this.dataForm.chargeDate = data.chargeRegister.chargeDate
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/chargeregister/${!this.dataForm.crId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'crId': this.dataForm.crId || undefined,
                'rno': this.dataForm.rno,
                'cid': this.dataForm.cid,
                'chargePrice': this.dataForm.chargePrice,
                'chargeDate': this.dataForm.chargeDate
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
