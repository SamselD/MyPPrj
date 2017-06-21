angular.module("ERSapp",[]).controller("ERSLoginCtrl", function($scope, $http) {

    $scope.login = function() {console.log('Login In progress...');
        makeUser($scope);
        
        $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";

        var username =$scope.username;
        var password = $scope.password;
        var userInfo = $.param({'username':username,'password':password})
        //console.log(angular.isString(userInfo)+" "+userInfo);
        
        $http({
            method : "POST",
            url : "LoginServelet",
            data : userInfo,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).success(function(response) {
        				console.log("Authorised");
        				console.log("OUT : "+response.ROLE);
        				var UserRole = response.ROLE;
                        switch (UserRole) {
                                case "Employee":
                                    window.location = 'Employee.html';
                                    break;
                                case "Manager":
                                    window.location = 'Manager.html';
                                    break;
                                default:
                                    $scope.username = '';
                                    $scope.password = '';
                                    window.location = 'index.html';
                            }
          
          })
        }
    
}); //end login controller

function makeUser($scope) {
    var user = {
        username: $scope.username,
        password: $scope.password
    };

    $scope.user = user;
}