var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/type_of_supplies').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/type_of_supplies/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Тип замовлення було видалено!');
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

        var time = performance.now();
        $http.get('/api/type_of_supplies/insert?name='+name).then(function (response){
            window.location.reload();
            window.alert('Тип замовлення було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, name) {
        thisId=id;
        document.getElementById("NameUPD").value=name;
    };
    this.update_entry = function update_entry() {
        var time = performance.now();
        var name = document.getElementById("NameUPD").value;

        $http.get('/api/type_of_supplies/update?id='+thisId+'&name='+name).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});