(function () {
    'use strict';
    angular
        .module('app.commonServices')
        .factory('webApiServices', webApiServices);

    function webApiServices($http) {
        var service = {
            getAllEmployeeList: getAllEmployeeList,
            registerEmployee: registerEmployee
        };

        return service;

        function getAllEmployeeList() {
            var command = '/api/employee/list';
            return $http.get(command);
        }

        function registerEmployee(params){
            var command = '/api/employee/register';
            return $http.post(command, params);
        }
    }

})();