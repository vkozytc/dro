var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/clients').then(function (response){
        var clients = response.data;
        var selector = document.getElementById("clients");
        $(selector).empty();
        for (var i = 0; i < clients.length; i++) {
            var option = document.createElement("option");
            option.text = clients[i].name;
            option.value = clients[i].id;
            selector.add(option);
        }
    });

    this.change = function change() {
        var clientsIndex = document.getElementById("clients").selectedIndex;
        var id = document.getElementById("clients").options[clientsIndex].value;
        $http.get('/api/hurry_supplies/get_by_client?id='+id).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});