(function () {
    'use strict';
    angular
        .module('app.commonServices')
        .controller('topNavCtrl', topNavCtrl);

    function topNavCtrl() {
        var vm = this;
        vm.pageName = 'Employee Portal';
        activate();
        ////////////////

        function activate() {
        }
    }
})();