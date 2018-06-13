var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/branches').then(function (response) {
        var data = response.data;
        var branches = document.getElementById("Branches");
        $(branches).empty();
        for (var i = 0; i < data.length; i++) {
            var option = document.createElement("option");
            option.text = data[i].address;
            option.value = data[i].id;
            branches.add(option);
        }
    });

    this.change = function change() {
        var kFirst = document.getElementById("kFirst").value;
        var kLast = document.getElementById("kLast").value;
        $http.get('/api/clients/get_by_discount?kFirst='+kFirst+'&kLast='+kLast).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});