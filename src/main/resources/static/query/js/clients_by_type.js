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

    var selector2 = document.getElementById("kType");
    $(selector2).empty();

    var option2_1 = document.createElement("option");
    option2_1.text = "Любитель";
    option2_1.value = "Любитель";
    selector2.add(option2_1);

    var option2_2 = document.createElement("option");
    option2_2.text = "Професіонал";
    option2_2.value = "Професіонал";
    selector2.add(option2_2);

    this.change = function change() {
        var kTypeIndex = document.getElementById("kType").selectedIndex;
        var kType = document.getElementById("kType").options[kTypeIndex].value;
        $http.get('/api/clients/get_by_type?kType='+kType).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});