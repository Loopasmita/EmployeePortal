(function () {
    'use strict';
    angular
        .module('app.mainScreen')
        .controller('mainScreenCtrl', mainScreenCtrl);

    function mainScreenCtrl(webApiServices) {
        var vm = this;
        vm.pageName = 'Employee Portal';
        vm.register = register;
        vm.employeeList = [];
        vm.getAllEmployees = getAllEmployees;
        vm.register = register;
        vm.dataLength = 0;
        var colDef = [
                      { name: 'First Name', field: 'firstName' },
                      { name: 'Last Name', field: 'lastName' },
                      { name: 'Gender', field: 'gender' },
                      { name: 'DOB', field: 'dob' },
                      { name: 'Department', field: 'department' }
                  ];

        activate();
        ////////////////

        function activate() {
            createGrid();
            _setupMainView();
        }

        function _setupMainView() {
        getAllEmployees();
        }

        function  resetFields(){
        vm.fName = "";
        vm.lName = "";
        vm.gender = "";
        vm.dob = "";
        vm.dept = "";
        }

        function register(){
        var params = {
        'firstName' : vm.fName,
        'lastName': vm.lName,
        'gender': vm.gender,
        'dob': vm.dob,
        'department': vm.dept
        }
        webApiServices.registerEmployee(params).then(function (response)
        {
          if (response) {
               vm.employee = response.data;
               resetFields();
               getAllEmployees();
           }
       }).catch(function () {
            window.alert("Could not Register");
        });
        }
         function getAllEmployees(){
            webApiServices.getAllEmployeeList().then(function (response)
            {
              if (response) {
                   vm.employeeList = response.data.employeeList;
                   vm.gridOptions.data = vm.employeeList;
                   vm.dataLength = vm.gridOptions.data.length;
                   createGrid();
               }
           });
         }

         function createGrid(){
            vm.gridOptions = {
                         defaultColDef: {
                             alwaysShowVerticalScroll: true,
                             resizable: true
                         },
                         floatingFilter: false,
                         alwaysShowVerticalScroll: true,
                         debug: true,
                         onGridReady: getGrid,
                         columnDefs: colDef,
                         rowData: vm.employeeList
                     };
         }
       function getGrid(gridApi) {
                 vm.gridApi = gridApi;
                 gridApi.api.sizeColumnsToFit();
       }
    }
})();