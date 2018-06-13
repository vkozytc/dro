var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];

    this.change = function change() {
        var firstAmount = document.getElementById("firstAmount").value;
        var lastAmount = document.getElementById("lastAmount").value;
        $http.get('/api/branches/get_by_workplaces?firstAmount='+firstAmount+'&lastAmount='+lastAmount).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});