var app = angular.module("photo", []);

app.controller("AppCtrl", function ($http, $scope) {

    $scope.entries = [];
    $http.get('/api/service_supplies').then(function (response){
        $scope.entries = response.data;
        console.log(response);
    });
    this.del_entry = function del(id) {
        var time = performance.now();
        $http.get('/api/service_supplies/del?id='+id).then(function (response){
            window.location.reload();
            window.alert('Сервісне замовлення було видалено!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };

    this.start_insert_entry = function add() {
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
        $http.get('/api/services').then(function (response){
            var services = response.data;
            var selector = document.getElementById("Services");
            $(selector).empty();
            for (var i = 0; i < services.length; i++) {
                var option = document.createElement("option");
                option.text = services[i].name;
                option.value = services[i].id;
                selector.add(option);
            }
        });
        $http.get('/api/clients').then(function (response){
            var clients = response.data;
            var selector = document.getElementById("Clients");
            $(selector).empty();
            for (var i = 0; i < clients.length; i++) {
                var option = document.createElement("option");
                option.text = clients[i].name;
                option.value = clients[i].id;
                selector.add(option);
            }
        });
    };

    this.insert_entry = function add() {
        var date = document.getElementById("Date").value;
        var kiosksIndex = document.getElementById("Kiosks").selectedIndex;
        var kioskId = document.getElementById("Kiosks").options[kiosksIndex].value;
        var servicesIndex = document.getElementById("Services").selectedIndex;
        var serviceId = document.getElementById("Services").options[servicesIndex].value;
        var clientsIndex = document.getElementById("Clients").selectedIndex;
        var clientId = document.getElementById("Clients").options[clientsIndex].value;

        var time = performance.now();
        $http.get('/api/service_supplies/insert?date='+date+'&kioskId='+kioskId+'&serviceId='+serviceId
                +'&clientId='+clientId).then(function (response){
            window.location.reload();
            window.alert('Сервісне замовлення було успішно додано!');
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
    var thisId;

    this.start_update_entry = function upd(id, date, kioskId, serviceId, clientId) {
        thisId=id;
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
        var servicesIndex;
        $http.get('/api/services').then(function (response){
            var services = response.data;
            var selector = document.getElementById("ServicesUPD");
            $(selector).empty();
            for (var i = 0; i < services.length; i++) {
                var option = document.createElement("option");
                option.text = services[i].name;
                option.value = services[i].id;
                if(services[i].id === serviceId)
                {
                    servicesIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("ServicesUPD").selectedIndex=servicesIndex;
        });
        var clientsIndex;
        $http.get('/api/clients').then(function (response){
            var clients = response.data;
            var selector = document.getElementById("ClientsUPD");
            $(selector).empty();
            for (var i = 0; i < clients.length; i++) {
                var option = document.createElement("option");
                option.text = clients[i].name;
                option.value = clients[i].id;
                if(clients[i].id === clientId)
                {
                    clientsIndex = i;
                }
                selector.add(option);
            }

            document.getElementById("ClientsUPD").selectedIndex=clientsIndex;
        });
        document.getElementById("DateUPD").value=date;
    };
    this.update_entry = function update_entry() {
        var date = document.getElementById("DateUPD").value;
        var kiosksIndex = document.getElementById("KiosksUPD").selectedIndex;
        var kioskId = document.getElementById("KiosksUPD").options[kiosksIndex].value;
        var servicesIndex = document.getElementById("ServicesUPD").selectedIndex;
        var serviceId = document.getElementById("ServicesUPD").options[servicesIndex].value;
        var clientsIndex = document.getElementById("ClientsUPD").selectedIndex;
        var clientId = document.getElementById("ClientsUPD").options[clientsIndex].value;

        var time = performance.now();
        $http.get('/api/service_supplies/update?id='+thisId+'&date='+date+'&kioskId='+kioskId+'&serviceId='+serviceId
            +'&clientId='+clientId).then(function (response){
            window.location.reload();
        });
        //console.log(resp);
        time = performance.now() - time;
        console.log('час = ', time);
        alert("--------");
        window.location.reload();
    };
});