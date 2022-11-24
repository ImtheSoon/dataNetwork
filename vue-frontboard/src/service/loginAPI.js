// src/service/loginAPI.js
import axios from "axios";

const getUserInfo = (userId, userPw) => {
    const reqData = {
        'user_id': userId,
        'user_pw': userPw
    }

    let serverUrl = '//localhost:8081'

    return axios.post(serverUrl + '/user/login', reqData, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
}

const getRegisterInfo = (userId, userPw, userName) => {
    const reqData = {
        'user_id' : userId,
        'user_pw' : userPw,
        'user_name' : userName

    }
    let serverUrl = '//localhost:8081'
    return axios.post(serverUrl + '/user/login', reqData, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
}

export default {
    async doLogin(userId, userPw) {
        try {
            const getUserInfoPromise = getUserInfo(userId, userPw)
            const [userInfoResponse] = await Promise.all([getUserInfoPromise])
            if (userInfoResponse.data.length === 0) {
                return 'notFound'
            } else {
                localStorage.setItem('user_token', userInfoResponse.data.user_token)
                localStorage.setItem('user_role', userInfoResponse.data.user_role)
                return userInfoResponse
            }
        } catch (err) {
            console.error(err)
        }
    }

    // async doRegister(userId, userPw, userName) {
    //     try {
    //         const getRegisterInfoPromise = getRegisterInfo(userId, userPw, userName)
    //         const [registerInfoResponse] = await Promise.all([getRegisterInfoPromise])
    //         if (registerInfoResponse.data.length === 0) {
    //             return 'notFound'
    //         } else {
    //             localStorage.setItem('user_token', registerInfoResponse.data.user_token)
    //             localStorage.setItem('user_role',registerInfoResponse.data.user_role)
    //             return registerInfoResponse
    //         }
    //     } catch (err) {
    //         console.error(err)
    //     }
    // }
}