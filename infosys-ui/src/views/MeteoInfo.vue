<template>
  <!-- Main content -->
  <div>
     <div>
        <button v-on:click="refreshData">Refresh data</button>
    </div>
    <div>
    <TempGauge ref='tempGauge'></TempGauge>
    </div>
    <br>
    <div>
        <button v-on:click="addRow">Add a random row</button>
    </div>
    <br>
    <div>
      <SensorData ref='sensorTable'></SensorData>
    </div>
  </div>
  <!-- /.content -->
</template>

<script>
// @ is an alias to /src
import SensorData from '@/components/SensorData.vue'
import TempGauge from '@/components/TempGauge.vue'

export default {
  name: 'MeteoInfo',
  components: {
    SensorData, TempGauge
  },
  methods: {
    addRow () {
      var rowArray = [{ Temp: (Math.random() * 100).toFixed(0) + 'C', Humidity: '13 humidity', eCO2: 'eCO2 value5', TVOC: 'TVOC value5', Date: '2020-06-' + ((Math.random() * 29 + 1).toFixed(0)), Hours: '09:22:49' }]

      this.$refs.sensorTable.addRow(rowArray)
    },
    refreshData () {
      this.$refs.sensorTable.loadDbData()
      this.changeTemp()
    },
    removeThirdRow () {
      this.$refs.sensorTable.removeRow(2)
    },
    getLatestTemp () {
      return this.$refs.sensorTable.getLatestTemp
    },
    changeTemp () {
      this.$refs.tempGauge.refreshDataValue(parseInt(this.$refs.sensorTable.getLatestTemp))
    }
  },
  mounted () {
    this.refreshData()
    setInterval(
      function () {
        this.refreshData()
      }.bind(this),
      5000
    )
  }
}
</script>
