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
        var firstAmount = document.getElementById("firstAmount").value;
        var lastAmount = document.getElementById("lastAmount").value;
        $http.get('/api/kiosks/get_by_workplaces?firstAmount='+firstAmount+'&lastAmount='+lastAmount).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});