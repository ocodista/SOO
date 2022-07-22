const path = require('path')

/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  sassOptions: {
    includePaths: [path.join(__dirname, 'styles')]
  },
  rewrites: async () => {
    return [
      {
        source: '/api/:slug*',
        destination: 'http://localhost:8080/:slug*'
      }
    ]
  }
}

module.exports = nextConfig
