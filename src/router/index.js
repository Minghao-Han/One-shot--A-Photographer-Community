import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: "navibar",
      component: () => import('@/views/NaviBar.vue')
    }
  ]
})

export default router
