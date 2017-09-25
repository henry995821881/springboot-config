// pages/add/add.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tip:'',
    money_:'',
    remark_:'',
    type_: ['超市', '水电煤', '衣服', '餐费','交通', '其他'],
    current_index:0
  },
  formBindsubmit: function (e) {
    var that = this;
    if (that.data.type_[that.data.current_index].length == 0 || e.detail.value.money_.length == 0) {
      that.setData({
        tip: '提示：类型和金额不能为空！',
        current_index: 0,
        money_: ''
      });
    } else {

      that.setData({ tip: '', money_: e.detail.value.money_, remark_: e.detail.value.remark_});
      //request
      var token = app.globalData.token;
      wx.request({
        url: app.globalData.server_url + '/account/add',
        //String token,String type,String money,String remark
        data: {
          token: token,
          type: that.data.type_[that.data.current_index],
          money:that.data.money_*100,
          remark:that.data.remark_
        },
        success: function (res) {

          console.log(res.data);
          if (res.data.status == 'ok') {
            that.setData({ account_s: res.data.data });
          }

        }
      });


    }
  },
  formReset: function () {
    this.setData({
      type_: '',
      money_: '',
      remark_: ''
    })
  }
  ,
  bindTypePickerChange: function (e) {
    console.log(e.detail.value);
   
    this.setData({
      current_index: e.detail.value
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})