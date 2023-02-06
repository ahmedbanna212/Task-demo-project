<template>
  <v-container>
    <v-row class='justify-center my-4'>
      <h2>To Do List</h2>
    </v-row>
    <v-row class="justify-center my-2">

   
      <AddTask  :getTask="AddTask" :closeModal="isClosed" />
    </v-row>
    <v-row  class="align-center my-2 flex-column">
      
      <div v-for="task in allTasks" :key="task.task_id">
       <ToDoItem :crossed="crossed" :task="task" :deleteTask="deleteTask" :updateTask="updateTask" :updateTaskState="updateTaskState"/>
        </div>
    
    </v-row>
  </v-container>
</template>

<script>
import AddTask from './AddTask.vue';
import ToDoItem from './ToDoItem.vue';

  export default {
    name: 'ToDoList',

    components: {
    AddTask,
    ToDoItem
},
    data: () => ({
     allTasks:[],
     closedModal: false,
     showModal: true,
     
    
    }),
    props:{
      crossed: Boolean
    },
    methods:{
      AddTask(taskObject){
        this.allTasks.push(taskObject)
       console.log(taskObject)
      
      },

      deleteTask(task){
        let taskExists = this.allTasks.find((id)=> id.task.task_id == task.task_id)
        if(taskExists){
          this.allTasks = this.allTasks.filter((task)=> task != taskExists)
          alert('Task is successfully deleted.')
        }
        
      },
      updateTask(newtitle,newdesc,oldtaskid){
        let taskExists = this.allTasks.find((task)=> task.task.task_id == oldtaskid)
        console.log(taskExists)
        
        if(taskExists){
          this.allTasks = this.allTasks.map((task)=> task.task.task_id === taskExists.task.task_id? {...task, task:{task_title: newtitle, task_description: newdesc}}: task)
        }
       
      },
      updateTaskState(taskid, crossed){
        if(crossed == true){
          this.allTasks = this.allTasks.map((task)=> task.task.task_id == taskid? {...task, task_state:{state: 'Done'}}: task )
        }
        else if(crossed == false){
          this.allTasks = this.allTasks.map((task)=> task.task.task_id == taskid? {...task, task_state:{state: 'In Progress'}}: task )
        }
      }
     
    }
  }
</script>
