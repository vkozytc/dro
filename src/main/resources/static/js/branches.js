var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/branches').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/branches/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Вітку було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {
    };

    this.insert_entry = function add() {
        var address = document.getElementById("Address").value;
        var amountOfWorkplaces = document.getElementById("AmountOfWorkplaces").value;

        var time = performance.now();
        $http.get('/api/branches/insert?address='+address+'&amountOfWorkplaces='+amountOfWorkplaces).then(function (response){
                window.location.reload();
                window.alert('Вітку було успішно додано!');
            });
            //console.log(resp);
            time = performance.now() - time;
            console.log('час = ', time);
            alert("--------");
            window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, address, amountOfWorkplaces) {
        thisId = id;
        document.getElementById("AddressUPD").value=address;
        document.getElementById("AmountOfWorkplacesUPD").value=amountOfWorkplaces;
    };
    this.update_entry = function update_entry() {
        var address = document.getElementById("AddressUPD").value;
        var amountOfWorkplaces = document.getElementById("AmountOfWorkplacesUPD").value;

        var time = performance.now();
        $http.get('/api/branches/update?id='+thisId+'&address='+address+'&amountOfWorkplaces=' +amountOfWorkplaces).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    // function checkAdd() {
    //     var branchAddress = document.getElementById("BranchAddress").value;
    //     var branchAmountOfWorkplaces = document.getElementById("BranchAmountOfWorkplaces").value;
    //
    //     var button = $(".btn-apply");
    //     button.prop('disabled', true);
    //
    //     if (branchAddress.length > 0 && branchAmountOfWorkplaces.length > 0) {
    //         button.prop('disabled', false);
    //     }
    // }
    //
    // $("#BranchAddressUPD, #BranchAmountOfWorkplacesUPD").bind('input', function() { checkUpdate(); });
    //
    // function checkUpdate() {
    //     var branchAddress = document.getElementById("BranchAddressUPD").value;
    //     var branchAmountOfWorkplaces = document.getElementById("BranchAmountOfWorkplacesUPD").value;
    //
    //     var button = $(".btn-apply");
    //     button.prop('disabled', true);
    //
    //     if (branchAddress.length > 0 && branchAmountOfWorkplaces.length > 0) {
    //         button.prop('disabled', false);
    //     }
    // }
});