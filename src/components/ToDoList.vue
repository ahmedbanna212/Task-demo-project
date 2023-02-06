<template>
    <div class="container" style="max-width: 600px">
    \
      <h2 class="text-center mt-5">ToDo List App</h2>
  
      
      <div class="d-flex mt-5">
        <AddTaskModal @setParentComponentDetails="setDetailsForComponent" />
      </div>
  
      
      <table class="table table-bordered mt-5">
        <thead>
          <tr>
            <th scope="col">Task</th>
            <th scope="col" style="width: 120px">Status</th>
            <th scope="col" class="text-center">Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(task, index) in tasks" :key="index">
            <td>
              <span :class="{ 'line-through': task.status === 'finished' }">
                {{ task.name }}
              </span>
            </td>
            <td>
              <span
                class="pointer noselect"
                @click="changeStatus(index)"
                :class="{
                  'text-danger': task.status === 'to-do',
                  'text-success': task.status === 'finished',
                  'text-warning': task.status === 'in-progress',
                }"
              >
                {{ capitalizeFirstChar(task.status) }}
              </span>
            </td>
            <td class="text-center">
              <div @click="deleteTask(index)">
                <span class="fa fa-trash pointer"></span>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import AddTaskModal from './AddTask.vue';
  
  export default {
    components: { AddTaskModal },
    name: "HelloWorld",
    props: {
      msg: String,
    },
  
    data() {
      return {
        task: "",
        statuses: ["to-do", "in-progress", "finished"],
  
        
        tasks: [
          {
            name: "Buy bananas from the supermarket.",
            status: "to-do",
          },
          {
            name: "Eat 1 kg chocolate in 1 hour.",
            status: "in-progress",
          },
          {
            name: "Create YouTube video.",
            status: "finished",
          },
        ],
      };
    },
  
    methods: {
      setDetailsForComponent(param) {  
        this.task = param;
        this.submitTask();  
        },
      
      capitalizeFirstChar(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
      },
  
     
      changeStatus(index) {
        let newIndex = this.statuses.indexOf(this.tasks[index].status);
        if (++newIndex > 2) newIndex = 0;
        this.tasks[index].status = this.statuses[newIndex];
      },
  
      
      deleteTask(index) {
        this.tasks.splice(index, 1);
      },
  
      
      submitTask() {
        if (this.task.length === 0) return;
  
        else {
         
          this.tasks.push({
            name: this.task,
            status: this.statuses[0],
          });
        }
  
        this.task = "";
      },
    },
  };
  </script>
  
  <style scoped>
  .pointer {
    cursor: pointer;
  }
  .noselect {
    -webkit-touch-callout: none; /* iOS Safari */
    -webkit-user-select: none; /* Safari */
    -khtml-user-select: none; /* Konqueror HTML */
    -moz-user-select: none; /* Old versions of Firefox */
    -ms-user-select: none; /* Internet Explorer/Edge */
    user-select: none; /* Non-prefixed version, currently
                                    supported by Chrome, Edge, Opera and Firefox */
  }
  .line-through {
    text-decoration: line-through;
  }
  </style>