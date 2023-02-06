<template>
    
    <v-dialog v-model="dialog" width="500" v-if="!getClosed">
        <template v-slot:activator="{ on, attrs }" >
          <v-btn
            class="success"
            dark
            v-bind="attrs"
            v-on="on"
            elevation="2"
            small
            @click="getToBeUpdatedTask(taskk)"
            @click.stop="dialog = true"
          >
          Edit
          </v-btn>
        </template>
        <v-card>
    <v-card-title class="text-h5 green lighten-2">
      Edit Task
    </v-card-title>

    <v-card-text class="mt-3">
      Enter your task's name and task's description.
      <v-form class="px-3 mt-5" ref="form">
        <v-text-field
          label="Task Title"
          v-model="newtitle"
          :rules="inputRules"
        ></v-text-field>
        <v-textarea
          label="Task Description"
          v-model="newdescription"
          :rules="inputRules"
        ></v-textarea>
        <v-row class="my-4 justify-space-around">
          <v-btn class="success" @click="submit">Edit Task</v-btn>
          <v-btn @click="dialog = false">Close</v-btn>
        </v-row>
      </v-form>
    </v-card-text>

    <v-divider></v-divider>
  </v-card>
   
      </v-dialog>
</template>
<script>
export default {
    name: 'EditTask',

    data() {
        return {
            inputRules: [
            v=> v.length > 0  || 'Please Fill the empty fields.',
        ],
       
        dialog : false
        };
    },

    mounted() {
        
    },

    methods: {
        submit(){
            if(this.$refs.form.validate()){
           var newtitle = this.newtitle
           var newdescription = this.newdescription
           console.log(this.taskk.task_id)
           this.getUpdateTask(newtitle, newdescription, this.taskk.task_id)

        }

        },
        getToBeUpdatedTask(task){
            //this.$router.push('/updateTask/'+ task.task_id)
          // this.task_to_edit = task
          console.log(task)
        },
    },
    props:{
        taskk: Object,
        getUpdateTask: Function

    }
};
</script>>
