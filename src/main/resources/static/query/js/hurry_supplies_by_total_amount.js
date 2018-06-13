var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];

    this.change = function change() {
        var firstNumber = document.getElementById("firstNumber").value;
        var secondNumber = document.getElementById("secondNumber").value;
        $http.get('/api/hurry_supplies/get_by_total_amount?firstNumber='+firstNumber+'&secondNumber='+secondNumber).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});