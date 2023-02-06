<template >
  <v-container>
    <v-card flat @click="cross" class="pa-3 mb-3" :width="width">
        <v-layout row wrap :width="width">
            <v-flex md5 sm4 xs3  v-bind:class="{'text-decoration-line-through': crossed}">
                <div class="caption grey--text">{{task.task.task_title}}</div>
                <div >{{task.task.task_description}}</div>
               
              
            </v-flex>
            <v-flex md5 sm4 xs4>
                <div class="caption grey--text">Task State</div>
                <div>{{ task.task_state.state }}</div>

            </v-flex>
          
           
            <v-flex  class="float-right mt-3">
                <v-btn class="mr-2" elevation="2" small @click="deleteTask(task)"><i class="fa-solid fa-trash"></i></v-btn>
                <EditTask :ModalTitle="editTitle" :taskk="task" :getUpdateTask="getUpdateTask"/>
            </v-flex>
        </v-layout>
    </v-card>
  <v-divider></v-divider>
    
  </v-container>

  </template>
  
  <script>
  import EditTask from './EditTask.vue';
  export default {
    name: 'ToDoItem',
    components:{
        EditTask
    },
    data: () => ({
     crossed: false,
     delete: false,
    editTitle: 'Edit Task',
    task_to_edit: '',
    
     
    }),
    props:{
        task: Object,
        deleteTask: Function,
        updateTask: Function,
        updateTaskState: Function
        
        
    },
    methods:{
        cross(){
            this.crossed= !this.crossed
            //console.log(this.task.task.task_id)
            this.updateTaskState(this.task.task.task_id, this.crossed)
        },
        getUpdateTask(newtitle,newdesc, oldtaskid){
            this.updateTask(newtitle,newdesc,oldtaskid)
        }

      
    },
   
    computed:{
        width(){
            console.log(this.$vuetify.breakpoint.name)
            switch(this.$vuetify.breakpoint.name){

                case 'xl': return 800
                case 'lg': return 800
                case 'md': return 800
                case 'sm': return 500
                case 'xs': return 300
                default: return 0
            }
        }
    }
  };
  </script>
  