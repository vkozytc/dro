var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/photo_goods').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/photo_goods/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Фототовар було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {

        $http.get('/api/good_type').then(function (response){
            var goodType = response.data;
            var selector = document.getElementById("GoodType");
            $(selector).empty();
            for (var i = 0; i < goodType.length; i++) {
                var option = document.createElement("option");
                option.text = goodType[i].name;
                option.value = goodType[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        var name = document.getElementById("Name").value;
        var goodTypeIndex = document.getElementById("GoodType").selectedIndex;
        var goodTypeId = document.getElementById("GoodType").options[goodTypeIndex].value;
        var supplierName = document.getElementById("SupplierName").value;

        var time = performance.now();
        $http.get('/api/photo_goods/insert?name='+name+'&goodTypeId='+goodTypeId+'&supplierName='+supplierName).then(function (response){
            window.location.reload();
            window.alert('Фототовар було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, name, goodTypeId, supplierName) {
        thisId=id;
        var thisIndex;
        $http.get('/api/good_type').then(function (response){
            var goodType = response.data;
            var selector = document.getElementById("GoodTypeUPD");
            $(selector).empty();
            for (var i = 0; i < goodType.length; i++) {
                var option = document.createElement("option");
                option.text = goodType[i].name;
                option.value = goodType[i].id;
                if(goodType[i].id === goodTypeId)
                {
                    thisIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("GoodTypeUPD").selectedIndex=thisIndex;
        });

        document.getElementById("NameUPD").value=name;
        document.getElementById("SupplierNameUPD").value=supplierName;
    };
    this.update_entry = function update_entry() {
        var name = document.getElementById("NameUPD").value;
        var goodTypeIndex = document.getElementById("GoodTypeUPD").selectedIndex;
        var goodTypeId = document.getElementById("GoodTypeUPD").options[goodTypeIndex].value;
        var supplierName = document.getElementById("SupplierNameUPD").value;

        var time = performance.now();
        $http.get('/api/photo_goods/update?id='+thisId+'&name='+name+'&goodTypeId='+goodTypeId+'&supplierName='+supplierName).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});