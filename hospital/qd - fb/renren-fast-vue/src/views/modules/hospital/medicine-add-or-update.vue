<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="图片地址" prop="picture">
      <el-input v-model="dataForm.picture" placeholder="图片地址"></el-input>
    </el-form-item>
    <el-form-item label="进价" prop="inPrice">
      <el-input v-model="dataForm.inPrice" placeholder="进价"></el-input>
    </el-form-item>
    <el-form-item label="售价" prop="salPrice">
      <el-input v-model="dataForm.salPrice" placeholder="售价"></el-input>
    </el-form-item>
    <el-form-item label="药品名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="药品名称"></el-input>
    </el-form-item>
    <el-form-item label="药品类型 0处方1中药2西药" prop="type">
      <el-input v-model="dataForm.type" placeholder="药品类型 0处方1中药2西药"></el-input>
    </el-form-item>
    <el-form-item label="简单描述" prop="descs">
      <el-input v-model="dataForm.descs" placeholder="简单描述"></el-input>
    </el-form-item>
    <el-form-item label="保质期" prop="qualityDate">
      <el-input v-model="dataForm.qualityDate" placeholder="保质期"></el-input>
    </el-form-item>
    <el-form-item label="详细描述" prop="description">
      <el-input v-model="dataForm.description" placeholder="详细描述"></el-input>
    </el-form-item>
    <el-form-item label="生产厂商" prop="produceFirm">
      <el-input v-model="dataForm.produceFirm" placeholder="生产厂商"></el-input>
    </el-form-item>
    <el-form-item label="服用说明" prop="readme">
      <el-input v-model="dataForm.readme" placeholder="服用说明"></el-input>
    </el-form-item>
    <el-form-item label="总的进货量" prop="countAll">
      <el-input v-model="dataForm.countAll" placeholder="总的进货量"></el-input>
    </el-form-item>
    <el-form-item label="剩余量" prop="countSurplus">
      <el-input v-model="dataForm.countSurplus" placeholder="剩余量"></el-input>
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
          mid: 0,
          picture: '',
          inPrice: '',
          salPrice: '',
          name: '',
          type: '',
          descs: '',
          qualityDate: '',
          description: '',
          produceFirm: '',
          readme: '',
          countAll: '',
          countSurplus: '',
          remark: ''
        },
        dataRule: {
          picture: [
            { required: true, message: '图片地址不能为空', trigger: 'blur' }
          ],
          inPrice: [
            { required: true, message: '进价不能为空', trigger: 'blur' }
          ],
          salPrice: [
            { required: true, message: '售价不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '药品名称不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '药品类型 0处方1中药2西药不能为空', trigger: 'blur' }
          ],
          descs: [
            { required: true, message: '简单描述不能为空', trigger: 'blur' }
          ],
          qualityDate: [
            { required: true, message: '保质期不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '详细描述不能为空', trigger: 'blur' }
          ],
          produceFirm: [
            { required: true, message: '生产厂商不能为空', trigger: 'blur' }
          ],
          readme: [
            { required: true, message: '服用说明不能为空', trigger: 'blur' }
          ],
          countAll: [
            { required: true, message: '总的进货量不能为空', trigger: 'blur' }
          ],
          countSurplus: [
            { required: true, message: '剩余量不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.mid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.mid) {
            this.$http({
              url: this.$http.adornUrl(`/hospital/medicine/info/${this.dataForm.mid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.picture = data.medicine.picture
                this.dataForm.inPrice = data.medicine.inPrice
                this.dataForm.salPrice = data.medicine.salPrice
                this.dataForm.name = data.medicine.name
                this.dataForm.type = data.medicine.type
                this.dataForm.descs = data.medicine.descs
                this.dataForm.qualityDate = data.medicine.qualityDate
                this.dataForm.description = data.medicine.description
                this.dataForm.produceFirm = data.medicine.produceFirm
                this.dataForm.readme = data.medicine.readme
                this.dataForm.countAll = data.medicine.countAll
                this.dataForm.countSurplus = data.medicine.countSurplus
                this.dataForm.remark = data.medicine.remark
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
              url: this.$http.adornUrl(`/hospital/medicine/${!this.dataForm.mid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'mid': this.dataForm.mid || undefined,
                'picture': this.dataForm.picture,
                'inPrice': this.dataForm.inPrice,
                'salPrice': this.dataForm.salPrice,
                'name': this.dataForm.name,
                'type': this.dataForm.type,
                'descs': this.dataForm.descs,
                'qualityDate': this.dataForm.qualityDate,
                'description': this.dataForm.description,
                'produceFirm': this.dataForm.produceFirm,
                'readme': this.dataForm.readme,
                'countAll': this.dataForm.countAll,
                'countSurplus': this.dataForm.countSurplus,
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
