//app.js
App({
  onLaunch: function () {
    var that = this;
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {

        //通过token验证 //***后期保存到本地
        var need_login=true;

        if (that.globalData.token){

          wx.request({
            url: that.globalData.server_url + '/wx_check',
            data: {
              token: that.globalData.token
            },
            success: function (res1) {

              console.log(res1.data);
              if (res1.data.status =='ok'){
                need_login = false;
              }
              
            }
          });
        }


        // 发送 res.code 到后台换取 openId, sessionKey, unionId

        if(need_login){

          wx.request({
            url: that.globalData.server_url + '/wx_login',
            data: {
              code: res.code
            },
            success: function (res2) {

              console.log(res2.data.status);
              
              if (res2.data.status=='ok'){

                that.globalData.token = res2.data.token;
                console.log(that.globalData.token +"---globalData.token")
              }
            }
          });
        }

        

      }
    });
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
    token:'',
   // server_url:'http://meaccount.ngrok.cc'
    server_url: 'http://localhost:9090'
  }
})