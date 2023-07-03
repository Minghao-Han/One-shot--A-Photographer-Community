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
    },
    {
      path: '/shot',
      name: 'shot',
      component: () => import('@/views/ShotInfo.vue')
    },
    {
      path: '/game',
      name: 'game',
      component: () => import('@/views/Game.vue')
    },
    {
      path: '/game-info',
      name: 'game-info',
      component: () => import('@/views/GameInfo.vue')
    },
    {
      path: '/user-info',
      name: 'user-info',
      component: () => import('@/views/UserInfo.vue')
    }
  ]
})

export default router
