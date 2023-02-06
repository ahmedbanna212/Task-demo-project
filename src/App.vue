<template>
  <v-app>
    <ToDoList/>
  </v-app>
</template>

<script>
import ToDoList from './components/ToDoList.vue';
export default {
  name: 'App',

  components: {
  ToDoList
  },

  data: () => ({
    //
  }),
};
</script>
