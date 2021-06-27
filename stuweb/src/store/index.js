import Vue from 'vue'
import Vuex from 'vuex'
import admin from './admin/index'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    defaultTerm:1
  },
  mutations: {
    set_default_term(state,val){
      state.defaultTerm=val;
    }
  },
  actions: {
  },
  modules: {
    admin
  }
})
