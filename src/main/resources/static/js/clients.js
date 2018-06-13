var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/clients').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/clients/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Клієнта було видалено!');
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

        var selector2 = document.getElementById("Type");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Любитель";
        option2_1.value = "Любитель";
        selector2.add(option2_1);

        var option2_2 = document.createElement("option");
        option2_2.text = "Професіонал";
        option2_2.value = "Професіонал";
        selector2.add(option2_2);
    };

    this.insert_entry = function add() {
        var name = document.getElementById("Name").value;
        var branchesIndex = document.getElementById("Branches").selectedIndex;
        var branchId = document.getElementById("Branches").options[branchesIndex].value;
        var typeIndex = document.getElementById("Type").selectedIndex;
        var type = document.getElementById("Type").options[typeIndex].value;
        var discount = document.getElementById("Discount").value;

        var time = performance.now();
        $http.get('/api/clients/insert?name='+name+'&branchId='+branchId+'&type='+type+
                '&discount='+discount).then(function (response){
            window.location.reload();
            window.alert('Клієнта було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, name, branchId, type, discount) {
        thisId=id;
        var thisIndex;
        console.log("branch id = " + branchId);
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


        var selector2 = document.getElementById("TypeUPD");
        $(selector2).empty();

        var option2_1 = document.createElement("option");
        option2_1.text = "Любитель";
        option2_1.value = "Любитель";
        selector2.add(option2_1);
        if(option2_1.value==type)
            selector2.selectedIndex=0;

        var option2_2 = document.createElement("option");
        option2_2.text = "Професіонал";
        option2_2.value = "Професіонал";
        selector2.add(option2_2);
        if(option2_2.value==type)
            selector2.selectedIndex=1;


        document.getElementById("NameUPD").value=name;
        document.getElementById("DiscountUPD").value=discount;
    };
    this.update_entry = function update_entry() {
        var time = performance.now();
        var name = document.getElementById("NameUPD").value;
        var branchesIndex = document.getElementById("BranchesUPD").selectedIndex;
        var branchId = document.getElementById("BranchesUPD").options[branchesIndex].value;
        var typeIndex = document.getElementById("TypeUPD").selectedIndex;
        var type = document.getElementById("TypeUPD").options[typeIndex].value;
        var discount = document.getElementById("DiscountUPD").value;

        $http.get('/api/clients/update?id='+thisId+'&name='+name+'&branchId='+branchId+'&type='+type+
            '&discount='+discount).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});