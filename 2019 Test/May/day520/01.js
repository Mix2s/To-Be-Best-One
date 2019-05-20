
    function checkUserName() {
        var username = document.getElementById("username");
        username = username.value;
        var reg = /^[0-0a-zA-Z]{4,14}$/i;
        if(!reg.test(username)){
            alert("wudi");
            return false;
        }
        return true;
      }
      /*
      var a = 20;
      var b = 3.14;
      document.write(a+typeof(a));
      */
     function genNewDate(){
        //1.创建日期对象
    var date = new Date () ;
    //2.拼接时间字符串
    var dateStr = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+
    date.getDate()+"&nbsp;&nbsp;"+date.getHours()+":"+date.getMinutes()+":"+
    date.getSeconds() ;
    // 3.获取span标签对象 id="spanTip"
    var span = document.getElementById("spanTip") ;
    //4 设置span标签对象innerHTML属性/innerText (动态添加文本内容)
    span.innerHTML="<h2>"+dateStr+"</h2>" ;
    }
    setInterval("genNewDate()",1000)