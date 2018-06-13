var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/services').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/services/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Сервіс було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {
    };

    this.insert_entry = function add() {
        var name = document.getElementById("Name").value;
        var price = document.getElementById("Price").value;

        var time = performance.now();
        $http.get('/api/services/insert?name='+name+'&price='+price).then(function (response){
            window.location.reload();
            window.alert('Сервіс було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, name, price) {
        thisId=id;
        document.getElementById("NameUPD").value=name;
        document.getElementById("PriceUPD").value=price;
    };
    this.update_entry = function update_entry() {
        var name = document.getElementById("NameUPD").value;
        var price = document.getElementById("PriceUPD").value;

        var time = performance.now();
        $http.get('/api/services/update?id='+thisId+'&name='+name+'&price='+price).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});