<template >
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
        persistent
        max-width="600px"
      >
        <template v-slot:activator="{ on,props }">
          <v-btn
            color="primary"
            v-bind="props"
            v-on="on"
          >
            Add New Task
          </v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span class="text-h5">Adding New Task</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-row>
  
                <v-col cols="12">
                  <v-text-field
                    label="Task*"
                    required
                    v-model="Task"
                  ></v-text-field>
                </v-col>
              </v-row>
            </v-container>
            <small>*indicates required field</small>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue-darken-1"
              variant="text"
              @click="dialog = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue-darken-1"
              variant="text"
              @click="dialog = false, callingParentComponentMethod()"
            >
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </template>
  
  <script>
  
    export default {
      data: () => ({
        dialog: false,
        Task:""
      }),
      methods: {  
        // This method will call on click of save button  
        callingParentComponentMethod() {  
        // emit the event and call the parent component  
        this.$emit("setParentComponentDetails",this.Task);  
        }  
     }  
    }
  </script>