angular.module('webLibrary.controllers')

    .controller('BookController', ['$scope', '$routeParams', 'Book',
        function ($scope, $routeParams, Book) {
            Book.getById($routeParams.bookId).then(function (result) {
                $scope.book = result.data;
            });
        }]);