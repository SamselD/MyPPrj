angular.module("EmpApp",[]).controller("EmpCtrl", function($scope, $http,$location) {

    $scope.curCmd="";
    $scope.reimburseOptions=[];
    $scope.Username="";
    $scope.Password="";
    
    $scope.Name="";
    $scope.UserId="";
    $scope.sOpt= "---Choose---";
    $scope.Amount="";
    $scope.Receipt="";
    $scope.Comments="";
    $scope.reimbursements;
    
    $scope.command= function(cmdName){
    	$scope.curCmd = cmdName;
    	console.log("cmd : "+cmdName);
    	
    	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
    	var cmdInfo = $.param({'command':cmdName})
    	switch(cmdName){
	    	case "new":
	    		$http({
    	            method : "POST",
    	            url : "EmployeeServlet",
    	            data: cmdInfo,
    	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
    	        }).success(function(response) {
		    		$scope.Name=response.user;
		    		$scope.UserId=response.userid;
		    		$scope.reimburseOptions=response.rTypeList;
    	        })
		    		angular.element(document.querySelector( '#form_new' )).css('display', 'block');
		    		angular.element(document.querySelector( '#form_all' )).css('display', 'none');
		    		angular.element(document.querySelector( '#form_user' )).css('display', 'none');
		    		break;
		    		
	    	case "user":
	    			$http({
	    	            method : "POST",
	    	            url : "EmployeeServlet",
	    	            data: cmdInfo,
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
		    		$http({
	    	            method : "POST",
	    	            url : "EmployeeServlet",
	    	            data: cmdInfo,
	    	            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
	    	        }).success(function(response) {
			    		
			    		$scope.reimbursements=response.reimbursements;
	    	        })
	    	        
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

function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("dev-table");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[3];
    if (td) {
    	console.log(td);
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

/**
*   I don't recommend using this plugin on large tables, I just wrote it to make the demo useable. It will work fine for smaller tables 
*   but will likely encounter performance issues on larger tables.
*
*		<input type="text" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
*		$(input-element).filterTable()
*		
*	The important attributes are 'data-action="filter"' and 'data-filters="#table-selector"'

(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);

$(function(){
    // attach table filter plugin to inputs
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})*/