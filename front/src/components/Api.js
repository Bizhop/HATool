import axios from 'axios'

const Api = {
  get(url, opts) {
    return axios.get(url, opts).then(res => res.data)
  },
  post(url, data, opts) {
    return axios.post(url, data, opts).then(res => res.data)
  },
  put(url, data, opts) {
    return axios.put(url, data, opts).then(res => res.data)
  },
  delete(url, opts) {
    return axios.delete(url, opts)
  },
}

export default Api
