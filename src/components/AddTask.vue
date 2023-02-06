<template>
   
   <v-dialog
        v-model="dialog"
        width="500"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            class="success mb-5"
            dark
            v-bind="attrs"
            v-on="on"
            @click.stop="dialog = true"

 
          >
           + New Task 
          </v-btn>
        </template>
        <v-card> 
           
           <v-card-title class="text-h5 grey lighten-2" >
             Add Task
           </v-card-title>
   
           <v-card-text class="mt-3">
            
           Enter your task's name and task's description.
           <v-form class="px-3 mt-5" ref="form">
             <v-text-field label="Task Title" v-model="title" :rules="inputRules"></v-text-field>
             <v-textarea label="Task Description" v-model="description" :rules="inputRules"></v-textarea>
            <v-row class="my-4 justify-space-around">
             <v-btn class="success"  @click="submit" >Add Task</v-btn>
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
    name: 'AddTask',
  
    components: {
 
    },
  
    data: () => ({
        title: '' ,
        description: '',
        task_id: '',
        count: 0,
        inputRules: [
            v=> v.length > 0  || 'Please Fill the empty fields.',
            
        ],
        dialog : false
       
     
    }),
   
    methods:{
      submit(){
        
          if(this.$refs.form.validate()){
            var task = {
            task_title: this.title,
            task_description: this.description,
            task_id: this.count
        }
        this.count++
        this.getTask(task)
        this.$refs.form.reset();
        
        }
        
      
      }
       
        
       
      
    },
    
    props:{
        getTask : Function,
        closeModal: Function,
        task: Object,
       
        
       
    }
  }

  </script>
