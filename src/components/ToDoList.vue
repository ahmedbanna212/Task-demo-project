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
       <ToDoItem :task="task" :deleteTask="deleteTask" :updateTask="updateTask"/>
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
    methods:{
      AddTask(task){
        this.allTasks.push(task)
      
      },

      isClosed(){
        this.closedModal = true
      },
      deleteTask(task){
        let taskExists = this.allTasks.find((id)=> id.task_id == task.task_id)
        if(taskExists){
          this.allTasks = this.allTasks.filter((task)=> task != taskExists)
          alert('Task is successfully deleted.')
        }
        
      },
      updateTask(newtitle,newdesc,oldtaskid){
        let taskExists = this.allTasks.find((task)=> task.task_id == oldtaskid)
        if(taskExists){
          this.allTasks = this.allTasks.map((task)=> task.task_id === taskExists.task_id? {...task, task_title: newtitle, task_description: newdesc}: task)
        }
       
      }
     
    }
  }
</script>
