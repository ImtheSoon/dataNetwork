<template>
  <div class="board-detail">
    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnUpdate">수정</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-red" v-on:click="fnDelete">삭제</button>&nbsp;
      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>
    </div>
    <div class="board-contents">
      <h3>{{ title }}</h3>
      <div>
        <strong class="w3-large">{{ author }}</strong>
        <br>
        <span>{{ created_at }}</span>
      </div>
    </div>
    <div class="board-contents">
      <span>{{ contents }}</span>
    </div>
    <div >
       <div class="comment-form" id="respond">
        <span>{{comment_cont}}</span>
       </div>
      <!-- 댓글입력창 -->
      <p class="comment-form-comment">
        <label for="comment">Comments</label>
        <textarea cols="30" rows="6"  name="author" v-model="comment_cont"
                  placeholder="댓글을 남겨보세요!" required="required"
                  id="comment"></textarea>
      </p>
      <!-- 댓글작성 버튼 -->
      <p class="form-submit" style="text-align: right">
        <input type="submit" v-on:click="addComment" value="댓글등록"
                class="submit site-button"/>
      </p>

    </div>
    
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,
      title: '',
      author: '',
      contents: '',
      created_at: '',
      board_idx:'',
      user_idx:'',
      comment_data:'',
    }
  },
  mounted() {
    this.fnGetView()
  },
  methods: {
    comment_cont() {
     this.$axios.get(this.$serverUrl + '/comment/'+ this.idx,{
        params : this.requestBody
      }).then((res)=>{      
        this.board_idx
        this.user_idx
        this.comment_data = res.data.comment_data
      })
    },
    addComment(){
      let apiUrl = this.$serverUrl + '/comment/write/'+ this.idx
      this.form = {
                
        "board_idx": this.idx,
        "user_idx": this.user_idx,
        "comment_data": this.comment_data,
      }
       this.$axios.post(apiUrl, this.form)
       .then((res) => {
          alert('댓글이 저장되었습니다.')
          this.comment_cont(res.data.idx)
        })
      
    },
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/board/' + this.idx,{
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.author = res.data.author
        this.contents = res.data.contents
        this.created_at = res.data.created_at
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },
    fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    },
    fnUpdate() {
      this.$router.push({
        path: './write',
        query: this.requestBody
      })
    },
    fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete(this.$serverUrl + '/board/' + this.idx, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnList();
          }).catch((err) => {
        console.log(err);
      })
    }
  }
}
</script>
<style scoped>


</style>