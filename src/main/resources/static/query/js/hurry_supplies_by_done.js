var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    var selector2 = document.getElementById("done");
    $(selector2).empty();

    var option2_1 = document.createElement("option");
    option2_1.text = "Завершено";
    option2_1.value = "Завершено";
    selector2.add(option2_1);

    var option2_2 = document.createElement("option");
    option2_2.text = "Не завершено";
    option2_2.value = "Не завершено";
    selector2.add(option2_2);

    this.change = function change() {
        var doneIndex = document.getElementById("done").selectedIndex;
        var done = document.getElementById("done").options[doneIndex].value;
        $http.get('/api/hurry_supplies/get_by_done?done='+done).then(function (response) {
            $scope.entries = response.data;
            console.log(response);
        });
    }
});