<template>
  <div id="example">
    <div class="w-100 p-2" style="background-color: rgba(0, 0, 0, 0.03)">
      Browser
      <b-badge pill variant="light" @click="showModal">Add Server</b-badge>
    </div>

    <v-jstree :data="data"
              :item-events="itemEvents"
              allow-batch
              ref="tree">
    </v-jstree>

    <!--서버 등록 modal-->
    <b-modal ref="myModalRef" id="modal-center" centered title="Create Server" @ok="addServer">
      <b-card no-body style="font-size: small">
        <b-tabs card >
          <b-tab title="General" active>
            <General v-on:updateForm="setUpdateGeneralData"></General>
          </b-tab>
          <b-tab title="Connection" >
            <Connection v-on:updateForm="setUpdateConnectionData"></Connection>
          </b-tab>
          <b-tab title="SSL">
            <SSL></SSL>
          </b-tab>
          <b-tab title="Advanced">
            <Advanced></Advanced>
          </b-tab>
        </b-tabs>
      </b-card>
    </b-modal>
  </div>
</template>

<script>
  import General from './modal/General'
  import Connection from './modal/Connection'
  import SSL from './modal/SSL'
  import Advanced from './modal/Advanced'
  import VJstree from 'vue-jstree'
  import axios from 'axios'

  export default {
    el: '#example',
    name: 'app',
    components: {
      Advanced,
      SSL,
      Connection,
      General,
      VJstree
    },
    data() {
      return {
        data: [{
          "text": "Server",
          "children": [
            {
              "text": "OracleSql"
            },
            {
              "text": "MS Sql"
            },
            {
              "text": "MySql",
              "opened": true,
              "children": [
                {
                  "text": "Databases",
                  "children": [
                    {
                      "text": "wdtdb"
                    },
                    {
                      "text": "wdttestdb"
                    },
                    {
                      "text": "wdtpsqldb"
                    }
                  ]
                }
              ]
            }
          ]
        }],
        updateFormData: {
          name : '',
          serverGroup: '',
          comments: '',
          hostname: '',
          port: '',
          maintenanceDb: '',
          userName: '',
          userPassword: '',
          savePassword: '',
          serverRole: '',
          serverService: ''
        }
      }
    },
    methods: {
      showModal () {
        this.$refs.myModalRef.show()
      },
      addServer: function () {
        const vm = this
        axios.post('http://localhost:3000/api/addServer',{
          serverName : this.updateFormData.name,
          serverGroup : this.updateFormData.serverGroup,
          comments : this.updateFormData.comments
        }).then(function(response) {
            vm.dash = response.data;
          });
      },
      setUpdateGeneralData: function (text) {
        this.updateFormData.comments = text.comments
        this.updateFormData.name = text.name
        this.updateFormData.serverGroup = text.serverGroup
      },
      setUpdateConnectionData: function(text) {
        this.updateFormData.hostname = text.hostname
        this.updateFormData.port = text.port
        this.updateFormData.maintenanceDb = text.maintenanceDb
        this.updateFormData.userName = text.userName
        this.updateFormData.userPassword = text.userPassword
        this.updateFormData.savePassword = text.savePassword
        this.updateFormData.serviceRole = text.serviceRole
        this.updateFormData.serverRole = text.serverRole
      }
    }
  }
</script>

<style scoped>

</style>
