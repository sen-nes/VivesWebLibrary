angular.module('webLibrary', ['webLibrary.controllers', 'ngRoute'])

    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider
                .when('/books', {
                    templateUrl: 'templates/books.html',
                    controller: 'BooksController'
                })
                
                .when('/books/:bookId', {
                    templateUrl: 'templates/book.jsp',
                    controller: 'BookController'
                })
                
                .when('/books/del/:delId', {
                    templateUrl: 'templates/del-book.jsp',
                    controller: 'RemoveController'
                })

                .otherwise({
                    redirectTo: '/books'
                })
        }]);