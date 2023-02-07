<template>
  <div data-app>
    <taskDataComponent />
  </div>  
</template>
<script>
import taskDataComponent from './components/taskDataComponent.vue';

export default {
  
  name: 'App',
  components: {
    taskDataComponent
  },

  data: () => ({
    //
  }),
};
</script>
