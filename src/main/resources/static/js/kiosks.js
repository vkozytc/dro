var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/kiosks').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/kiosks/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Кіоск було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {

        $http.get('/api/branches').then(function (response){
            var branches = response.data;
            var selector = document.getElementById("Branches");
            $(selector).empty();
            for (var i = 0; i < branches.length; i++) {
                var option = document.createElement("option");
                option.text = branches[i].address;
                option.value = branches[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        var address = document.getElementById("Address").value;
        var amountOfWorkplaces = document.getElementById("AmountOfWorkplaces").value;
        var branchesIndex = document.getElementById("Branches").selectedIndex;
        var branchId = document.getElementById("Branches").options[branchesIndex].value;

        var time = performance.now();
        $http.get('/api/kiosks/insert?address='+address+'&amountOfWorkplaces='+amountOfWorkplaces+'&branchId='+branchId).then(function (response){
            window.location.reload();
            window.alert('Кіоск було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, address, amountOfWorkplaces, branchId) {
        thisId=id;
        var thisIndex;
        $http.get('/api/branches').then(function (response){
            var branches = response.data;
            var selector = document.getElementById("BranchesUPD");
            $(selector).empty();
            for (var i = 0; i < branches.length; i++) {
                var option = document.createElement("option");
                option.text = branches[i].address;
                option.value = branches[i].id;
                if(branches[i].id === branchId)
                {
                    thisIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("BranchesUPD").selectedIndex=thisIndex;
        });
        document.getElementById("AddressUPD").value=address;
        document.getElementById("AmountOfWorkplacesUPD").value=amountOfWorkplaces;
    };
    this.update_entry = function update_entry() {
        var address = document.getElementById("AddressUPD").value;
        var amountOfWorkplaces = document.getElementById("AmountOfWorkplacesUPD").value;
        var branchesIndex = document.getElementById("BranchesUPD").selectedIndex;
        var branchId = document.getElementById("BranchesUPD").options[branchesIndex].value;

        var time = performance.now();
        $http.get('/api/kiosks/update?id='+thisId+'&address='+address+'&amountOfWorkplaces='+amountOfWorkplaces+'&branchId='+branchId).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});