var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/photo_goods').then(function (response){
        var photoGoods = response.data;
        var selector = document.getElementById("PhotoGoods");
        $(selector).empty();
        for (var i = 0; i < photoGoods.length; i++) {
            var option = document.createElement("option");
            option.text = photoGoods[i].name;
            option.value = photoGoods[i].id;
            selector.add(option);
        }
    });

    this.change = function change() {
        var photoGoodsIndex = document.getElementById("PhotoGoods").selectedIndex;
        var id = document.getElementById("PhotoGoods").options[photoGoodsIndex].value;
        var firstDate = document.getElementById("firstDate").value;
        var secondDate = document.getElementById("secondDate").value;
        $http.get('/api/office_orders/get_by_photo_good?id='+id+'&firstDate='+firstDate+'&secondDate='+secondDate).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});