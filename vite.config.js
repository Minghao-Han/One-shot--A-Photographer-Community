import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import axios from 'axios'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    hmr: true,
    port: 1206,
    Proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,

      }
    }
  }
})
