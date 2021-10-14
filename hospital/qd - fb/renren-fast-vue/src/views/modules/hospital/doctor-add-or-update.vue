<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="证件号" prop="cardNo">
      <el-input v-model="dataForm.cardNo" placeholder="证件号"></el-input>
    </el-form-item>
    <el-form-item label="手机" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="手机"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="age">
      <el-input v-model="dataForm.age" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="出生日期" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="出生日期"></el-input>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="dataForm.email" placeholder="电子邮箱"></el-input>
    </el-form-item>
    <el-form-item label="科室" prop="department">
      <el-input v-model="dataForm.department" placeholder="科室"></el-input>
    </el-form-item>
    <el-form-item label="学历" prop="education">
      <el-input v-model="dataForm.education" placeholder="学历"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
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
          did: 0,
          name: '',
          cardNo: '',
          phone: '',
          sex: '',
          age: '',
          birthday: '',
          email: '',
          department: '',
          education: '',
          remark: ''
        },
        dataRule: {
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          cardNo: [
            { required: true, message: '证件号不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '手机不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '出生日期不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '电子邮箱不能为空', trigger: 'blur' }
          ],
          department: [
            { required: true, message: '科室不能为空', trigger: 'blur' }
          ],
          education: [
            { required: true, message: '学历不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.did = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.did) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/doctor/info/${this.dataForm.did}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.doctor.name
                this.dataForm.cardNo = data.doctor.cardNo
                this.dataForm.phone = data.doctor.phone
                this.dataForm.sex = data.doctor.sex
                this.dataForm.age = data.doctor.age
                this.dataForm.birthday = data.doctor.birthday
                this.dataForm.email = data.doctor.email
                this.dataForm.department = data.doctor.department
                this.dataForm.education = data.doctor.education
                this.dataForm.remark = data.doctor.remark
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
              url: this.$http.adornUrl(`/hospital/doctor/${!this.dataForm.did ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'did': this.dataForm.did || undefined,
                'name': this.dataForm.name,
                'cardNo': this.dataForm.cardNo,
                'phone': this.dataForm.phone,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'birthday': this.dataForm.birthday,
                'email': this.dataForm.email,
                'department': this.dataForm.department,
                'education': this.dataForm.education,
                'remark': this.dataForm.remark
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
