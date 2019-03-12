<template>
    <div>
      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="2"><label for="input-small">Name:</label></b-col>
          <b-col sm="10">
            <b-form-input v-model="name" id="input-small" size="sm" type="text" placeholder="Enter name" @input="updateFormValue"></b-form-input>
          </b-col>
        </b-row>
      </b-container>

      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="2"><label for="input-small">Server Group:</label></b-col>
          <b-col sm="10">
            <b-form-select v-model="serverGroup" :options="options" size="sm" class="mb-3" @input="updateFormValue">
              <template slot="first">
                <!-- this slot appears above the options from 'options' prop -->
                <option :value="1">Servers</option>
              </template>
              <!-- these options will appear after the ones from 'options' prop -->
              <option value="2">Option C</option>
              <option value="3">Option D</option>
            </b-form-select>
          </b-col>
        </b-row>
      </b-container>

      <b-container fluid>
        <b-row class="my-1">
          <b-col sm="2"><label for="input-small">Comments:</label></b-col>
          <b-col sm="10">
            <b-form-textarea
              id="textarea1"
              v-model="comments"
              placeholder="Enter something"
              :rows="3"
              :max-rows="6"
              @input="updateFormValue">
            </b-form-textarea>
          </b-col>
        </b-row>
      </b-container>
    </div>
</template>

<script type="text/javascript">

  export default {
    name: "General",
    data: function() {
      return {
        updateFormData : {
          name :'',
          serverGroup : '',
          comments: ''
        }
      }
    },
    methods: {
      updateFormValue: function () {
        this.updateFormData.name = this.name
        this.updateFormData.serverGroup = this.serverGroup
        this.updateFormData.comments = this.comments
        this.$emit('updateForm', this.updateFormData)
      }
    }
  }
</script>

<style scoped>

</style>
