angular.module('borderlandsApp', ['ngRoute'])
.config(['$locationProvider', function($locationProvider){
    $locationProvider.hashPrefix('');
}])
.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/', {templateUrl: '/templates/character.html'})
    .when('/inventory', {templateUrl: '/templates/inventory.html'})
    .when('/quests', {templateUrl: '/templates/quest.html'})
    .when('/codex', {templateUrl: '/templates/codex.html'})
    .when('/maps', {templateUrl: '/templates/maps.html'})
    .when('/admin', {templateUrl: '/templates/admin.html'})
    .when('/logout', {templateUrl: '/templates/logout.html'})
    .otherwise({redirectTo: '/'});
}])
.controller('borderlandsController', ['$scope', '$http', '$location', function($scope, $http, $location){
    $scope.$on('$routeChangeSuccess', function($currentRoute, $previousRoute){
        var title = null;
        switch($location.path()){
            case '/':
                title = 'Character';
                break;
            case '/inventory':
                title = 'Inventory';
                break;
            case '/quests':
                title = 'Quests';
                break;
            case '/codex':
                title = 'Codex';
                break;
            case '/maps':
                title = 'Maps';
                break;
            case '/admin':
                title = 'Admin';
                break;
            case '/logout':
                title = 'Log Out';
                break;
        }
        if(title !== null) $scope.section = title;
    });
    $scope.section = 'Character';
}]);