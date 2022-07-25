import axios from 'axios'
const localIp = '192.168.112.1'
const baseURL = process.env.NEXT_PUBLIC_API_URL || `http://${localIp}:8080/agrotech`
export function AxiosInstance () {
  return axios.create({
    baseURL,
    headers: {
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*' // Could work and fix the previous problem, but not in all APIs
    }
  })
}
