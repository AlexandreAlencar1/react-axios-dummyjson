import axios from "axios"
//configurar a base url e mudar só os endpoints
const productFetch = axios.create({
    baseURL: "https://dummyjson.com"
})

export default productFetch