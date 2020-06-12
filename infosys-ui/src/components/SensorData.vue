<template>
  <div id='app'>

    <vue-good-table
    ref="customTable"
      :columns='columns'
      :rows='rows'
      :sort-options="{
    enabled: true,
    initialSortBy: {field: 'Date', type: 'desc'}
  }"
    ></vue-good-table>
  </div>
</template>

<script>

import 'vue-good-table/dist/vue-good-table.css'
import { VueGoodTable } from 'vue-good-table'
import axios from 'axios'

export default {
  name: 'sensorData',
  components: { VueGoodTable },
  props: {},
  data () {
    return {
      posts: [],
      errors: [],
      columns: [
        {
          label: 'Temperature',
          field: 'Temp'
        },
        {
          label: 'Humidity',
          field: 'Humidity'
        },
        {
          label: 'eCO2',
          field: 'eCO2'
        },
        {
          label: 'TVOC',
          field: 'TVOC'
        },
        {
          label: 'Date',
          field: 'Date',
          type: 'date',
          dateInputFormat: 'yyyy-MM-dd',
          dateOutputFormat: 'MMM dd yyyy'
        },
        {
          label: 'Hours',
          field: 'Hours'
        }
      ],
      rows: []
    }
  },
  methods: {
    addRow (rowArray) {
      rowArray = rowArray.concat(this.$refs.customTable.rows)
      rowArray.sort(function (a, b) {
        var keyA = new Date(a.Date)
        var keyB = new Date(b.Date)
        // Compare the 2 dates
        if (keyA < keyB) return -1
        if (keyA > keyB) return 1
        return 0
      })
      this.$refs.customTable.rows = rowArray
    },
    setTableData (rowsArray) {
      rowsArray.sort(function (a, b) {
        var keyA = new Date(a.Date)
        var keyB = new Date(b.Date)
        // Compare the 2 dates
        if (keyA < keyB) return -1
        if (keyA > keyB) return 1
        return 0
      })
      this.$refs.customTable.rows = rowsArray
    },
    removeRow (index) {
      this.$refs.customTable.rows.splice(index, 1)
    },
    loadDbData () {
      axios.get('http://localhost:8080/car-info-core/api-ui/get-meteo-info')
        .then(response => {
        // JSON responses are automatically parsed.
          this.setTableData(response.data)
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  },
  computed: {
    getLatestTemp: function () {
      var currTemp = null
      var currDate = null
      for (let i = 0; i < this.$refs.customTable.rows.length; i++) {
        var newTemp = parseInt(this.$refs.customTable.rows[i].Temp)
        var newDate = this.$refs.customTable.rows[i].Date
        if (currDate == null || currDate < newDate) {
          currDate = newDate
          currTemp = newTemp
        }
      }
      return currTemp || 0
    }
  },
  created () {
    this.loadDbData()
  }
}
</script>
