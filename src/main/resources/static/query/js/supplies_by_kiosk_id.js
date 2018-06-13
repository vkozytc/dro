var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/kiosks').then(function (response) {
        var data = response.data;
        var kiosks = document.getElementById("kiosks");
        $(kiosks).empty();
        for (var i = 0; i < data.length; i++) {
            var option = document.createElement("option");
            option.text = data[i].address;
            option.value = data[i].id;
            kiosks.add(option);
        }
    });

    this.change = function change() {
        var kiosksIndex = document.getElementById("kiosks").selectedIndex;
        var id = document.getElementById("kiosks").options[kiosksIndex].value;
        $http.get('/api/supplies/get_by_kiosk?id='+id).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});