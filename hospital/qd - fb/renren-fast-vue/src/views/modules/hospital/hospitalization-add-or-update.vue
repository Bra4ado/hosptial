<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="挂号信息外键" prop="rno">
      <el-input v-model="dataForm.rno" placeholder="挂号信息外键"></el-input>
    </el-form-item>
    <el-form-item label="床号" prop="bedNo">
      <el-input v-model="dataForm.bedNo" placeholder="床号"></el-input>
    </el-form-item>
    <el-form-item label="押金" prop="deposit">
      <el-input v-model="dataForm.deposit" placeholder="押金"></el-input>
    </el-form-item>
    <el-form-item label="病情描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="病情描述"></el-input>
    </el-form-item>
    <el-form-item label="入院时间" prop="inDate">
      <el-input v-model="dataForm.inDate" placeholder="入院时间"></el-input>
    </el-form-item>
    <el-form-item label="护理" prop="protect">
      <el-input v-model="dataForm.protect" placeholder="护理"></el-input>
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
          hid: 0,
          rno: '',
          bedNo: '',
          deposit: '',
          description: '',
          inDate: '',
          protect: ''
        },
        dataRule: {
          rno: [
            { required: true, message: '挂号信息外键不能为空', trigger: 'blur' }
          ],
          bedNo: [
            { required: true, message: '床号不能为空', trigger: 'blur' }
          ],
          deposit: [
            { required: true, message: '押金不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '病情描述不能为空', trigger: 'blur' }
          ],
          inDate: [
            { required: true, message: '入院时间不能为空', trigger: 'blur' }
          ],
          protect: [
            { required: true, message: '护理不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.hid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.hid) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/hospitalization/info/${this.dataForm.hid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.rno = data.hospitalization.rno
                this.dataForm.bedNo = data.hospitalization.bedNo
                this.dataForm.deposit = data.hospitalization.deposit
                this.dataForm.description = data.hospitalization.description
                this.dataForm.inDate = data.hospitalization.inDate
                this.dataForm.protect = data.hospitalization.protect
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
              url: this.$http.adornUrl(`/hospital/hospitalization/${!this.dataForm.hid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'hid': this.dataForm.hid || undefined,
                'rno': this.dataForm.rno,
                'bedNo': this.dataForm.bedNo,
                'deposit': this.dataForm.deposit,
                'description': this.dataForm.description,
                'inDate': this.dataForm.inDate,
                'protect': this.dataForm.protect
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
