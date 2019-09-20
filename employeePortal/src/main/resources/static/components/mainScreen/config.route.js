(function (){
    angular.module('app.mainScreen')
        .config(['$routeProvider', function config($routeProvider) {
                  $routeProvider.
                   when('/', {
                     templateUrl : "/components/mainScreen/mainScreen.html",
                     controller : "mainScreenCtrl as vm"
                   });
        }
      ]);
    }
)();
