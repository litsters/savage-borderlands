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
        $timeout(1000).then(function(success){
            var temp = [];
            temp.push({
                name: 'Sir Gallahad',
                portrait: 'vault_symbol.jpg',
                class: 'Pompadour'
            });
            temp.push({
                name: 'Aaron Kimioku',
                portrait: 'vault_symbol.jpg',
                class: 'Unicorn'
            });
            $scope.characterList = temp;
        }, function(error){
            alert('an error occurred');
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
        $timeout(1000).then(function(success){
            if($scope.passwordAttempt === 'asdf'){
                $cookies.put('rpgauth', 'authcode');
                $cookies.remove('rpgredirect');
                $window.location.href = $scope.returnURL;
            } else {
                $scope.message = 'WRONG PASSWORD';
            }
        }, function(error){
            $scope.message = 'COULDN\'T VERIFY PASSWORD';
        });
    }

    $scope.newCharacter = function(){
        $cookies.put('rpgredirect', $scope.returnURL);
        $window.location.href = '/creator.html';
    }

    $scope.getCharacters();
}]);