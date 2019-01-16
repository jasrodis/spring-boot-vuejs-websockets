let stompClient = null;

var vm = new Vue({
  el: "#app",
  mounted: function() {
    this.$nextTick(function() {
      let socket = new SockJS("/data-info");
      stompClient = Stomp.over(socket);
      stompClient.connect(
        {},
        function(frame) {
          console.log("Connected: " + frame);

          stompClient.subscribe("/info/values", function(val) {
            console.log(val);
            console.log(JSON.parse(val.body));
            vm.valuesList = JSON.parse(val.body);
          });
        }
      );
    });
  },
  data: function() {
    return {
      valuesList: []
    };
  }
});
