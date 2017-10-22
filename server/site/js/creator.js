angular.module('creator', ['ngCookies'])
.controller('creatorController', ['$scope', '$http', '$cookies', '$timeout', function($scope, $http, $cookies, $timeout){
    $scope.portraits = [];
    $scope.name = '';
    $scope.class = '';
    $scope.password = '';
    $scope.portrait = 'vault_symbol.jpg';
    $scope.message = '';


    $scope.getPortraits = function(){
        $timeout(1000).then(function(success){
            $scope.portraits.push('vault_symbol.jpg');
        }, function(error){

        });
    }

    $scope.createCharacter = function(){
        var options = {
            type: 'CREATE_CHARACTER',
            stringValues: {
                name: $scope.name,
                klass: $scope.password,
                password: $scope.password,
                portrait: $scope.portrait
            }
        };
        $scope.message = 'CREATING...';
        $http.post('/command', options).then(function(success){
            $scope.message = success.data.values.message;
        }, function(error){
            $scope.message = 'COULDN\'T CREATE CHARACTER';
        });
    }

    $scope.getPortraits();
}]);