<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="身份证号" prop="idCard">
      <el-input v-model="dataForm.idCard" placeholder="身份证号"></el-input>
    </el-form-item>
    <el-form-item label="社保号" prop="siNumber">
      <el-input v-model="dataForm.siNumber" placeholder="社保号"></el-input>
    </el-form-item>
    <el-form-item label="挂号费用" prop="registerMoney">
      <el-input v-model="dataForm.registerMoney" placeholder="挂号费用"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="联系电话"></el-input>
    </el-form-item>
    <el-form-item label="是否自费" prop="isPay">
      <el-input v-model="dataForm.isPay" placeholder="是否自费"></el-input>
    </el-form-item>
    <el-form-item label="" prop="sex">
      <el-input v-model="dataForm.sex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="age">
      <el-input v-model="dataForm.age" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="job">
      <el-input v-model="dataForm.job" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="初复诊" prop="consultation">
      <el-input v-model="dataForm.consultation" placeholder="初复诊"></el-input>
    </el-form-item>
    <el-form-item label="科室" prop="department">
      <el-input v-model="dataForm.department" placeholder="科室"></el-input>
    </el-form-item>
    <el-form-item label="医生外键" prop="did">
      <el-input v-model="dataForm.did" placeholder="医生外键"></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="remark">
      <el-input v-model="dataForm.remark" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="registerDate">
      <el-input v-model="dataForm.registerDate" placeholder=""></el-input>
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
          rno: 0,
          name: '',
          idCard: '',
          siNumber: '',
          registerMoney: '',
          phone: '',
          isPay: '',
          sex: '',
          age: '',
          job: '',
          consultation: '',
          department: '',
          did: '',
          status: '',
          remark: '',
          registerDate: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          idCard: [
            { required: true, message: '身份证号不能为空', trigger: 'blur' }
          ],
          siNumber: [
            { required: true, message: '社保号不能为空', trigger: 'blur' }
          ],
          registerMoney: [
            { required: true, message: '挂号费用不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' }
          ],
          isPay: [
            { required: true, message: '是否自费不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          job: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          consultation: [
            { required: true, message: '初复诊不能为空', trigger: 'blur' }
          ],
          department: [
            { required: true, message: '科室不能为空', trigger: 'blur' }
          ],
          did: [
            { required: true, message: '医生外键不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          registerDate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.rno = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.rno) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/register/info/${this.dataForm.rno}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.register.name
                this.dataForm.idCard = data.register.idCard
                this.dataForm.siNumber = data.register.siNumber
                this.dataForm.registerMoney = data.register.registerMoney
                this.dataForm.phone = data.register.phone
                this.dataForm.isPay = data.register.isPay
                this.dataForm.sex = data.register.sex
                this.dataForm.age = data.register.age
                this.dataForm.job = data.register.job
                this.dataForm.consultation = data.register.consultation
                this.dataForm.department = data.register.department
                this.dataForm.did = data.register.did
                this.dataForm.status = data.register.status
                this.dataForm.remark = data.register.remark
                this.dataForm.registerDate = data.register.registerDate
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
              url: this.$http.adornUrl(`/hospital/register/${!this.dataForm.rno ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'rno': this.dataForm.rno || undefined,
                'name': this.dataForm.name,
                'idCard': this.dataForm.idCard,
                'siNumber': this.dataForm.siNumber,
                'registerMoney': this.dataForm.registerMoney,
                'phone': this.dataForm.phone,
                'isPay': this.dataForm.isPay,
                'sex': this.dataForm.sex,
                'age': this.dataForm.age,
                'job': this.dataForm.job,
                'consultation': this.dataForm.consultation,
                'department': this.dataForm.department,
                'did': this.dataForm.did,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark,
                'registerDate': this.dataForm.registerDate
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
