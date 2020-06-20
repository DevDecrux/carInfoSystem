<template>
  <div v-for="codeData in codesData">
    <a>{{codeData.code}} - desc: {{codeData.descCode}}</a>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "CodesInfo",
    data() {
      return {
        codesData: []
      }
    },
    methods: {
      loadCodesData () {
        axios.get('http://localhost:8080/car-info-core/api-ui/get-codes-info')
          .then(response => {
            // JSON responses are automatically parsed.
            this.codesData = response.data
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    },
    mounted() {
      this.loadCodesData();
    }
  }
</script>

<style scoped>

</style>
