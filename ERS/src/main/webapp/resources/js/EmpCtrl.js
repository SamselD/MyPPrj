angular.module("EmpApp",[]).controller("EmpCtrl", function($scope, $http,$location) {

    $scope.curCmd="";
    $scope.reimburseOptions=[];
    $scope.Username="";
    $scope.Password="";
    
    $scope.command= function(cmdName){
    	$scope.curCmd = cmdName;
    	console.log("cmd : "+cmdName);
    	
    	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";

    	switch(cmdName){
	    	case "new":
		    		$scope.reimburseOptions[0]="Travel";
		    		$scope.reimburseOptions[1]="Certification";
		    		angular.element(document.querySelector( '#form_new' )).css('display', 'block');
		    		angular.element(document.querySelector( '#form_all' )).css('display', 'none');
		    		angular.element(document.querySelector( '#form_user' )).css('display', 'none');
		    		break;
		    		
	    	case "user":
	    			$http({
	    	            method : "POST",
	    	            url : "EmployeeServlet",
	    	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	    	        }).success(function(response) {
	    	        	console.log("Emp : "+response.username);
	    	        	console.log("Empsd : "+response.password);
	    	        	
			    		$scope.Username=response.username;
			    		$scope.Password=response.password;
	    	        })
 
		    		angular.element(document.querySelector( '#form_user' )).css('display', 'block');
		    		angular.element(document.querySelector( '#form_all' )).css('display', 'none');
		    		angular.element(document.querySelector( '#form_new' )).css('display', 'none');
		    		break;
		    		
	    	case "all":
		    		angular.element(document.querySelector( '#form_all' )).css('display', 'block');
		    		angular.element(document.querySelector( '#form_user' )).css('display', 'none');
		    		angular.element(document.querySelector( '#form_new' )).css('display', 'none');
		    		break;
		    		
	    	default:
	    			angular.element(document.querySelector( '#form_default' )).css('display', 'block');
	    			break;
    	}
    	
    	angular.element(document.querySelector( '#result' )).css('display', 'block');
    }
    
    $scope.submitForm=function(){
    	angular.element(document.querySelector( '#form_new' )).css('display', 'none');
    	angular.element(document.querySelector( '#result' )).css('display', 'none');
    }
    
    $scope.submitProfile=function(){
    	angular.element(document.querySelector( '#form_user' )).css('display', 'none');
    	angular.element(document.querySelector( '#result' )).css('display', 'none');
    }
    
    $scope.ViewForm=function(){
    	angular.element(document.querySelector( '#form_all' )).css('display', 'none');
    	angular.element(document.querySelector( '#result' )).css('display', 'none');
    }
});