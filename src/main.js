import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import ToDoList from './components/ToDoList.vue'
Vue.use(VueRouter)
import vuetify from './plugins/vuetify'
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'


Vue.config.productionTip = false
const routes = [
  {path: '/', component: ToDoList }
]
const router = new VueRouter({mode: 'history',routes: routes})
new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
