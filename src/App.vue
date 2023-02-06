<template>
  <v-app>
    <v-main>
      <ToDoList/>
       <!-- <AddTask/>  -->
    </v-main>
  </v-app>
</template>

<script>
// import HelloWorld from './components/HelloWorld';
import ToDoList from './components/ToDoList';
// import AddTask from './components/AddTask';

export default {
  name: 'App',

  components: {
    //HelloWorld,
    ToDoList,
    // AddTask
  },

  data: () => ({
    //
  }),
};
</script>
