import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: "login",
      component: () => import('@/views/Login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/Register.vue')
    },
    {
      path: '/forget-password',
      name: 'forget-password',
      component: () => import('@/views/ForgetPassword.vue')
    },
    {
      path: '/shots',
      name: 'shots',
      component: () => import('@/views/Shots.vue')
    }
  ]
})

export default router
