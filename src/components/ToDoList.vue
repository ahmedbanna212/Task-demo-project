<template>
  <v-container>
    <v-row class="justify-center my-4">
      <h2>To Do List</h2>
    </v-row>
    <v-row class="justify-center my-2">
      <AddTask :getTask="AddTask" :closeModal="isClosed" />
    </v-row>
    <v-row class="align-center my-2 flex-column">
      <div v-for="task in allTasks" :key="task.task.id">
        <ToDoItem
          :crossed="crossed"
          :task="task"
          :deleteTask="deleteTask"
          :updateTask="updateTask"
          :updateTaskState="updateTaskState"
        />
      </div>
    </v-row>
  </v-container>
</template>

<script>
import AddTask from "./AddTask.vue";
import ToDoItem from "./ToDoItem.vue";

export default {
  name: "ToDoList",

  components: {
    AddTask,
    ToDoItem,
  },
  data: () => ({
    allTasks: [],
    closedModal: false,
    showModal: true,
    timer: "",
  }),
  created: function () {
    this.getAllTasks();
  },
  props: {
    crossed: Boolean,
  },
  methods: {
    getAllTasks() {
      fetch("http://10.0.11.87:8888/getTask")
        .then((response) => response.json())
        .then((data) => (this.allTasks = data))
        .catch((err) => console.error(err))
        .catch((err) => console.error(err));
    },

    AddTask(taskObject) {
      fetch("http://10.0.11.87:8888/addTask", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          id: taskObject.task.task_id,
          description: taskObject.task.task_description,
          subject: taskObject.task.task_title,
        }),
      }).then((response) => {
        console.log(response.ok);
        this.getAllTasks();
      });
    },

    deleteTask(task) {
      console.log(task);
      fetch(`http://10.0.11.87:8888/deleteTask/${task.id}`, {
        method: "DELETE",
      }).then((response) => {
        console.log(response);
        alert("Task is successfully deleted");
        this.getAllTasks();
      });
    },
    updateTask(newtitle, newdesc, oldtaskid) {
  
      fetch(`http://10.0.11.87:8888/updateTask/${oldtaskid}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          task: {
            subject: newtitle,
            description: newdesc,
          },
        }),
      }).then((response) => {
        console.log(response);
        this.getAllTasks();
      });
    },
    updateTaskState(taskid, crossed) {
      console.log(crossed);
      if (crossed == true) {
        fetch(`http://10.0.11.87:8888/updateTask/${taskid}`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            taskState: {
              state: "DONE",
            },
          }),
        }).then((response) => {
          console.log(response);
          this.getAllTasks();
        });
      } else if (crossed == false) {
        fetch(`http://10.0.11.87:8888/updateTask/${taskid}`, {
          method: "PUT",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify({
            taskState: {
              state: "IN_PROGRESS",
            },
          }),
        }).then((response) => {
          console.log(response);
          this.getAllTasks();
        });
      }
    },
  },
};
</script>
