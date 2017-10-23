angular.module('creator', ['ngCookies'])
.controller('creatorController', ['$scope', '$http', '$cookies', '$timeout', '$window', function($scope, $http, $cookies, $timeout, $window){
    $scope.portraits = [];
    $scope.name = '';
    $scope.class = '';
    $scope.password = '';
    $scope.portrait = '';
    $scope.message = '';


    $scope.getPortraits = function(){
        var command = {
            type: 'GET_PORTRAITS'
        };
        $http.post('/command', command).then(function(success){
            if(success.data.values.message !== undefined) alert(success.data.values.message);
            else {
                $scope.portraits = success.data.values.portraits;
            }
        }, function(error){
            alert('An error occurred. Portraits are not available.')
        });
    }

    $scope.createCharacter = function(){
        var options = {
            type: 'CREATE_CHARACTER',
            stringValues: {
                name: $scope.name,
                klass: $scope.class,
                password: $scope.password,
                portrait: $scope.portrait
            }
        };
        $scope.message = 'CREATING...';
        $http.post('/command', options).then(function(success){
            var temp = success.data.values.message;
            if(temp === 'success'){
                $window.location.href = '/login.html';
            }
            else $scope.message = temp;
        }, function(error){
            $scope.message = 'COULDN\'T CREATE CHARACTER';
        });
    }

    $scope.getPortraits();
}]);