app.controller("FeedbackCtrl",function(Collaborateur,Projet,$scope,$http){
	$scope.feedback={} ;
    Collaborateur.findAll().then(function(d) {
              $scope.collaborateurs = d;
            });  

    Projet.findAll().then(function(d) {
              $scope.projets = d;
            });
  	
    $scope.inserer_feedback = function () {
		
    	//var params = $scope.collaborateur.Managerrh.idManagerrh ;
    	datas=$scope.feedback
		//$http.post("http://localhost:8181/collaborateurs/save",$scope.collaborateur)
    	$http({
    	    url: 'http://localhost:8181/feedbacks/save',
    	    method: 'POST',
    	    data:datas
    	})
    	.success(function(response) {  
		          console.log(response);
				  console.log(JSON.stringify($scope.feedback));
				  $scope.newfeedback=response;
				  //$scope.feedback=response.idFeedback;
				  });
    };	
	
	$scope.vider = function () {
		$scope.feedback=null ;
	}
});



