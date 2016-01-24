angular.module('webLibrary.controllers')

    .controller('BooksController', ['$scope', 'Books',
        function ($scope, Books) {
            Books.getAll().then(function(result) {
                $scope.books = result.data;
            });
        }]);