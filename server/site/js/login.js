angular.module('login', ['ngCookies'])
.controller('loginController', ['$scope', '$cookies', '$window', '$http', '$timeout', function($scope, $cookies, $window, $http, $timeout){
    $scope.authKey = 'rpgauth';
    $scope.redirectKey = 'rpgredirect';
    $scope.returnURL = $cookies.get($scope.redirectKey);
    $scope.characterList = [];
    $scope.passwordAttempt = '';
    $scope.overlayActive = false;
    $scope.selectedCharacter = null;
    $scope.message = '';

    $scope.getCharacters = function(){
        var command = {
            type: 'GET_CHARACTER_LIST'
        };
        $http.post('/command', command).then(function(success){
            if(success.data.values.message !== undefined) alert(success.data.values.message);
            else {
                $scope.characterList = success.data.values.characters;
            }
        }, function(error){
            alert('A server error occurred and the characters couldn\'t be loaded.');
        });
    }

    $scope.selectCharacter = function(index){
        $scope.overlayActive = true;
        $scope.selectedCharacter = $scope.characterList[index];
    }

    $scope.cancelOverlay = function(){
        $scope.overlayActive = false;
        $scope.message = '';
        $scope.passwordAttempt = '';
    }

    $scope.login = function(){
        var command = {
            type: 'LOGIN',
            stringValues: {
                name: $scope.selectedCharacter.name,
                passwordAttempt: $scope.passwordAttempt
            }
        };
        $http.post('/command', command).then(function(success){
            if(success.data.values.message !== undefined) $scope.message = success.data.values.message;
            else {
                $cookies.put('rpgauth', success.data.values.authcode);
                $cookies.remove('rpgredirect');
                $window.location.href = $scope.returnURL;
            }
        }, function(error){
            $scope.message = 'COULDN\'T VERIFY PASSWORD';
        });

//        $timeout(1000).then(function(success){
//            if($scope.passwordAttempt === 'asdf'){
//                $cookies.put('rpgauth', 'authcode');
//                $cookies.remove('rpgredirect');
//                $window.location.href = $scope.returnURL;
//            } else {
//                $scope.message = 'WRONG PASSWORD';
//            }
//        }, function(error){
//            $scope.message = 'COULDN\'T VERIFY PASSWORD';
//        });
    }

    $scope.newCharacter = function(){
        $cookies.put('rpgredirect', $scope.returnURL);
        $window.location.href = '/creator.html';
    }

    $scope.getCharacters();
}]);