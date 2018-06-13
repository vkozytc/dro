var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/good_type').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/good_type/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Тип товару було видалено!');
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
        $http.get('/api/good_type/insert?name='+name).then(function (response){
            window.location.reload();
            window.alert('Тип товару було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;


    this.start_update_entry = function upd(id, name) {
        thisId = id;
        document.getElementById("NameUPD").value=name;
    };
    this.update_entry = function update_entry() {
        var name = document.getElementById("NameUPD").value;
        var time = performance.now();

        $http.get('/api/good_type/update?id='+thisId+'&name='+name).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});