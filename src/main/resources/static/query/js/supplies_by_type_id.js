var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/type_of_supplies').then(function (response){
        var typeOfSupplies = response.data;
        var selector = document.getElementById("TypeOfSupplies");
        $(selector).empty();
        for (var i = 0; i < typeOfSupplies.length; i++) {
            var option = document.createElement("option");
            option.text = typeOfSupplies[i].name;
            option.value = typeOfSupplies[i].id;
            selector.add(option);
        }
    });

    this.change = function change() {
        var typeIndex = document.getElementById("TypeOfSupplies").selectedIndex;
        var id = document.getElementById("TypeOfSupplies").options[typeIndex].value;
        $http.get('/api/supplies/get_by_type?id='+id).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});