// pages/chat/chat.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      word:'',
      list:'',
      message:''
  },
  houduanButton1:function(){
    var that=this;
    wx.request({
      url: 'http://localhost:80/getUser',
      method:'GET',
      header:{
        'content-type':'application/json'
      },
      success:function(res){
        // console.log(res.data.list);
         var list = res.data.list;
        if(list==null){
          var totastText='数据获取失败';
          wx.showToast({
            title: totastText,
            icon:'',
            duration:2000
          });
        }else{
          that.setData({
            list:list
          })
        }

      }
    })
  },
//获取输入框中的值
  houduanTab_input:function(e){
      // console.log(e);
      this.setData({
        word:e.detail.value
      })
  },
  houduanButton2:function(){
    var that=this;
    wx.request({
      url: 'http://localhost:80/getWord',
      data:{
        word:that.data.word
      },
      method:'GET',
      header: {
        'content-type': 'application/json'
      },
      success:function(res){
        // console.log(res.data);
        var message=res.data.message;
        if(message==null){
          var totastText = '数据获取失败';
          wx.showToast({
            title: totastText,
            icon:'',
            duration:2000
          })
        }else{
          that.setData({
            message:message
          })
        }
      }
    })
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