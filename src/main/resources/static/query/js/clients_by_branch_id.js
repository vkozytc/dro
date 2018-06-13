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
        var branchesIndex = document.getElementById("Branches").selectedIndex;
        var id = document.getElementById("Branches").options[branchesIndex].value;
        $http.get('/api/clients/get_by_branch?id='+id).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});