var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/office_orders').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/office_orders/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Офісне замовлення було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {

        $http.get('/api/photo_goods').then(function (response){
            var photoGoods = response.data;
            var selector = document.getElementById("PhotoGoods");
            $(selector).empty();
            for (var i = 0; i < photoGoods.length; i++) {
                var option = document.createElement("option");
                option.text = photoGoods[i].name;
                option.value = photoGoods[i].id;
                selector.add(option);
            }
        });

        $http.get('/api/kiosks').then(function (response){
            var kiosks = response.data;
            var selector = document.getElementById("Kiosks");
            $(selector).empty();
            for (var i = 0; i < kiosks.length; i++) {
                var option = document.createElement("option");
                option.text = kiosks[i].address;
                option.value = kiosks[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        var photoGoodsIndex = document.getElementById("PhotoGoods").selectedIndex;
        var photoGoodId = document.getElementById("PhotoGoods").options[photoGoodsIndex].value;
        var kiosksIndex = document.getElementById("Kiosks").selectedIndex;
        var kioskId = document.getElementById("Kiosks").options[kiosksIndex].value;
        var dateOfSupply = document.getElementById("DateOfSupply").value;
        var amountOfGoods = document.getElementById("AmountOfGoods").value;
        var price = document.getElementById("Price").value;
        var dateOfSelling = document.getElementById("DateOfSelling").value;

        var time = performance.now();
        $http.get('/api/office_orders/insert?photoGoodId='+photoGoodId+'&kioskId='+kioskId+'&dateOfSupply='+dateOfSupply
                +'&amountOfGoods='+amountOfGoods+'&price='+price+'&dateOfSelling='+dateOfSelling).then(function (response){
            window.location.reload();
            window.alert('Офісне замовлення було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, photoGoodId, kioskId, dateOfSupply, amountOfGoods, price, dateOfSelling) {
        thisId=id;
        var photoGoodsIndex;
        $http.get('/api/photo_goods').then(function (response){
            var photoGoods = response.data;
            var selector = document.getElementById("PhotoGoodsUPD");
            $(selector).empty();
            for (var i = 0; i < photoGoods.length; i++) {
                var option = document.createElement("option");
                option.text = photoGoods[i].name;
                option.value = photoGoods[i].id;
                if(photoGoods[i].id === photoGoodId)
                {
                    photoGoodsIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("PhotoGoodsUPD").selectedIndex=photoGoodsIndex;
        });
        var kiosksIndex;
        $http.get('/api/kiosks').then(function (response){
            var kiosks = response.data;
            var selector = document.getElementById("KiosksUPD");
            $(selector).empty();
            for (var i = 0; i < kiosks.length; i++) {
                var option = document.createElement("option");
                option.text = kiosks[i].address;
                option.value = kiosks[i].id;
                if(kiosks[i].id === kioskId)
                {
                    kiosksIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("KiosksUPD").selectedIndex=kiosksIndex;
        });
        document.getElementById("DateOfSupplyUPD").value=dateOfSupply;
        document.getElementById("AmountOfGoodsUPD").value=amountOfGoods;
        document.getElementById("PriceUPD").value=price;
        document.getElementById("DateOfSellingUPD").value=dateOfSelling;
    };
    this.update_entry = function update_entry() {
        var photoGoodsIndex = document.getElementById("PhotoGoodsUPD").selectedIndex;
        var photoGoodId = document.getElementById("PhotoGoodsUPD").options[photoGoodsIndex].value;
        var kiosksIndex = document.getElementById("KiosksUPD").selectedIndex;
        var kioskId = document.getElementById("KiosksUPD").options[kiosksIndex].value;
        var dateOfSupply = document.getElementById("DateOfSupplyUPD").value;
        var amountOfGoods = document.getElementById("AmountOfGoodsUPD").value;
        var price = document.getElementById("PriceUPD").value;
        var dateOfSelling = document.getElementById("DateOfSellingUPD").value;

        var time = performance.now();
        $http.get('/api/office_orders/update?id='+thisId+'&photoGoodId='+photoGoodId+'&kioskId='+kioskId+'&dateOfSupply='+dateOfSupply
            +'&amountOfGoods='+amountOfGoods+'&price='+price+'&dateOfSelling='+dateOfSelling).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});