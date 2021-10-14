<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-input v-model="dataForm.status" placeholder="状态"></el-input>
    </el-form-item>
    <el-form-item label="" prop="username">
      <el-input v-model="dataForm.username" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="password">
      <el-input v-model="dataForm.password" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="修改时间" prop="modifytime">
      <el-input v-model="dataForm.modifytime" placeholder="修改时间"></el-input>
    </el-form-item>
    <el-form-item label="" prop="roleid">
      <el-input v-model="dataForm.roleid" placeholder=""></el-input>
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
          userid: 0,
          name: '',
          email: '',
          status: '',
          username: '',
          password: '',
          modifytime: '',
          roleid: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          username: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          modifytime: [
            { required: true, message: '修改时间不能为空', trigger: 'blur' }
          ],
          roleid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.userid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.userid) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/users/info/${this.dataForm.userid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.users.name
                this.dataForm.email = data.users.email
                this.dataForm.status = data.users.status
                this.dataForm.username = data.users.username
                this.dataForm.password = data.users.password
                this.dataForm.modifytime = data.users.modifytime
                this.dataForm.roleid = data.users.roleid
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
              url: this.$http.adornUrl(`/hospital/users/${!this.dataForm.userid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'userid': this.dataForm.userid || undefined,
                'name': this.dataForm.name,
                'email': this.dataForm.email,
                'status': this.dataForm.status,
                'username': this.dataForm.username,
                'password': this.dataForm.password,
                'modifytime': this.dataForm.modifytime,
                'roleid': this.dataForm.roleid
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
