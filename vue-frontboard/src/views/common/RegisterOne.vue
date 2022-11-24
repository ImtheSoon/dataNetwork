<template>
  <div>
    <div>
      <h2>Please Register</h2>
      <div id="RegisterForm">
          <p>
            <input class="w3-input" name="uname" placeholder="Enter your name" v-model="user_name"><br>
          </p>
          <p>
            <input class="w3-input" name="uid" placeholder="Enter your ID" v-model="user_id"><br>
          </p>
          <p>
            <input name="password" class="w3-input" placeholder="Enter your password" v-model="user_pw" type="password">
          </p>
          <p>
            <button type="submit" class="w3-button w3-green w3-round" v-on:click="fnRegister">Register</button>
          </p>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      user_id: '',
      user_pw: '',
      user_name: ''
    }
  },
  methods: {

    fnRegister() {
      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }
      if (this.user_name === '') {
        alert('이름을 입력하세요.')
        return
      }
      let apiUrl = this.$serverUrl + '/user/register'
      this.form = {
        "idx": this.idx,
        "user_name": this.user_name,
        "user_id": this.user_id,
        "user_pw": this.user_pw
      }
      if (this.idx === undefined) {
        //INSERT
        this.$axios.post(apiUrl, this.form)
            .then((res) => {
              alert('회원가입이 완료되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      }
      /**try {
        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})
        if (loginResult) this.goToPages()
      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }**/
      },
    fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './Login',
        query: this.requestBody
      })
    }
  }
}
</script>

<style>
#RegisterForm {
  width: 500px;
  margin: auto;
}
</style>