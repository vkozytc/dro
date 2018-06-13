var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];

    this.change = function change() {
        var firstDate = document.getElementById("firstDate").value;
        var secondDate = document.getElementById("secondDate").value;
        $http.get('/api/hurry_supplies/get_by_date?firstDate='+firstDate+'&secondDate='+secondDate).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});