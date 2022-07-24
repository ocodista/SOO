import axios from 'axios'

export function AxiosInstance () {
  return axios.create({
    baseURL: 'http://localhost:8080/agrotech',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*' // Could work and fix the previous problem, but not in all APIs
    }
  })
}
