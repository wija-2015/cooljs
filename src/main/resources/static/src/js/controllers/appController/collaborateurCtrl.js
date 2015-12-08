app.controller("CollaborateurCtrl",function(Collaborateur,Manager,$scope){
           Collaborateur.findAll().then(function(d) {
    $scope.collaborateurs = d;
  });
         
    
          });

app.controller('ModalInstanceCtrlCollab', ['$scope','$http','$modalInstance','Manager', function($scope, $http,$modalInstance,Manager) {
  	$scope.collaborateur={} ;
	
    Manager.findAll().then(function(d) {
	    $scope.managers = d;
	  });
	  
    $scope.inserer_collab = function () {
    	//var params = $scope.collaborateur.Managerrh.idManagerrh ;
    	datas=$scope.collaborateur
		//$http.post("http://localhost:8181/collaborateurs/save",$scope.collaborateur)
    	$http({
    	    url: 'http://localhost:8181/collaborateurs/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		          console.log(response);
				  console.log(JSON.stringify($scope.collaborateur));
				  
				  $scope.cancel();
				  });

    };

    $scope.cancel = function () {
      $modalInstance.dismiss('cancel');
    };
    $scope.ok = function () {
      $modalInstance.close($scope.selected.item);
    };

  }])
  ; 

  app.controller('ModalDemoCtrlCollab', ['$http','$scope', '$modal', '$log', function($http,$scope, $modal, $log) {
    $scope.items = ['item1', 'item2', 'item3'];

    $scope.open = function (size) {
      var modalInstance = $modal.open({
        templateUrl: 'myModalContent.html',
        controller: 'ModalInstanceCtrlCollab',
        size: size,
        resolve: {
          items: function () {
            return $scope.items;
          }
        }
      });

      modalInstance.result.then(function (selectedItem) {
        $scope.selected = selectedItem;
      }, function () {
        $log.info('Modal dismissed at: ' + new Date());
      });
    };
  }])
  ; 